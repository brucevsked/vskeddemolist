package com.vsked.beans;

import java.io.Serializable;

public class Logs implements Serializable{
	
	private static final long serialVersionUID = -8494765884853357569L;
	
	public int id;
	public String logName;
	public String logDate;
	public int typeId;
	public int userId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Logs() {
		super();
	}
	
	
}
