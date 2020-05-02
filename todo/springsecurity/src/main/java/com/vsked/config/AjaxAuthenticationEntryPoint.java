package com.vsked.config;


import com.vsked.auth.model.AjaxResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger log = LoggerFactory.getLogger(AjaxAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        log.debug("|"+httpServletRequest.getRequestURI()+"|");

        AjaxResponseBody responseBody = new AjaxResponseBody();

        responseBody.setStatus("000");
        responseBody.setMsg("2Need Authorities!");

        httpServletResponse.getWriter().write(responseBody.toString());
    }
}
