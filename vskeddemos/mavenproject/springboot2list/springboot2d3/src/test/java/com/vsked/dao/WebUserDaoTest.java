package com.vsked.dao;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.BaseTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebUserDaoTest extends BaseTest{
	
	@Autowired
	WebUserDao webUserDao;
	
	@Test
	public void add(){
		Map<String, Object> data=new HashMap<String, Object>();
		data.put("uid", "testaa1");
		data.put("username", "testvsked");
		data.put("userpass", "901");
		data.put("phone", "901");
		int rows=webUserDao.webUserAdd(data);
		log.info("|"+rows+"|");
	}

}
