package com.vsked.text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class Log4j2testNG7ApplicationTest {

	private static final Logger log = LoggerFactory.getLogger(Log4j2testNG7ApplicationTest.class);

	@Test
	public void hello() {
		log.trace("hello start");
	}
	
}
