package com.vsked.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.BaseTest;

public class WebUserServiceTest extends BaseTest{
	
	@Autowired
	WebUserService webUserService;
	
	@Test
	public void add(){
		Map<String, Object> data=new HashMap<String, Object>();
		data.put("uid", "testaa1902");
		data.put("username", "testvsked902");
		data.put("userpass", "902");
		data.put("phone", "902");
		webUserService.add(data);
	}

}
