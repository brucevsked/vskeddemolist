package com.vsked.test;

import org.apache.log4j.Logger;
import org.junit.Test;

public class T1 extends BaseTest{
	
	private static final Logger log = Logger.getLogger(T1.class);
	
	@Test
	public void tt(){
		log.debug(11);
	}

}
