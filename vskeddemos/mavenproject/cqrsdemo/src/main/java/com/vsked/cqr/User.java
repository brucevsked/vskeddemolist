package com.vsked.cqr;

public class User {
	
	private long userId;
	private String userName;
	private String userPass;
	
	public User(long userId, String userName, String userPass) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
	}

	public User query() {
		return null;
	}
	
	public void createUserCommand(User user) {
		System.out.println(user.userId+user.userName+user.userPass);
		System.out.println("you created a user");
	}
	
	public void editUserCommand(User user) {
		System.out.println("you edit a user");
	}
	
	public void deleteUserCommand(User user) {
		System.out.println("you delete a user");
	}

}
