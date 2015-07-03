package com.vsked.data;

import java.util.Date;


public class VskUserT {
	
	//this id for gridx
	private int id;
	
	private int userId;
	private String userName;
	private String userNick;
	private String userPass;
	private int userAge;
	private Date regDate;
	private Date lastLoginDate;
	
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
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	
	public VskUserT(int userId, String userName, String userNick) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userNick = userNick;
	}
	
	public VskUserT(int id, int userId, String userName, String userNick) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.userNick = userNick;
	}
	public VskUserT(int userId, String userName, String userNick,String userPass, int userAge) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userNick = userNick;
		this.userPass = userPass;
		this.userAge = userAge;
	}
	public VskUserT(int userId, String userName, String userNick,String userPass, int userAge, Date regDate, Date lastLoginDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userNick = userNick;
		this.userPass = userPass;
		this.userAge = userAge;
		this.regDate = regDate;
		this.lastLoginDate = lastLoginDate;
	}
	

}
