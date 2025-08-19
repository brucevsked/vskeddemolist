package com.vsked.web;

import com.vsked.tool.JwtUtils;
import com.vsked.tool.Response;
import com.vsked.web.dto.LoginRequestDTO;
import com.vsked.web.dto.LoginResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt")
public class JWTCtl {

    private static final Logger log = LoggerFactory.getLogger(JWTCtl.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public Response<LoginResponseDTO> create(@RequestBody LoginRequestDTO authRequest){
        log.info("{},{}", authRequest.username(),authRequest.password());
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password())
            );
            if (authentication.isAuthenticated()) {
                String token = JwtUtils.generateToken(authRequest.username());
                LoginResponseDTO loginResponseDTO = new LoginResponseDTO(token);
                return new Response<>(200, "登录成功", loginResponseDTO);
            } else {
                return new Response<>(401, "认证失败", null);
            }
        } catch (Exception e) {
            return new Response<>(401, "用户名或密码错误", null);
        }
    }

}
