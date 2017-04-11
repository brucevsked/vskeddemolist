package com.vsked.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	public Map<String, Object> getUserByName(String userName){
		Map<String, Object> userMap=new HashMap<String, Object>();
		userMap.put("userName", "admin");
		userMap.put("userPass", "admin");
		userMap.put("userAge", "18");
		userMap.put("userQq", "100100");
		return userMap;
	}

}
