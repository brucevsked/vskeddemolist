package com.vsked.util;

import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class BaseJson {
	
	static Gson gson = new Gson();
	
	public  static String objectToJson(Object o){
		return gson.toJson(o);
	}
	
	public  static Object jsonToObject(String s,Class c){
		return  gson.fromJson(s, c);
	}
	
	public  static String listToJson(List l){
		return gson.toJson(l);
	}
	
	public  static List jsonToList(String s){
		return gson.fromJson(s, new TypeToken<List>(){}.getType());
	}
	
	public  static Map jsonToMap(String s){
		return gson.fromJson(s, new TypeToken<Map>(){}.getType());		
	}
	
	public static String mapToJson(Map m){
		return gson.toJson(m);
	}

	public BaseJson() {
	}
	
	public static void main(String[] args) {
		BaseJson bj=new BaseJson();
		String[] ss={"c1","c2","c3","c4"};
		System.out.println(bj.objectToJson(ss));
		String st="okvvv";
		System.out.println(bj.objectToJson(st));
		
		
	}

}
