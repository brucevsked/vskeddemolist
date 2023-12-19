package com.vsked;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Unit test for simple App.
 */
public class ApplicationTest {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@BeforeEach
	public void beforeTest(){
		log.debug("开始之前你可以搞点小动作");
	}

	@Test
	public void hello() {
		if(log.isTraceEnabled()){
			log.trace("hello start");
		}

		Application log4j2testNG7Application = new Application();

		String accountName="vskCompany";
		String currenAccounttName = log4j2testNG7Application.hello(accountName);

        assertEquals(accountName,currenAccounttName);//assertEquals(预期值,实际值)

		if(log.isTraceEnabled()){
			log.trace("hello end");
		}
	}

	@AfterEach
	public void afterTest(){
		log.debug("结束之后不能来根烟");
	}

}
