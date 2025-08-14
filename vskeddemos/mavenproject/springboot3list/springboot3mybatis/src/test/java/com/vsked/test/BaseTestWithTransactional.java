package com.vsked.test;

import com.vsked.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 包含事务控制的单元测试
 */
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BaseTestWithTransactional extends AbstractTransactionalTestNGSpringContextTests{

}
