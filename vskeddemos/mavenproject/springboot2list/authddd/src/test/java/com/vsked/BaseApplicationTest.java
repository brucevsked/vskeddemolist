package com.vsked;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BaseApplicationTest extends AbstractTestNGSpringContextTests {

}
