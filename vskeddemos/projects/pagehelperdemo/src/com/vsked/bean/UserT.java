package com.vsked.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserT implements Serializable{
	
	private static final long serialVersionUID = 3918888702432763825L;
	private int userId;
    private String userName;
    private String userNickName;
    private String userPass;
    private Timestamp regTime;
    private Timestamp lastLoginTime;
    
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
	public UserT(int userId, String userName, String userNickName,	String userPass, Timestamp regTime, Timestamp lastLoginTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userNickName = userNickName;
		this.userPass = userPass;
		this.regTime = regTime;
		this.lastLoginTime = lastLoginTime;
	}
	
	@Override
	public String toString() {
		return "UserT [userId=" + userId + ", userName=" + userName+", userNickName="+userNickName+",userPass="+userPass + ", regTime=" + regTime + ", lastLoginTime=" + lastLoginTime + "]";
	}
    
    
}
