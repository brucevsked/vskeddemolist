package com.vsked.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSort {

	public static void main(String[] args) {
		
		List<String> t1=new ArrayList<String>();
		t1.add("e");
		t1.add("c");
		t1.add("d");
		t1.add("b");
		t1.add("a");
		Collections.sort(t1);
		System.out.println(t1.toString());
		
		List<String> t2=new ArrayList<String>();
		t2.add("4");
		t2.add("5");
		t2.add("2");
		t2.add("3");
		t2.add("1");
		
		Collections.sort(t2);
		System.out.println(t2.toString());
		
		List<Map<String, Map>> t3=new ArrayList<Map<String,Map>>();
		
		Map<String,Map> tm1=new HashMap<String, Map>();
		Map<String, String> tmm1=new HashMap<String, String>();
		tmm1.put("v", "4");
		tm1.put("tmm1", tmm1);
		
		Map<String,Map> tm2=new HashMap<String, Map>();
		Map<String, String> tmm2=new HashMap<String, String>();
		tmm2.put("v", "5");
		tm2.put("tmm2", tmm2);
		
		Map<String,Map> tm3=new HashMap<String, Map>();
		Map<String, String> tmm3=new HashMap<String, String>();
		tmm3.put("v", "2");
		tm3.put("tmm3", tmm3);
		
		Map<String,Map> tm4=new HashMap<String, Map>();
		Map<String, String> tmm4=new HashMap<String, String>();
		tmm4.put("v", "3");
		tm4.put("tmm4", tmm4);
		
		Map<String,Map> tm5=new HashMap<String, Map>();
		Map<String, String> tmm5=new HashMap<String, String>();
		tmm5.put("v", "1");
		tm5.put("tmm5", tmm5);
		System.out.println(tm5.keySet().toArray()[0].toString());
		System.out.println(tm5.values().toArray()[0]);
		t3.add(tm1);
		t3.add(tm2);
		t3.add(tm3);
		t3.add(tm4);
		t3.add(tm5);
		
		Collections.sort(t3,new Comparator(){
			public int compare(Object m1, Object m2) {
				Map<String,Map<String,String>> mm1=(Map<String, Map<String, String>>) m1;
				Map<String,Map<String,String>> mm2=(Map<String, Map<String, String>>) m2;
				return new Double(((Map)mm1.get(mm1.keySet().toArray()[0])).get("v").toString()).compareTo(new Double(((Map)mm2.get(mm2.keySet().toArray()[0])).get("v").toString()));
			}
			
		});
		
		System.out.println(t3.toString());
		
		
		
	}

}
