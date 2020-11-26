package com.vsked.test;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * null 表示对象为空
 * empty 表示对象为空或长度为0
 * blank 表示对象为空或长度为0或空格字符串
 * @author vsked
 *
 */
public class ValidateTest {
	
	private static final Logger log = LoggerFactory.getLogger(ValidateTest.class);
	
	@Test
	public void validateNull() {
		String a=null; // is null
		//log.info("anot null|"+Validate.notNull(a)+"|");
		//log.info("anot empty|"+Validate.notEmpty(a)+"|");
		//log.info("anot blank|"+Validate.notBlank(a)+"|");
		String b=""; //is empty
		log.info("bnot null|"+Validate.notNull(b)+"|");
		//log.info("bnot empty|"+Validate.notEmpty(b)+"|");
		//log.info("bnot blank|"+Validate.notBlank(b)+"|");
		String c=" ";//is blank
		log.info("cnot null|"+Validate.notNull(c)+"|");
		log.info("cnot empty|"+Validate.notEmpty(c)+"|");
		//log.info("cnot blank|"+Validate.notBlank(c)+"|");
		String d="   ";//is blank
		log.info("dnot null|"+Validate.notNull(d)+"|");
		log.info("dnot empty|"+Validate.notEmpty(d)+"|");
		//log.info("dnot blank|"+Validate.notBlank(d)+"|");
		String e="  e ";
		log.info("enot null|"+Validate.notNull(e)+"|");
		log.info("enot empty|"+Validate.notEmpty(e)+"|");
		log.info("enot blank|"+Validate.notBlank(e)+"|");
	}

}
