package com.vsked.domain.user;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserTest {
	
	private static final Logger log = LoggerFactory.getLogger(UserTest.class);
	
	@BeforeClass
    public void setup()
    {
        log.info("begin test");
    }
	@Test
    public void test1()
    {
        log.info("at test1");
    }
    @Test
    public void test2()
    {
        log.debug("at test2");
    }
    @Test
    public void test3()
    {
        log.error("at test3");
    }
    @AfterClass
    public void teardown()
    {
        log.info("end test");
    }

}
