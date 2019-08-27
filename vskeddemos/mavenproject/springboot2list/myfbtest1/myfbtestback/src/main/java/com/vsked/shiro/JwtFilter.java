package com.vsked.shiro;

import com.vsked.common.RequestResponseTool;
import com.vsked.common.RespCode;
import com.vsked.common.RespMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter {
	
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (JwtUtil.verify(request, response)) {
            try {
                executeLogin(request, response);
                Subject subject = getSubject(request, response);
                String url = getPathWithinApplication(request);
                return subject.isPermitted(url);
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

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}
