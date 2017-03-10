package com.vsked.common;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public  class BaseJson {
	//TODO fixed here
	static Gson gson = new GsonBuilder().serializeNulls().create();
	
	public static String objectToJson(Object o){
		return gson.toJson(o);
	}
	
	public static Object jsonToObject(String s,Class c){
		return  gson.fromJson(s, c);
	}
	
	public static String listToJson(List l){
		return gson.toJson(l);
	}
	
	public static List jsonToList(String s){
		return gson.fromJson(s, new TypeToken<List>(){}.getType());
	}
	
	public static Map jsonToMap(String s){
		return gson.fromJson(s, new TypeToken<Map>(){}.getType());		
	}
	
	public static String mapToJson(Map m){
		return gson.toJson(m);
	}

	public  BaseJson() {
	}

}
