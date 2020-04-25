package com.vsked.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vskedtest1")
public class User {
	
	@Id
	private Integer uid;
	private String username;
	private String usernick;

	public User() {
	}

	public User(Integer uid, String username, String usernick) {
		this.uid = uid;
		this.username = username;
		this.usernick = usernick;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsernick() {
		return usernick;
	}

	public void setUsernick(String usernick) {
		this.usernick = usernick;
	}
}
