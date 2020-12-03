package com.vsked.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class Log4j2Test {
	
	private static final Logger log=LogManager.getLogger(Log4j2Test.class);
	
	@Test
	public void testBase(){
		log.trace("trace test");
		log.debug("debug test");
		log.info("info test");
		log.warn("warn test");
		log.error("error test");
		log.fatal("fatal test");
	}
	
}
