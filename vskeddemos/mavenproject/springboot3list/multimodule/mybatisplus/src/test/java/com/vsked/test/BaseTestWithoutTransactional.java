package com.vsked.test;

import com.vsked.MybatisPlusApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest(classes = MybatisPlusApplication.class)
public class BaseTestWithoutTransactional extends AbstractTestNGSpringContextTests{

}
