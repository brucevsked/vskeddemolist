package com.vsked.test;

import com.vsked.util.GlobalRegularExpression;

public class TestGlobalRegularExpression {

	public static void main(String[] args) {
//		testIsNumber1();
//		testIsNumber2();
		testIsNumber3();

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

}
