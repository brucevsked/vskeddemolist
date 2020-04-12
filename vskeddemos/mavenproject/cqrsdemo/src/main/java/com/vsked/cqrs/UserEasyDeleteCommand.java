package com.vsked.cqrs;


/**
 * 命令
 * @author vsked
 *
 */
public class UserEasyDeleteCommand implements UserEasyCommand {
	
	UserEasyWriteService userEasyWriteService;
	
	public UserEasyDeleteCommand(UserEasyWriteService userEasyWriteService) {
		this.userEasyWriteService=userEasyWriteService;
	}

	@Override
	public void execute(UserEasy userEasy) {
		userEasyWriteService.userEasyDelete(userEasy);
	}

}
