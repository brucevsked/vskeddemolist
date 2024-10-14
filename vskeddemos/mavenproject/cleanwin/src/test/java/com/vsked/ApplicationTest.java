package com.vsked;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class ApplicationTest {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	Application app = new Application();

	@Test
	public void getCurrentOSUserName() {
		String userName = app.getCurrentOSUserName();
		log.info(userName);
	}

	
}
