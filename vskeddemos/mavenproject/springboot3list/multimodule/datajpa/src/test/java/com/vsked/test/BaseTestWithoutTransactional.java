package com.vsked.test;

import com.vsked.DataJPAApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest(classes = DataJPAApplication.class)
public class BaseTestWithoutTransactional extends AbstractTestNGSpringContextTests{

}
