package com.vsked.test;

public class User {
	String userName;
	int userAge;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
	public User() {
	}
	
	public User(String userName, int userAge) {
		this.userName = userName;
		this.userAge = userAge;
	}
	
	
}
