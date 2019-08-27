package com.vsked.shiro;

import lombok.Getter;
import org.apache.shiro.authc.AuthenticationToken;

@Getter
public class Token implements AuthenticationToken {

    private static final long serialVersionUID = 1L;

    private String token;

    public Token(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
