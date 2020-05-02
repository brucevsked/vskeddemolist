package com.vsked.config;

import com.vsked.auth.model.AjaxResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private static final Logger log = LoggerFactory.getLogger(AjaxAuthenticationFailureHandler.class);
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.debug("|"+httpServletRequest.getRequestURI()+"|");

        AjaxResponseBody responseBody = new AjaxResponseBody();

        responseBody.setStatus("400");
        responseBody.setMsg("Login Failure!");

        httpServletResponse.getWriter().write(responseBody.toString());
    }
}
