package com.junit5.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class Junit5DemoTest {
	
	private static final Logger log=LoggerFactory.getLogger(Junit5DemoTest.class);
	
	@BeforeAll
    public static void initializeExternalResources() {
        log.info("只执行一次，执行时机是在所有测试和 @BeforeEach 注解方法之前。");
    }
 
    @BeforeEach
    public void initializeMockObjects() {
        log.info("在每个测试执行之前执行。");
    }
 
    @Test
    public void someTest() {
    	log.info("ceshi......");
    }
 
/* 
    @Test
    @Disabled
    public void disabledTest() {
        System.exit(1);
    }*/
 
    @AfterEach
    public void tearDown() {
    	log.info("在每个测试执行之后执行。");
    }
 
    @AfterAll
    public static void freeExternalResources() {
    	log.info("只执行一次，执行时机是在所有测试和 @AfterEach 注解方法之后。");
    }

	@Test
	public void testAdd() {
//		fail("Not yet implemented");
		log.info("测试1");
	}

	@Test
	public void testSubtract() {
//		fail("Not yet implemented");
		log.info("测试2");
	}
	
	@Test
	public void testBase(){
		log.trace("trace test");
		log.debug("debug test");
		log.info("info test");
		log.warn("warn test");
		log.error("error test");
	}

}
