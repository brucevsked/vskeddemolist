package com.vsked.common;

import com.vsked.test.BaseTestWithoutTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class TestJasyptUtils extends BaseTestWithoutTransactional {

	private static final Logger log = LoggerFactory.getLogger(TestJasyptUtils.class);
	
	@Test
	public void encrypt(){
		log.trace("start");
		String  password =JasyptUtils.encrypt("vskedtest", "123456789");
		log.debug("加密" + password);
		String passwords = JasyptUtils.decypt("vskedtest", "TyXCTTgY6e6/A3CW5Y6lRZKAo3WFGzoY");
		log.debug("解密" + passwords);
		log.trace("end");
	}	
	
}
