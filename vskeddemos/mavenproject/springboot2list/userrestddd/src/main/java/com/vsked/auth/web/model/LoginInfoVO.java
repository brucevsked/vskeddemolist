package com.vsked.auth.web.model;

import org.apache.commons.lang3.Validate;
import java.io.Serializable;

public class LoginInfoVO implements Serializable {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginInfoVO(String username, String password) {
        Validate.notBlank(username,"user name require");
        Validate.notBlank(password,"password require");

        this.username = username;
        this.password = password;
    }

    public LoginInfoVO() {
    }

    @Override
    public String toString() {
        return "{" +
                "\"username\":\"" + username +
                "\", \"password\":\"" + password +
                "\"}";
    }
}
