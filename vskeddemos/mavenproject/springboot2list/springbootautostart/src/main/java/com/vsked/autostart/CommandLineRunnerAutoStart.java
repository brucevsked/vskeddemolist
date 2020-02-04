package com.vsked.autostart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerAutoStart implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(CommandLineRunnerAutoStart.class);

	@Override
	public void run(String... args) throws Exception {
		log.debug("CommandLineRunnerAutoStart----------5------only one,只启动了一次,第5个启动");
	}

}
