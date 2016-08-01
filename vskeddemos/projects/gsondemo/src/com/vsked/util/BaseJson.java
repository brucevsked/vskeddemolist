package com.vsked.util;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class BaseJson {
	
	//with null value
	Gson gson = new GsonBuilder().serializeNulls().create();
	
	public  String objectToJson(Object o){
		return gson.toJson(o);
	}
	
	public  Object jsonToObject(String s,Class c){
		return  gson.fromJson(s, c);
	}
	
	public  String listToJson(List l){
		return gson.toJson(l);
	}
	
	public  List jsonToList(String s){
		return gson.fromJson(s, new TypeToken<List>(){}.getType());
	}
	
	public  Map jsonToMap(String s){
		return gson.fromJson(s, new TypeToken<Map>(){}.getType());		
	}
	
	public  String mapToJson(Map m){
		return gson.toJson(m);
	}

	public BaseJson() {
	}

}
