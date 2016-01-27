package com.vsked.dao;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Map<String, String> m=new HashMap<String, String>();
		m.put("s1", "v2");
		
		System.out.println(m.get("s1"));
		System.out.println(m.get("s2"));

	}

}
