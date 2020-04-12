package com.vsked.cqrs;

public class UserEasyInvoker {
	private UserEasyCommand command;
	
	public UserEasyInvoker(UserEasyCommand command) {
		this.command=command;
	}
	
	public void action(UserEasy userEasy) {
		command.execute(userEasy);
	}
}
