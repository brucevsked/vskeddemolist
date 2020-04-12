package com.vsked.cqrs;


/**
 * 命令
 * @author vsked
 *
 */
public class UserEasyEditCommand implements UserEasyCommand {
	
	UserEasyWriteService userEasyWriteService;
	
	public UserEasyEditCommand(UserEasyWriteService userEasyWriteService) {
		this.userEasyWriteService=userEasyWriteService;
	}

	@Override
	public void execute(UserEasy userEasy) {
		userEasyWriteService.userEasyEdit(userEasy);
	}

}
