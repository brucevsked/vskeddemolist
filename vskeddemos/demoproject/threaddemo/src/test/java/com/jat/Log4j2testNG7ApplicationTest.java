package com.jat;

import static org.testng.Assert.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class Log4j2testNG7ApplicationTest {

	private static final Logger log = LoggerFactory.getLogger(Log4j2testNG7Application.class);

	@Test
	public void hello() {
		if(log.isTraceEnabled()){
			log.trace("hello start");
		}

		Log4j2testNG7Application log4j2testNG7Application = new Log4j2testNG7Application();

		String accountName="jatCompany";
		String currenAccounttName = log4j2testNG7Application.hello(accountName);

		assertEquals("jatCompany", currenAccounttName);

		if(log.isTraceEnabled()){
			log.trace("hello end");
		}
	}
	
}
