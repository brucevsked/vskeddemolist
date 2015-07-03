package com.vsked.test;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
	
	Map<String, String> m1=new TreeMap<String, String>();
	Map<String, String> m2=new TreeMap<String, String>();
	
	public void initMap1(){
		m1.put("a1", "11a");
		m1.put("b1", "22b");
		m1.put("c1", "33c");
		m1.put("d1", "44d");
	}
	public void initMap2(){
		m2.put("a1", "11a");
		m2.put("b1", "22b");
		m2.put("c1", "33c");
		m2.put("d1", "44d");
	}
	
	public void testDelElementInMap(){
		Iterator<Map.Entry<String, String>> it = m1.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> et=it.next();
			System.out.println("current m1 size is:"+m1.size()+"|current remove key:"+et.getKey());
			it.remove();
		}
	}
	public void testDelElementInMapEx(){
		Iterator<Map.Entry<String, String>> it = m1.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> et=it.next();
			System.out.println("current m1 size is:"+m1.size()+"|current remove key:"+et.getKey());
			it.remove();
		}
	}
	
	public void testListKey1(){
		 for(Map.Entry<String, String> et:m1.entrySet()) System.out.println("a01|"+et.getKey()+" = "+et.getValue());
	}
	public void testListKey2(){
		Iterator<Map.Entry<String, String>> it = m1.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> et=it.next();
			System.out.println("a02|"+et.getKey()+" = "+et.getValue());
		}
	}

	public static void main(String[] args) {
		TestMap tm=new TestMap();
		//tm.testDelElementInMap();
		//tm.testListKey1();
		//tm.testListKey2();
		tm.testMapEquals();

	}
	
	public void testMapEquals(){
		m2=copyMap(m1);
		m2.put("ss1", "ui");
		System.out.println(m1.containsKey("ss1"));
	}
	
	public TestMap() {
		initMap1();
		initMap2();
	}
	
	public Map<String, String> copyMap(Map<String, String> m1){
		Map<String, String> m=new TreeMap<String, String>();
		for(Map.Entry<String, String> et:m1.entrySet())m.put(et.getKey(), et.getValue());
		return m;
	}

}
