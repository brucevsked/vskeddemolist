package com.vsked.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vsked.bean.HelloWorld;
import com.vsked.config.AppConfig;


public class HelloWorldTest extends TestConfig{
	
	@Autowired
	HelloWorld helloWorld;
	
	public static void main(String[] args) {
		 ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		 HelloWorld obj = (HelloWorld) context.getBean(HelloWorld.class);

		 obj.say("Spring4 Java Config");
	}
	
	@Test
	public void sayTest(){
		helloWorld.say("vsked");
	}
	

}
