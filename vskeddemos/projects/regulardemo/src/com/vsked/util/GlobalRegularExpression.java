package com.vsked.util;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
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
	
	/**
	 * 以什么起始，以什么结束，特殊符号需要加\\转义
	 * @param s1
	 * @param start
	 * @param end
	 * @return
	 */
	public static String startWithEndWith(String s1,String start,String end){
		String result="";
		Pattern p = Pattern.compile(""+start+"([^"+start+"]*)"+end+"");
		Matcher m=p.matcher(s1);
		while(m.find()){
			result=m.group();
		}
		return result;
	}
	
	/**
	 * 以什么起始，以什么结束，特殊符号需要加\\转义
	 * @param s1
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<String> startWithEndWith1(String s1,String start,String end){
		String regxp=""+start+"([^"+start+"]*)"+end+"";
		Matcher m = Pattern.compile(regxp).matcher(s1);
		List<String> arList=new LinkedList<String>();
		while(m.find()){
			arList.add(m.group());
		}
		return arList;	
	}

}
