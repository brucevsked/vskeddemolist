package com.vsked.test;

import com.vsked.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ProjectSpringBaseTest extends AbstractTestNGSpringContextTests{
}
