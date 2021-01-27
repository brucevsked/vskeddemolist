package com.vsked.pattern1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class Singleton3Test {
	
	private static final Logger log = LoggerFactory.getLogger(Singleton3Test.class);
	
	@Test
	public void test(){
		Singleton3 t1=Singleton3.getInstance();
		log.debug("finish"+t1.toString());
	}
}
