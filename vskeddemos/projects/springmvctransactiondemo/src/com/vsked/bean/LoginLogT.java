package com.vsked.bean;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class LoginLogT implements Serializable {
	private static final long serialVersionUID = 1459719185651573957L;
	private int loginLog;
	private int userId;
	private String ip;
	private Timestamp loginDate;
	
	public int getLoginLog() {
		return this.loginLog;
	}
	
	public void setLoginLog(int loginLog) {
		this.loginLog = loginLog;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getIp() {
		return this.ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public Date getLoginDate() {
		return this.loginDate;
	}
	
	public void setLoginDate(Timestamp loginDate) {
		this.loginDate = loginDate;
	}
}
