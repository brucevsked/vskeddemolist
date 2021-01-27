package com.vsked.pattern1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class Singleton1Test {
	
	private static final Logger log = LoggerFactory.getLogger(Singleton1Test.class);
	
	@Test
	public void test(){
		Singleton1 t1=Singleton1.getInstance();
		log.debug("finish"+t1.toString());
	}
}
