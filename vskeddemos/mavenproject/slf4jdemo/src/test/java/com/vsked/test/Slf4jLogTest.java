package com.vsked.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jLogTest {
	
	private static final Logger log = LoggerFactory.getLogger(Slf4jLogTest.class);
	
	@Test
	public void t1(){
		log.trace("trace test");
		log.debug("debug test");
		log.info("info test");
		log.warn("warn test");
		log.error("error test");
	}

}
