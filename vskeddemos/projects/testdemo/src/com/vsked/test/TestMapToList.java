package com.vsked.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMapToList {
	public static void main(String[] args) {
		Map<String,String> m=new HashMap<String,String>();
		
		m.put("1", "a");
		m.put("2", "b");
		m.put("3", "c");
		m.put("4", "d");
		
		List<String> l=new ArrayList<String>(m.keySet());
//		List<String> l=new ArrayList<String>(m.values());
		
		for(int i=0;i<l.size();i++)
			System.out.println(l.get(i));
		
	}

}
