package com.vsked.beans;

import java.io.Serializable;

public class Comment implements Serializable{

	private static final long serialVersionUID = -8119549924686391291L;
	
	private long id;
	private String userid;
	private long pictureid;
	private String content;
	private String createtime;
	private String lasttime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public long getPictureid() {
		return pictureid;
	}
	public void setPictureid(long pictureid) {
		this.pictureid = pictureid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getLasttime() {
		return lasttime;
	}
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	public Comment() {
		super();
	}
	
}
