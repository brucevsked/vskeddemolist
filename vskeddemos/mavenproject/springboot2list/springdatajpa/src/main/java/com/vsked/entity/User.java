package com.vsked.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {
	
	@Id
	private Integer uid;
	
	private String username;
	
	private String usernick;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Role> roles;
	
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
	
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * 注意这里需要有一个空构造方法
	 */
	public User() {
		super();
	}
	public User(Integer uid, String username, String usernick) {
		super();
		this.uid = uid;
		this.username = username;
		this.usernick = usernick;
	}

	public User(Integer uid, String username, String usernick, Set<Role> roles) {
		super();
		this.uid = uid;
		this.username = username;
		this.usernick = usernick;
		this.roles = roles;
	}
	
	
}
