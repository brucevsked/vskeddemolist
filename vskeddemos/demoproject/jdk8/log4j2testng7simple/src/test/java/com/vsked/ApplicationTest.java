package com.vsked;

import static org.testng.Assert.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class ApplicationTest {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@BeforeTest
	public void beforeTest(){
		log.debug("开始之前你可以搞点小动作");
	}

	@Test
	public void hello() {
		if(log.isTraceEnabled()){
			log.trace("hello start");
		}

		Application log4j2testNG7Application = new Application();

		String accountName="company";
		String currenAccounttName = log4j2testNG7Application.hello(accountName);

		assertEquals(currenAccounttName,accountName);//assertEquals(实际值,预期值)

		if(log.isTraceEnabled()){
			log.trace("hello end");
		}
	}

	@AfterTest
	public void afterTest(){
		log.debug("结束之后不能来根烟");
	}
	
}
