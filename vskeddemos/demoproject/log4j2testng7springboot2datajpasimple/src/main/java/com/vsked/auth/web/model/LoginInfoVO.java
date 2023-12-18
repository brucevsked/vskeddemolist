package com.vsked.auth.web.model;

import java.io.Serializable;

public class LoginInfoVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String username;
	
    private String password;
    
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
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
        		"\"id\":\"" + id +
                "\"username\":\"" + username +
                "\", \"password\":\"" + password +
                "\"}";
    }

}