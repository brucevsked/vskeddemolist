package com.vsked.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestListFindElement {

	public static void main(String[] args) {
		
		testDeleteElement();
	}
	
	public static void testFindElement(){
        List<String> l=new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		l.add("d");
		l.add("1");
		System.out.println(l.contains("2"));
	}
	
	public static void testDeleteElement(){
		List<Map<String, String>> al=new ArrayList<Map<String,String>>();
		Map<String, String> m0=new HashMap<String, String>();
		m0.put("tname", "f1a1");
		m0.put("tcol", "f1");
		al.add(m0);
		Map<String, String> m1=new HashMap<String, String>();
		m1.put("tname", "f1b2");
		m1.put("tcol", "f1");
		al.add(m1);
		Map<String, String> m2=new HashMap<String, String>();
		m2.put("tname", "f2c3");
		m2.put("tcol", "f2");
		al.add(m2);
		Map<String, String> m3=new HashMap<String, String>();
		m3.put("tname", "f1d4");
		m3.put("tcol", "f1");
		al.add(m3);
		Map<String, String> m4=new HashMap<String, String>();
		m4.put("tname", "f1e5");
		m4.put("tcol", "f2");
		al.add(m4);
		
		Map<String, String> m5=new HashMap<String, String>();
		m5.put("tname", "f1f6");
		m5.put("tcol", "f2");
		al.add(m5);
		
		for(int i=0;i<al.size();i++){
			Map<String, String> mx=al.get(i);
			System.out.println("current table:"+mx.get("tname"));
			int count=1;
			for(int k=al.size()-1;k>0;k--){
				Map<String, String> mc=al.get(k);
				if(mx.get("tcol").equals(mc.get("tcol")) && (!mx.get("tname").equals(mc.get("tname")))){
				    System.out.println(""+count+"||"+mc.get("tname"));
				    count++;
				    al.remove(k);
				}
			}
		}
		
	}

}
