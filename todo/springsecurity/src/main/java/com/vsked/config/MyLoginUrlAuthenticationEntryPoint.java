package com.vsked.config;

import com.vsked.auth.model.AjaxResponseBody;
import com.vsked.auth.model.RespModel;
import com.vsked.auth.service.SelfUserDetails;
import com.vsked.common.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.*;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class MyLoginUrlAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger log = LoggerFactory.getLogger(MyLoginUrlAuthenticationEntryPoint.class);

    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {


        log.debug("|"+request.getMethod()+"|"+request.getRequestURI()+"|");
        PrintWriter out = response.getWriter();

        if(!"post".equals(request.getMethod().toLowerCase()) && !"/login".equals(request.getRequestURI()) ){
            log.debug("no permission,please check login,or check token parameter");
            // redirect to login page. Use https if forceHttps true
            response.setContentType("application/json;charset=utf-8");


            RespModel noPermissionModel = new RespModel("-1", "please login or check token(x-access-token)", "");
            out.write(noPermissionModel.toString());
            out.flush();
            out.close();
        }else{
            String username=request.getParameter("username");
            log.debug("===================login");
            AjaxResponseBody responseBody = new AjaxResponseBody();

            responseBody.setStatus("200");
            responseBody.setMsg("Login Success!");

            String jwtToken = JwtTokenUtil.generateToken(username, 300, "_secret");
            RespModel noPermissionModel = new RespModel("0", "loginok", jwtToken);
            out.write(noPermissionModel.toString());
            out.flush();
            out.close();


        }


    }

}

