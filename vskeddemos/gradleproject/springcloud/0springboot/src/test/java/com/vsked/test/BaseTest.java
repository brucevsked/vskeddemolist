package com.vsked.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class BaseTest extends AbstractTestNGSpringContextTests {

}
