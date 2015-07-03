package com.vsked.util;

import java.util.regex.Pattern;

public class ValidateUtils {
	public static String isNumberReg="^0|[0-9]\\d*(\\.\\d+)?$";
	
	public static boolean isNumber(String s){
		Pattern pattern = Pattern.compile(isNumberReg);
		return (s!=null) && (!"".equals(s)) && (pattern.matcher(s).matches());    
	}
	
	public static boolean isEmpty(String s){
		return "".equals(s);
	}
	
	public static boolean isNull(String s){
		return s==null;		
	}
	
	public static boolean isNullOrIsEmpty(String s){
		return isNull(s)||isEmpty(s);
	}

}
