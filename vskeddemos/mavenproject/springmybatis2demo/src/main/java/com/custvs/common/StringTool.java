package com.custvs.common;

import java.util.Map;

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
	 * json字符串转map
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> jsonToMap(String s) throws Exception{
		Map<String, Object> m=jackson.readValue(s, new TypeReference<Map<String, Object>>(){});
		return m;
	}

}
