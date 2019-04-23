package com.vsked.pattern1;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Singleton5Test {
	
	private static final Logger log = LoggerFactory.getLogger(Singleton5Test.class);
	
	@Test
	public void test(){
		Singleton5 t1=Singleton5.getInstance();
		log.debug("finish"+t1.toString());
	}
}
