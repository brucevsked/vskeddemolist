package com.vsked.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import com.vsked.Application;

@SpringBootTest(classes = Application.class,properties = "spring.config.location=classpath:application-dev.yml")
public class BaseTestWithoutTransactional extends AbstractTestNGSpringContextTests{

}
