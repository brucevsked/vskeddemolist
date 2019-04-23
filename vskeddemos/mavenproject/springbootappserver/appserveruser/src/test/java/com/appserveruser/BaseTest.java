package com.appserveruser;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.appserveruser.Application;

@RunWith(SpringRunner.class)
@MapperScan("com.appserveruser.mapper")
@SpringBootTest(classes=Application.class)
public class BaseTest {
	
	private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
	
	@Resource
	private Environment evn;
	
//	@Test
	public void testEvn(){
		log.debug("|"+evn.toString()+"|");
	}
	

}
