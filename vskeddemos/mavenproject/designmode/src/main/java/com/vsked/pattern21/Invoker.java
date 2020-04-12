package com.vsked.pattern21;

/**
 * 司令
 * @author vsked
 *
 */
public class Invoker {
	
	private Command command;
	
	public Invoker(Command command) {
		this.command=command;
	}
	
	public void action() {
		command.execute();
	}

}
