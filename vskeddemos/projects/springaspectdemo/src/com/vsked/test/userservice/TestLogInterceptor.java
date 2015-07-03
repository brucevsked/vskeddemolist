package com.vsked.test.userservice;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestLogInterceptor {

	@Test
	public void testLogInterceptor() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("WebRoot/WEB-INF/applicationContext.xml");
		UserManagerApplogic userManager = (UserManagerApplogic) ctx	.getBean("userManager");
		userManager.addUser("mynameisvsked");
		((AbstractApplicationContext) ctx).destroy();
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("WebRoot/WEB-INF/applicationContext.xml");
		UserManagerApplogic userManager = (UserManagerApplogic) ctx	.getBean("userManager");
		userManager.addUser("mynameisvsked");
		((AbstractApplicationContext) ctx).destroy();
	}

}
