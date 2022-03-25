package com.vsked.test;

import com.vsked.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 不包含事务控制,且不包含spring的单元测试
 */
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BaseTestWithoutTransactional extends AbstractTestNGSpringContextTests {

}
