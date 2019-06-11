package com.vsked.bussiness;

import java.math.BigDecimal;

public class MoneyTest {

	public static void main(String[] args) {
//		percentageTest();
//		percentageTest1();
//		percentageTest2();
//		percentageTest3();
		testInt();
	}
	
	public static void percentageTest(){
		BigDecimal percentage=new BigDecimal(100);
		BigDecimal b1=new BigDecimal("4");
		System.out.println(b1.divide(percentage));
	}
	
	public static void percentageTest1(){
		BigDecimal percentage=new BigDecimal(100);
		BigDecimal b1=new BigDecimal("2.8");//只舍不入
		System.out.println(b1.divide(percentage).setScale(2, BigDecimal.ROUND_DOWN));
	}
	
	public static void percentageTest2(){
		BigDecimal percentage=new BigDecimal(100);
		BigDecimal b1=new BigDecimal("2.1");//只入不舍
		System.out.println(b1.divide(percentage).setScale(2, BigDecimal.ROUND_UP));
	}
	
	public static void percentageTest3(){
		double num = 111231.5585;
		BigDecimal b = new BigDecimal(num);
		System.out.println( b.setScale(2, BigDecimal.ROUND_HALF_UP));//四舍五入保留两位小数
	}
	
	public static void testInt(){
		BigDecimal b1=new BigDecimal("2.66312");
		System.out.println(b1.intValue());
	}

}
