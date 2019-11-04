package com.vsked.test;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.vsked.Application;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class BaseTest {
	
	@Resource
	private Environment evn;
	
//	@Test
	public void testEvn(){
		log.debug("|"+evn.toString()+"|");
	}
	

}
