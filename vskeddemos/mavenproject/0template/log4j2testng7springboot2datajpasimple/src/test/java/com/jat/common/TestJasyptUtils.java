package com.jat.common;

import com.jat.test.BaseTestWithoutTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class TestJasyptUtils extends BaseTestWithoutTransactional {

	private static final Logger log = LoggerFactory.getLogger(TestJasyptUtils.class);
	
	@Test
	public void encrypt(){
		log.trace("start");
		String  password =JasyptUtils.encrypt("junantai", "root");
		log.debug("加密" + password);
		String passwords = JasyptUtils.decypt("junantai", "tbKZkQjZQiJ229X32lo+uM0H/D0DI1qd");
		log.debug("解密" + passwords);
		log.trace("end");
	}	
	
}
