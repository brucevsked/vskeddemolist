package com.vsked.bean;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class UsersT implements Serializable{
	private static final long serialVersionUID = 8512232150740904194L;
	
	private int userId;
	private String userName;
	private String password;
	private int credits;
	private String lastIp;
	private Timestamp lastVisit;	
	
	public int getUserId () {
		return this.userId;
	}
	
	public void setUserId (int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword(String password) {
		return this.password;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public String getLastIp() {
		return this.lastIp;
	}
	
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	
	public Date getLastVisit() {
		return this.lastVisit;
	}
	
	public void setLastVisit(Timestamp lastVisit) {
		this.lastVisit = lastVisit;
	}
 }	
