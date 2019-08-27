package com.vsked.shiro;

import com.vsked.common.RequestResponseTool;
import com.vsked.common.RespCode;
import com.vsked.common.RespMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter {
	
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (JwtUtil.verify(request, response)) {
            try {
                executeLogin(request, response);
                return true;
            } catch (Exception e) {
                log.error("身份校验失败");
                try {
                    RequestResponseTool.respJson(RequestResponseTool.getJsonMessage(RespCode.authPassFail, RespMsg.authPassFail), response);
                } catch (Exception e1) {
                    log.error(e1.getMessage(),e1);
                }
            }
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
    	try{
    	RequestResponseTool.respJson(RequestResponseTool.getJsonMessage(RespCode.authJwtNoPermission,RespMsg.authJwtNoPermission), servletResponse);
    	}catch(Exception e){
    		log.error("拒绝访问无权限"+e.getMessage(),e);
    	}
        return false;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        String headToken = WebApplicationUtil.getToken(request);
        Token token = new Token(headToken);
        this.getSubject(request, response).login(token);
        return true;
    }
}
