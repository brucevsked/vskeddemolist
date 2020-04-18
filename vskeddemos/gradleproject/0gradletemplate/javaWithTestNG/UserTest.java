package com.vsked.domain.user;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest {
	
	@BeforeClass
    public void setup()
    {
        System.out.println("begin test");
    }
	@Test
    public void test1()
    {
        System.out.println("at test1");
    }
    @Test
    public void test2()
    {
        System.out.println("at test2");
    }
    @Test
    public void test3()
    {
        System.out.println("at test3");
    }
    @AfterClass
    public void teardown()
    {
        System.out.println("end test");
    }

}
