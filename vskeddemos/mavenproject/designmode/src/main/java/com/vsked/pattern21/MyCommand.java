package com.vsked.pattern21;

/**
 * 命令
 * @author vsked
 *
 */
public class MyCommand implements Command {
	
	private Receiver receiver;
	
	public MyCommand(Receiver receiver) {
		this.receiver=receiver;
	}

	@Override
	public void execute() {
		receiver.action();
	}

}
