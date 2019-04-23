package com.vsked.pattern1;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Singleton4Test {
	
	private static final Logger log = LoggerFactory.getLogger(Singleton4Test.class);
	
	@Test
	public void test(){
		Singleton4 t1=Singleton4.INSTANCE;
		log.debug("finish"+t1.toString());
	}
}
