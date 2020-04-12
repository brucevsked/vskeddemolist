package com.vsked.cqrs;


/**
 * 命令
 * @author vsked
 *
 */
public class UserEasyCreateCommand implements UserEasyCommand {
	
	UserEasyWriteService userEasyWriteService;
	
	public UserEasyCreateCommand(UserEasyWriteService userEasyWriteService) {
		this.userEasyWriteService=userEasyWriteService;
	}

	@Override
	public void execute(UserEasy userEasy) {
		userEasyWriteService.userEasyAdd(userEasy);
	}

}
