package com.custvs.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.custvs.common.MyBatisTest;

public class BaseServiceTest extends MyBatisTest{
	
	private static final Logger log=LoggerFactory.getLogger(BaseServiceTest.class);
	
	@Autowired
	BaseService baseService;

	@Test
	public void getJsonMessage() throws Exception{
		String code="0";
		String msg="登录成功";
		String s=baseService.getJsonMessage(code, msg);
		log.debug(s);
	}
}
