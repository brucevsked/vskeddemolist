package com.vsked.config;


import com.vsked.auth.model.AjaxResponseBody;
import com.vsked.auth.service.SelfUserDetails;
import com.vsked.common.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger log = LoggerFactory.getLogger(AjaxAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        log.debug("|"+httpServletRequest.getRequestURI()+"|");
        AjaxResponseBody responseBody = new AjaxResponseBody();

        responseBody.setStatus("200");
        responseBody.setMsg("Login Success!");

        SelfUserDetails userDetails = (SelfUserDetails) authentication.getPrincipal();

        String jwtToken = JwtTokenUtil.generateToken(userDetails.getUsername(), 300, "_secret");
        responseBody.setJwtToken(jwtToken);

        httpServletResponse.getWriter().write(responseBody.toString());
    }
}

