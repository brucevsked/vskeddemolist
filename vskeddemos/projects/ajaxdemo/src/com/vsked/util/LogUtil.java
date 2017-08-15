package com.vsked.util;

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
	
	public static void outPutBasicMap(Map<String, Object> m){
		Iterator<Entry<String, Object>> it=m.entrySet().iterator();	
		while(it.hasNext()){
			Map.Entry<String, Object> ent=it.next();
			if (ent.getValue() instanceof String[]) {
				String[] values = (String[]) ent.getValue();
				for(String s:values){
					System.out.println(s);
				}
				
			}
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
