package com.vsked.util;
/**
 * 处理字符串类
 * @author Administrator
 *
 */
public class StringUtils {
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str)){
			return true;
		}
		return false;
	}
	
	public static String getNewColumnValueForSql(String s){
		if (null != s && !"".equals(s)) {
			s = s.replace("'", "\\'");
		}
		return s;
	}
}
