package com.vsked.common;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class ClassTool {
	
	/**
	 * 传入类名获取这个类成叫变量值
	 * @param cName
	 * @return
	 */
	public static Map<String, Object> getFieldValueMap(String cName){
		Map<String, Object> resultMap=new LinkedHashMap<String, Object>();
		try {
			Class<?> c=Class.forName(cName);
			Field[] fa=c.getDeclaredFields();
			
			for(Field f:fa){
				resultMap.put(f.getName(), f.get(c));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}

}
