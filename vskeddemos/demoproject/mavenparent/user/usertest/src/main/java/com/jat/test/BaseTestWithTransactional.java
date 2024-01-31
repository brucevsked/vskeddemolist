package com.jat.test;

import com.jat.UserApplicationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 包含事务控制的单元测试
 */
@SpringBootTest(classes = UserApplicationTest.class)
@WebAppConfiguration
public class BaseTestWithTransactional extends AbstractTransactionalTestNGSpringContextTests{

}
