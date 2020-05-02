package com.vsked.config;

import com.vsked.auth.model.RespModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

        log.debug("no permission,please check login,or check token parameter");
        // redirect to login page. Use https if forceHttps true
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();

        RespModel noPermissionModel = new RespModel("-1", "please login or check token(x-access-token)", "");
        out.write(noPermissionModel.toString());
        out.flush();
        out.close();
    }

}

