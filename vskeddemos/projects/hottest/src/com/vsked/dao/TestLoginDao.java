package com.vsked.dao;

import java.util.HashMap;
import java.util.Map;

public class TestLoginDao {
	
	public static Map<String, String> getUser(String uname){
		Map<String, String> m=new HashMap<String, String>();
		m.put("uname", "vsked");
		m.put("upass", "vsked");
		return m;
	}


}
