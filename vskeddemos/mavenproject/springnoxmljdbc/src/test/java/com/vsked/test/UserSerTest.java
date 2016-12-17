package com.vsked.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.service.UserSer;

import static org.junit.Assert.*;

public class UserSerTest extends TestConfig{
	
	@Autowired
	UserSer userSer;
	
	@Test
	public void getUserById(){
		String suId="su1";
		Map<String, Object> userData=userSer.getSysUserBySuId(suId);
		assertNotNull(userData);
		System.out.println(userData);
	}

}
