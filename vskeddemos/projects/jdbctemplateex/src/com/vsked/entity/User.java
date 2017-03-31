package com.vsked.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private static final long serialVersionUID = 8512232150740904194L;
	private int usId;
	private String usName;
	private String usPass;
	private int usCredits;
	private String usLastIp;
	private Date usLastVisit;
	
	public int getUsId() {
		return usId;
	}
	public void setUsId(int usId) {
		this.usId = usId;
	}
	public String getUsName() {
		return usName;
	}
	public void setUsName(String usName) {
		this.usName = usName;
	}
	public String getUsPass() {
		return usPass;
	}
	public void setUsPass(String usPass) {
		this.usPass = usPass;
	}
	public int getUsCredits() {
		return usCredits;
	}
	public void setUsCredits(int usCredits) {
		this.usCredits = usCredits;
	}
	public String getUsLastIp() {
		return usLastIp;
	}
	public void setUsLastIp(String usLastIp) {
		this.usLastIp = usLastIp;
	}
	public Date getUsLastVisit() {
		return usLastVisit;
	}
	public void setUsLastVisit(Date usLastVisit) {
		this.usLastVisit = usLastVisit;
	}	
	
 }	
