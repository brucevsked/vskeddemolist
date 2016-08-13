package com.vsked.bean;

public class User {
	private String usId;
	private String usName;
	private String usPass;
	private int usAge;
	private boolean isMarry;
	
	public String getUsId() {
		return usId;
	}
	public void setUsId(String usId) {
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
	public int getUsAge() {
		return usAge;
	}
	public void setUsAge(int usAge) {
		this.usAge = usAge;
	}
	public boolean isMarry() {
		return isMarry;
	}
	public void setMarry(boolean isMarry) {
		this.isMarry = isMarry;
	}
	public User() {
		super();
	}
	public User(String usId, String usName, String usPass, int usAge,
			boolean isMarry) {
		super();
		this.usId = usId;
		this.usName = usName;
		this.usPass = usPass;
		this.usAge = usAge;
		this.isMarry = isMarry;
	}
	
}
