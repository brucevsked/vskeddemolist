package com.vsked.test;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenerateTest {
	
	private static final Logger log = LoggerFactory.getLogger(GenerateTest.class);
	
	@Test
	public void generateRandomStringUtils(){
		String num=RandomStringUtils.randomAlphanumeric(20);//随机字符将从拉丁字母（a-z、A-Z）和数字0-9中选择
		log.debug("randomAlphanumeric|"+num+"|");
		num=RandomStringUtils.randomAlphabetic(20);//随机字符将从拉丁字母（a-z、A-Z的选择
		log.debug("randomAlphabetic|"+num+"|");
		num=RandomStringUtils.randomNumeric(20);//随机数字
		log.debug("randomNumeric|"+num+"|");
		num=RandomStringUtils.randomAscii(15);//从ASCII 32到126组成的随机字符串
		log.debug("randomAscii|"+num+"|");
		num=RandomStringUtils.randomGraph(20);//数字字母大小写特殊符号
		log.debug("randomGraph|"+num+"|");
	}

}
