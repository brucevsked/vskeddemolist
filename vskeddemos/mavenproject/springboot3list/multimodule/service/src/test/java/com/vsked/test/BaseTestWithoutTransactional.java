package com.vsked.test;

import com.vsked.ServiceApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest(classes = ServiceApplication.class)
public class BaseTestWithoutTransactional extends AbstractTestNGSpringContextTests{

}
