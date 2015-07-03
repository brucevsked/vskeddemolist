package com.vsked.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestListCompare {

	public static void main(String[] args) {
		List<Map> t1=new ArrayList<Map>();
		List<Map> t2=new ArrayList<Map>();
		
		
		for(int i=0;i<10;i++){
		Map<String, String> m1=new HashMap<String, String>();
		m1.put("playerCardNum", ""+i);
		m1.put("hairStyle", "1"+i);
		m1.put("faceStyle", "2"+i);
		m1.put("clothesStyle", "3"+i);
		m1.put("clothesStyle", "4"+i);
		m1.put("weaponStyle", "5"+i);
		m1.put("hatStyle", "6");
		m1.put("glassesStyle", "7");
		t1.add(m1);
		}
		for(int i=8;i<20;i++){
			Map<String, String> m1=new HashMap<String, String>();
			m1.put("playerCardNum", ""+i);
			m1.put("hairStyle", "1"+i);
			m1.put("faceStyle", "2"+i);
			m1.put("clothesStyle", "3"+i);
			m1.put("clothesStyle", "4"+i);
			m1.put("weaponStyle", "5"+i);
			m1.put("hatStyle", "6");
			m1.put("glassesStyle", "7");
			t2.add(m1);
		}
		
		List<Map> tmpL=new ArrayList<Map>();
		
		for(Map m:t1){
			for(Map mt:t2){
				if(mt.get("playerCardNum").equals(m.get("playerCardNum"))){
					tmpL.add(getCRMap(m, mt));
				}
			}
		}
	}
	
	public static Map getCRMap(Map m1,Map m2){
		Object[] ak=m1.keySet().toArray();
		for(int i=0;i<ak.length;i++){
			if(m1.get(ak[i]).equals(m2.get(ak[i]))){
				m1.put(ak[i], m2.get(ak[i]));
			}
		}
		return m1;
	}

}
