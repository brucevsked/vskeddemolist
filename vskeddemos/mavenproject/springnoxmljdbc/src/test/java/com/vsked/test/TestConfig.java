package com.vsked.test;

import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import org.springframework.test.context.web.WebAppConfiguration;  

import com.vsked.config.AppConfig;
import com.vsked.config.AppDataSourceConfig;
import com.vsked.config.WebMvcConfig;

//指定测试类的运行者  
@RunWith(SpringJUnit4ClassRunner.class)
//指定spring配置类  
@ContextConfiguration(classes = {AppConfig.class,AppDataSourceConfig.class,WebMvcConfig.class})
//that the ApplicationContext loaded for an integration test should be a WebApplicationContext.
@WebAppConfiguration
public class TestConfig {
	
}
