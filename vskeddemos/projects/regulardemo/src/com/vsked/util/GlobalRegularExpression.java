package com.vsked.util;

import java.util.regex.Pattern;

public class GlobalRegularExpression {
	/**
	 * 是否为正整数
	 */
	public static String isNumber1="\\d+";
	/**
	 * 正整数与负整数
	 */
	public static String isNumber2="-?\\d+";
	/**
	 * 正负小数
	 */
	public static String isNumber3="-?\\d+.\\d+";
	
	
	public static boolean isNumber(String regExp,String value){
		Pattern pattern = Pattern.compile(regExp);
		return pattern.matcher(value).matches();    
	}

}
