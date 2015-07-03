package com.vsked.test;

import java.util.HashMap;
import java.util.Map;

public class TestMapJoin {

	public static void main(String[] args) {
		
		Map m1=new HashMap();
		m1.put("hairStyle", "1");
		m1.put("faceStyle", "2");
		m1.put("clothesStyle", "3");
		m1.put("weaponStyle", "4");
		m1.put("hatStyle", "5");
		m1.put("glassesStyle", "6");
		
		Map m2=new HashMap();
		m2.put("hairStyle", "1");
		m2.put("faceStyle", "2");
		m2.put("clothesStyle", "3");
		m2.put("weaponStyle", "4");
		m2.put("hatStyle", "5");
		m2.put("glassesStyle", "7");
		
		Object[] ak= m2.keySet().toArray();
		Object[] av= m2.values().toArray();
		for(int i=0;i<av.length;i++){
			System.out.println(ak[i]+"|"+av[i]);
			if(!m2.get(ak[i]).equals(m1.get(ak[i]))) m1.put(ak[i], av[i]);
		}
		System.out.println(m1);
		
	}

}
