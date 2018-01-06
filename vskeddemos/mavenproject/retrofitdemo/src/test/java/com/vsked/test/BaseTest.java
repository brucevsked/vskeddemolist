package com.vsked.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class BaseTest {
	
	private static final Logger log=LogManager.getLogger(BaseTest.class);
	
	@Test
	public void test1(){
		log.debug("base test a1");
	}
	

}
