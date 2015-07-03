package com.vsked.entity;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable {
	private static final long serialVersionUID = 1459719185651573957L;
	private int loginLog;
	private int userId;
	private String ip;
	private Date loginDate;
	
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
	
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
}
