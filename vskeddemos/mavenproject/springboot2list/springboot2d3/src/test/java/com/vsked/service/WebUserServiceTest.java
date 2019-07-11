package com.vsked.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.BaseTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebUserServiceTest extends BaseTest{
	
	@Autowired
	WebUserService webUserService;
	/*
//	@Test
	public void add(){
		Map<String, Object> data=new HashMap<String, Object>();
		data.put("uid", "testaa1902");
		data.put("username", "testvsked902");
		data.put("userpass", "902");
		data.put("phone", "902");
		webUserService.webUserAdd(data);
	}
	
	@Test
	public void list(){
		Map<String, Object> data=new HashMap<String, Object>();
		data.put("start", 1);
		data.put("length", 1);
		String s=webUserService.list(data);
		data.put("start", 1);
		data.put("length", 1);
		String s1=webUserService.list(data);
		data.put("start", 1);
		data.put("length", 5);
		String s2=webUserService.list(data);
		String s3=webUserService.list(data);
		String s4=webUserService.list(data);
		log.info("|"+s+"|");
		log.info("|"+s1+"|");
		log.info("|"+s2+"|");
		log.info("|"+s3+"|");
		log.info("|"+s4+"|");
	}
*/
}
