package com.vsked.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import com.vsked.Application;

@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BaseTestWithoutTransactional extends AbstractTestNGSpringContextTests{

}
