package com.vsked.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserSer {
	
	public Map<String, Object> getUserById(String suId){
		Map<String, Object> userData=null;
		try{
			userData=new HashMap<String, Object>();
			userData.put("suId", suId);
			userData.put("suName", "vsked");
			userData.put("suAge", "18");
			System.out.println(userData);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return userData;
	}

}
