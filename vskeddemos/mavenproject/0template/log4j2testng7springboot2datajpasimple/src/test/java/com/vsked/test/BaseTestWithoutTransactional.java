package com.vsked.test;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * 不包含事务控制,且不包含spring的单元测试
 */
public class BaseTestWithoutTransactional extends AbstractTestNGSpringContextTests {

}
