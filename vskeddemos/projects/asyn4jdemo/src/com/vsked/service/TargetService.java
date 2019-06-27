package com.vsked.service;

import java.util.HashMap;
import java.util.Map;


public class TargetService {
	
	public Map<String, Object> getUserById(String id){
		Map<String, Object> data=new HashMap<String, Object>();
		data.put("id", id);
		data.put("name", "yournameisok"+id);
		return data;
	}
	

}
