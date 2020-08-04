package com.jat.auth.web.model;

import java.io.Serializable;

public class LoginInfoVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
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
