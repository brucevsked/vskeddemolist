package com.vsked.autostart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerAutoStart implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(ApplicationRunnerAutoStart.class);

	@Override
	public void run(String... args) throws Exception {
		log.debug("ApplicationRunnerAutoStart----------4------only one,只启动了一次,第4个启动");
	}

}
