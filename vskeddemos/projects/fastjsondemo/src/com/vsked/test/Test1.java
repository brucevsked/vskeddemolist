package com.vsked.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.vsked.bean.User;

public class Test1 {

	public static void main(String[] args) {
		testObjectToJson();
//		testJsonToObject();
//		testListToJson();
//		testJsonToList();
//		testMapToJson();
//		testJsonToMap();
//		testBuildJson();
	}
	
	public static void testObjectToJson(){
		User myUser=new User("a8561", "dddllwwss", "55667788", 18, false);
		System.out.println(JSON.toJSONString(myUser));
	}
	public static void testJsonToObject(){
		String myObj="{\"marry\":false,\"usAge\":18,\"usId\":\"a8561\",\"usName\":\"dddllwwss\",\"usPass\":\"55667788\"}";
		User myUser=JSON.parseObject(myObj, User.class);
		System.out.println(myUser.getUsName());
	}
	public static void testListToJson(){
		List<String> dataList=new LinkedList<String>();
		dataList.add("a1");
		dataList.add("b2");
		dataList.add("c3");
		dataList.add("d4");
		dataList.add("e5");
		String jsonStr=JSON.toJSONString(dataList);
		System.out.println(jsonStr);
	}
	public static void testJsonToList(){
		String jsonStr="[\"a1\",\"b2\",\"c3\",\"d4\",\"e5\"]";
		List<String> dataList=JSON.parseObject(jsonStr, List.class);
		System.out.println(dataList);
	}
	public static void testMapToJson(){
		Map<String, String> dataMap=new HashMap<String, String>();
		dataMap.put("usName", "loveisfall");
		dataMap.put("usAge", "18");
		dataMap.put("usPass", "xyaaavvbbbcc");
		String jsonStr=JSON.toJSONString(dataMap);
		System.out.println(jsonStr);
	}
	public static void testJsonToMap(){
		String jsonStr="{\"usName\":\"loveisfall\",\"usPass\":\"xyaaavvbbbcc\",\"usAge\":\"18\"}";
		Map<String, String> dataMap=JSON.parseObject(jsonStr, Map.class);
		System.out.println(dataMap);
	}
	
	public static void testBuildJson(){
		JSONObject jsonAll=new JSONObject();
		
		JSONObject jsonSon1=new JSONObject();
		jsonSon1.put("name", "f1");
		jsonSon1.put("pass", "f2");
		jsonSon1.put("age", "f3");
		
		jsonAll.put("requestHead", jsonSon1);
		
		jsonAll.put("requestBody", "hello");
		
		String jsonStr=jsonAll.toString();
		System.out.println(jsonStr);
	}

}
