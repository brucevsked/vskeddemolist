package com.vsked.test;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class StringUtilsTest {
	
	private static final Logger log = LoggerFactory.getLogger(StringUtilsTest.class);
	
    @Test
	public void isBlank() {
		log.info("1:"+StringUtils.isBlank(null)); //true
		log.info("2:"+StringUtils.isBlank(""));   //true
		log.info("3:"+StringUtils.isBlank(" "));  //true
		log.info("4:"+StringUtils.isBlank("  ")); //true
		log.info("5:"+StringUtils.isBlank("S"));  //false
		log.info("6:"+StringUtils.isBlank("s"));  //false
	}

}
