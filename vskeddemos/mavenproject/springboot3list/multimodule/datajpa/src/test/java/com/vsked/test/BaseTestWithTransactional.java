package com.vsked.test;

import com.vsked.DataJPAApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

/**
 * 包含事务控制的单元测试
 */
@SpringBootTest(classes = DataJPAApplication.class)
public class BaseTestWithTransactional extends AbstractTransactionalTestNGSpringContextTests{

}
