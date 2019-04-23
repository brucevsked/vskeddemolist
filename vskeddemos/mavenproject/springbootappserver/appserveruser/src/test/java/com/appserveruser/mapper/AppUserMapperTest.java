package com.appserveruser.mapper;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.appserveruser.BaseTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppUserMapperTest extends BaseTest{
	
	@Autowired
	AppUserMapper appUserMapper;
	
	@Test
	public void getAppUserByUserName(){
		String username="test";
		Map<String, Object> dataMap=appUserMapper.getAppUserByUserName(username);
		log.debug("|"+dataMap+"|");
	}

}
