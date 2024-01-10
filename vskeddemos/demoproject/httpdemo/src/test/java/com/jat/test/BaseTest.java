package com.jat.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import com.jat.auth.Application;

@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BaseTest extends AbstractTestNGSpringContextTests{

}
