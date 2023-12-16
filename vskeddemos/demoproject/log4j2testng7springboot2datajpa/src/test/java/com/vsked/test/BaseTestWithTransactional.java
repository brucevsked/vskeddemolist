package com.vsked.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import com.vsked.Log4j2testng7springboot2datajpaApplication;

/**
 * 包含事务控制的单元测试
 */
@SpringBootTest(classes = Log4j2testng7springboot2datajpaApplication.class)
@WebAppConfiguration
public class BaseTestWithTransactional extends AbstractTransactionalTestNGSpringContextTests{

}
