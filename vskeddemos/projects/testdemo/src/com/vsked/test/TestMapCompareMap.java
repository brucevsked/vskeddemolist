package com.vsked.test;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TestMapCompareMap {
	
	public static void main(String[] args) {
		
		Map<String, String> m1=new TreeMap<String, String>();
		
		Map<String, String> m2=new TreeMap<String, String>();
		
		m1.put("a", "1");
		m1.put("b", "2");
		m1.put("c", "3");
		m1.put("c", "ft");
		
		m2.put("a", "1");
		m2.put("b", "2");
		m2.put("c", "3");
		System.out.println("---------"+m1.get("c"));
		System.out.println(m1.size());
		System.out.println(m2.size());
		System.out.println(m1.keySet().size());
		System.out.println(m2.keySet().size());
		
		System.out.println(isSameMap(m1, m2));
		
		
	}
	
	public static boolean isSameMap(Map<String, String> m1,Map<String, String> m2){
		boolean flag=true;
		Iterator<Map.Entry<String, String>> it = m1.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> e = it.next();
			if((!m2.containsKey(e.getKey())) || (!m2.containsValue(e.getValue())))
				return false;
		}
		return flag;
	}

}
