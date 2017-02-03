package com.vsked.dao;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

	public Map<String, String> getUserByUserName(String userName){
		Map<String, String> userMap=null;
		if("admin".equals(userName)){
			userMap=new HashMap<String, String>();
			userMap.put("userId", "1");
			userMap.put("userName", "admin");
			userMap.put("userPass", "password");
			userMap.put("loginCount", "51");
		}
		return userMap;
	}
	
}
