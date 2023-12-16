package com.vsked.test;

import com.vsked.Log4j2testng7springboot2datajpaApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 不包含事务控制的单元测试
 */
@SpringBootTest(classes = Log4j2testng7springboot2datajpaApplication.class)
@WebAppConfiguration
public class BaseTestWithoutTransactional extends AbstractTestNGSpringContextTests {

}
