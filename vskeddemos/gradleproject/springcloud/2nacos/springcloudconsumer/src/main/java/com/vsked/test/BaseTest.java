package com.vsked.test;

import com.vsked.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;


@SpringBootTest(classes=Application.class)
public class BaseTest extends AbstractTestNGSpringContextTests {

}
