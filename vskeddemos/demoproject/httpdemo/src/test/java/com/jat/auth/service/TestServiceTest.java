package com.jat.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import com.jat.test.BaseTest;

public class TestServiceTest extends BaseTest{
	
	private static final Logger log = LoggerFactory.getLogger(TestServiceTest.class);
	
	@Autowired
	TestService testService;
	
    @Test
    public void test1() throws Exception {
    	log.info("TestServiceTest end " + testService.test1());
    }

}
