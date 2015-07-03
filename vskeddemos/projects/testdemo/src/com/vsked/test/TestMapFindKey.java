package com.vsked.test;

import java.util.Map;
import java.util.TreeMap;

public class TestMapFindKey {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, String> m=new TreeMap<String, String>();
		m.put("a1", "111");
		m.put("b1", "222");
		m.put("c1", "333");
		m.put("d1", "444");
		
		System.out.println("K1:"+m.containsKey("a1"));
		System.out.println("K2:"+m.containsKey("f1"));
		
		System.out.println("V1:"+m.containsValue("111"));
		System.out.println("V2:"+m.containsValue("555"));

	}

}
