package com.vsked.pattern1;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Singleton2Test {
	
	private static final Logger log = LoggerFactory.getLogger(Singleton2Test.class);
	
	@Test
	public void test(){
		Singleton2 t1=Singleton2.getInstance();
		log.debug("finish"+t1.toString());
	}
}
