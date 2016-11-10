package com.vsked.common;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class LogUtil {
	
	
	public static void  getLog(Class<?> c,Exception e){
		System.out.println("----------Exception start--------------");
		
		System.out.println(c.getName());
		
		e.printStackTrace();
		
		System.out.println("----------Exception end--------------");
		
	}
	
	public static void outPutBasicMap(Map<String, String> m){
		Iterator<Entry<String, String>> it=m.entrySet().iterator();	
		while(it.hasNext()){
			Map.Entry<String, String> ent=it.next();
			System.out.println("|"+ent.getKey()+"|"+ent.getValue()+"|");
		}
	}
	
	public static void outPutObject(Object o){
		System.out.println("----------object start--------------");
		System.out.println(o);
		System.out.println("----------object end--------------");
	}
	
	public static void main(String[] args) {
	}

}
