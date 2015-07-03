package com.vsked.hibernate.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userT")
public class UserT implements Serializable {
	
	private static final long serialVersionUID = -6521431759699335855L;
	
	@Id @GeneratedValue
	@Column(name="userId")
	private int userId;
	
	@Column(name = "userName", length = 200, nullable = false , unique=true)
	private String userName;
	
	@Column(name = "userNickName", length = 200)
	private String userNickName;
	
	@Column(name = "userPass", length = 50, nullable = false)
	private String userPass;
	
	@Column(name = "regTime")
	private Timestamp regTime;
	
	@Column(name = "lastLoginTime")
	private Timestamp lastLoginTime;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public Timestamp getRegTime() {
		return regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	

	public UserT() {
		super();
	}

	public UserT(String userName, String userNickName, String userPass,	Timestamp lastLoginTime) {
		super();
		this.userName = userName;
		this.userNickName = userNickName;
		this.userPass = userPass;
		this.lastLoginTime = lastLoginTime;
	}
	
}
