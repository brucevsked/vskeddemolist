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
		String suId="nk";
		Map<String, Object> userData=userSer.getUserById(suId);
		assertNotNull(userData);
		System.out.println(userData);
	}

}
