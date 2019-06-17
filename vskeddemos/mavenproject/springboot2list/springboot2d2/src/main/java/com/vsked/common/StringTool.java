package com.vsked.common;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 字符串处理
 * @author brucevsked
 *
 */
public class StringTool {
	
	public static ObjectMapper jackson = new ObjectMapper();
	
	
	/**
	 * 生成指定位数随机数
	 * abcdefghijklmnopqrstuvwxyz0123456789
	 * @param count
	 * @return
	 */
	public static String getRandomString(int count){
		return RandomStringUtils.random(count, "abcdefghijklmnopqrstuvwxyz0123456789");
	}
	
	/**
	 * json字符串转map
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> jsonToMap(String s) throws Exception{
		Map<String, Object> m=jackson.readValue(s, new TypeReference<Map<String, Object>>(){});
		return m;
	}
	
	public static Map<String, String> jsonToMap1(String s) throws Exception{
		Map<String, String> m=jackson.readValue(s, new TypeReference<Map<String, String>>(){});
		return m;
	}
	
	/**
	 * map转json
	 * @param m
	 * @return
	 * @throws Exception
	 */
	public static String mapToJson(Map<String, Object> m) throws Exception{
		String s=jackson.writeValueAsString(m);
		return s;
	}
	
	public static String mapToJson1(Map<String, String> m) throws Exception{
		String s=jackson.writeValueAsString(m);
		return s;
	}
	
	/**
	 * 
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	public static String listToJson(List<?> dataList) throws Exception{
		String s=jackson.writeValueAsString(dataList);
		return s;
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static List<?> jsonToList(String data)throws Exception{
		List<?> dataList=jackson.readValue(data, new TypeReference<List<?>>(){});
		return dataList;
	}
	
	public static List<Map<String, Object>> jsonToList1(String data)throws Exception{
		List<Map<String, Object>> dataList=jackson.readValue(data, new TypeReference<List<Map<String, Object>>>(){});
		return dataList;
	}
	
	/**
	 * 传入s返回"s"
	 * @param s
	 * @return
	 */
	public static String getJsonKey(String s){
		return "\""+s+"\"";
	}
	
	/**
	 * 获取32位序列号
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * 获取短信验证码
	 * @return
	 */
	public static String getSmsCode(){
		return RandomStringUtils.randomNumeric(4);
	}
	
    /**
     * 判断某字符串为空或长度为0或不由空白符(whitespace)构成 一般用这个
     * @param cs
     * @return
     */
	public static boolean isBlank(String cs){
		return StringUtils.isBlank(cs);
	}
	
	/**
	 * 判断某字符串为空，null或str.length()=0
	 * @param cs
	 * @return
	 */
	public static boolean isEmpty(String cs){
		return StringUtils.isEmpty(cs);
	}
	
}
