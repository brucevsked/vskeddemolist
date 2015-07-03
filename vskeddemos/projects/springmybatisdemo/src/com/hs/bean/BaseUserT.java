package com.hs.bean;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="baseUserT")
public class BaseUserT implements Serializable{

	private static final long serialVersionUID = 6024801528883494913L;
	
	private int buId;
	private int buSeq;
	private String buLoginId;
	private String buLoginName;
	private String buLoginMobile;
	private String buLoginEmail;
	private String buLoginPass;
	private Blob buAvata;
	private String buAvataUrl;
	private int buStatus;
	private Date buRegTime;
	private Date buLastLoginTime;
	private String buLastLoginIp;
	private String buMemo;
	
	@Id
	public int getBuId() {
		return buId;
	}
	
	public void setBuId(int buId) {
		this.buId = buId;
	}
	
	@Column(name="buSeq")
	public int getBuSeq() {
		return buSeq;
	}
	
	public void setBuSeq(int buSeq) {
		this.buSeq = buSeq;
	}
	
	@Column(name="buLoginId")
	public String getBuLoginId() {
		return buLoginId;
	}
	
	public void setBuLoginId(String buLoginId) {
		this.buLoginId = buLoginId;
	}
	
	@Column(name="buLoginName")
	public String getBuLoginName() {
		return buLoginName;
	}
	
	public void setBuLoginName(String buLoginName) {
		this.buLoginName = buLoginName;
	}
	
	@Column(name="buLoginMobile")
	public String getBuLoginMobile() {
		return buLoginMobile;
	}
	
	public void setBuLoginMobile(String buLoginMobile) {
		this.buLoginMobile = buLoginMobile;
	}
	
	@Column(name="buLoginEmail")
	public String getBuLoginEmail() {
		return buLoginEmail;
	}
	
	public void setBuLoginEmail(String buLoginEmail) {
		this.buLoginEmail = buLoginEmail;
	}
	
	@Column(name="buLoginPass")
	public String getBuLoginPass() {
		return buLoginPass;
	}
	
	public void setBuLoginPass(String buLoginPass) {
		this.buLoginPass = buLoginPass;
	}
	
	@Column(name="buAvata")
	public Blob getBuAvata() {
		return buAvata;
	}
	
	public void setBuAvata(Blob buAvata) {
		this.buAvata = buAvata;
	}
	
	@Column(name="buAvataUrl")
	public String getBuAvataUrl() {
		return buAvataUrl;
	}
	
	public void setBuAvataUrl(String buAvataUrl) {
		this.buAvataUrl = buAvataUrl;
	}
	
	@Column(name="buStatus")
	public int getBuStatus() {
		return buStatus;
	}
	
	public void setBuStatus(int buStatus) {
		this.buStatus = buStatus;
	}
	
	@Column(name="buRegTime")
	public Date getBuRegTime() {
		return buRegTime;
	}
	
	public void setBuRegTime(Date buRegTime) {
		this.buRegTime = buRegTime;
	}
	
	@Column(name="buLastLoginTime")
	public Date getBuLastLoginTime() {
		return buLastLoginTime;
	}
	
	public void setBuLastLoginTime(Date buLastLoginTime) {
		this.buLastLoginTime = buLastLoginTime;
	}
	
	@Column(name="buLastLoginIp")
	public String getBuLastLoginIp() {
		return buLastLoginIp;
	}
	
	public void setBuLastLoginIp(String buLastLoginIp) {
		this.buLastLoginIp = buLastLoginIp;
	}
	
	@Column(name="buMemo")
	public String getBuMemo() {
		return buMemo;
	}
	
	public void setBuMemo(String buMemo) {
		this.buMemo = buMemo;
	}
	
	public BaseUserT() {
		super();
	}

	public BaseUserT(int buId, int buSeq, String buLoginId, String buLoginName,
			String buLoginMobile, String buLoginEmail, String buLoginPass,
			Blob buAvata, String buAvataUrl, int buStatus, Date buRegTime,
			Date buLastLoginTime, String buLastLoginIp, String buMemo) {
		super();
		this.buId = buId;
		this.buSeq = buSeq;
		this.buLoginId = buLoginId;
		this.buLoginName = buLoginName;
		this.buLoginMobile = buLoginMobile;
		this.buLoginEmail = buLoginEmail;
		this.buLoginPass = buLoginPass;
		this.buAvata = buAvata;
		this.buAvataUrl = buAvataUrl;
		this.buStatus = buStatus;
		this.buRegTime = buRegTime;
		this.buLastLoginTime = buLastLoginTime;
		this.buLastLoginIp = buLastLoginIp;
		this.buMemo = buMemo;
	}

}
