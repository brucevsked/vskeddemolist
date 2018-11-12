package com.vsked.test;

import com.vsked.util.GlobalRegularExpression;

public class TestGlobalRegularExpression {

	public static void main(String[] args) {
//		testIsNumber1();
//		testIsNumber2();
//		testIsNumber3();
//		startWithEndWith();
		startWithEndWith1();

	}
	
	/**
	 * 测试是否为数字正则表达式 只有正整数时为真
	 */
	public static void testIsNumber1(){
		String number="123";
//		number="-55";
//		number="99.6";
//		number="-99.6";
		number="a";
		number="-";
		System.out.println(GlobalRegularExpression.isNumber(GlobalRegularExpression.isNumber1, number));
	}
	
	/**
	 * 测试是否为数字 只有正整数与负整数为真
	 */
	public static void testIsNumber2(){
		String number="123";
//		number="-55";
//		number="99.6";
//		number="-99.6";
		System.out.println(GlobalRegularExpression.isNumber(GlobalRegularExpression.isNumber2, number));
	}
	
	/**
	 * 测试是否为正整数
	 */
	public static void testIsNumber3(){
		String number="123";
//		number="-55";
//		number="99.6";
		number="-99.6";
		number="11.";
		number=".66";
		number=".";
		number="a";
		System.out.println(GlobalRegularExpression.isNumber(GlobalRegularExpression.isNumber3, number));
	}
	
	public static void startWithEndWith(){
		String s1="jczq_s(2*1)3{181023_2001[s(0:1.68,1:8.11,2:9.99)],181023_2002[s(0:1.87)]}";
		String start="\\{";
		String end="\\}";
		System.out.println(GlobalRegularExpression.startWithEndWith(s1, start, end));
		
		s1="{a}{b}{c}";
		System.out.println(GlobalRegularExpression.startWithEndWith(s1, start, end));
		
	}
	
	public static void startWithEndWith1(){
		String start="\\{";
		String end="\\}";
		
		String s1="{a}{b}{c}";
		System.out.println("fff|"+GlobalRegularExpression.startWithEndWith1(s1, start, end));
		
	}

}
