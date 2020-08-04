package com.jat.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.jat.test.BaseTest;

public class TestServiceTest extends BaseTest{
	
	private static final Logger log = LoggerFactory.getLogger(TestService.class);
	
	MockMvc mvc;
	
	@Autowired
	TestService testService;
	
    @BeforeClass
    public void initMvc(){
        mvc = MockMvcBuilders.standaloneSetup(testService).build();
    }
    
    @Test
    public void test1() throws Exception {
    	log.info("TestServiceTest end " + testService.test1());
    }

}
