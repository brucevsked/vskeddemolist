package com.vsked.config;

import com.vsked.auth.model.AjaxResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAccessDeniedHandler implements AccessDeniedHandler {

    private static final Logger log = LoggerFactory.getLogger(AjaxAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {

        log.debug("|"+httpServletRequest.getRequestURI()+"|");

        AjaxResponseBody responseBody = new AjaxResponseBody();

        responseBody.setStatus("300");
        responseBody.setMsg("Need Authorities!");

        httpServletResponse.getWriter().write(responseBody.toString());
    }
}
