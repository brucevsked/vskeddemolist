package com.vsked;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.vsked.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class FastJsonTest {

	private static final Logger log = LoggerFactory.getLogger(FastJsonTest.class);

	public static void main(String[] args) {
		testObjectToJson();
//		testJsonToObject();
//		testListToJson();
//		testJsonToList();
//		testMapToJson();
//		testJsonToMap();
//		testBuildJson();
	}

	@Test
	public static void testObjectToJson(){
		User myUser=new User("a8561", "dddllwwss", "55667788", 18, false);
		log.info(JSON.toJSONString(myUser));
		User myUser1=new User("a8561", null, "55667788", 18, false);
		log.info(JSON.toJSONString(myUser1, SerializerFeature.WriteNullStringAsEmpty));
	}

	@Test
	public static void testJsonToObject(){
		String myObj="{\"marry\":false,\"usAge\":18,\"usId\":\"a8561\",\"usName\":\"dddllwwss\",\"usPass\":\"55667788\"}";
		User myUser=JSON.parseObject(myObj, User.class);
		log.info(myUser.getUsName());
	}

	@Test
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

	@Test
	public static void testJsonToList(){
		String jsonStr="[\"a1\",\"b2\",\"c3\",\"d4\",\"e5\"]";
		List<String> dataList=JSON.parseObject(jsonStr, List.class);
		log.info("{}",dataList);
	}

	@Test
	public static void testMapToJson(){
		Map<String, String> dataMap=new HashMap<String, String>();
		dataMap.put("usName", "loveisfall");
		dataMap.put("usAge", "18");
		dataMap.put("usPass", "xyaaavvbbbcc");
		String jsonStr=JSON.toJSONString(dataMap);
		log.info(jsonStr);
	}

	@Test
	public static void testJsonToMap(){
		String jsonStr="{\"usName\":\"loveisfall\",\"usPass\":\"xyaaavvbbbcc\",\"usAge\":\"18\"}";
		Map<String, String> dataMap=JSON.parseObject(jsonStr, Map.class);
		log.info("{}",dataMap);
	}

	@Test
	public static void testBuildJson(){
		JSONObject jsonAll=new JSONObject();
		
		JSONObject jsonSon1=new JSONObject();
		jsonSon1.put("name", "f1");
		jsonSon1.put("pass", "f2");
		jsonSon1.put("age", "f3");
		
		jsonAll.put("requestHead", jsonSon1);
		
		jsonAll.put("requestBody", "hello");
		
		String jsonStr=jsonAll.toString();
		log.info(jsonStr);
	}

	@Test
	public void testStringToJsonArray(){
		String arrayStr="[{\"id\":\"18\",\"votes\":\"4,5,6,7\"},{\"id\":\"19\",\"votes\":\"1,5,8,9\"}]";
		JSONArray jsonArray=JSON.parseArray(arrayStr);
		log.info("{}",jsonArray);

		for(int i=0;i<jsonArray.size();i++){
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			log.info("{}",jsonObject);
			log.info("{}",jsonObject.getString("votes"));

		}

	}
	@Test
	public void testJsonArray(){
		String arrayStr="[1,2,3,4,5]";
		JSONArray jsonArray=JSON.parseArray(arrayStr);
		log.info("{}",jsonArray);

		for(Object jsonObject:jsonArray){
			log.info("{}",jsonObject);
		}

	}

}
