package com.example.bookdemo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = BookdemoApplication.class)
@WebAppConfiguration
public class BaseTestWithoutTransactional extends AbstractTestNGSpringContextTests {

}
