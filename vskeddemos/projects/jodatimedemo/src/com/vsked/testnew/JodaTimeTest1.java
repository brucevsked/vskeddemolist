package com.vsked.testnew;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JodaTimeTest1 {

	public static void main(String[] args) {
		test1();
	}
	
	/**
	 * 测试当前时间减去某个时间间隔秒数
	 */
	public static void test1(){
		try{
		Date currentDate=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String reqTimeStr="2017-02-04 15:36:00";
		
		Date stopDate=sdf.parse(reqTimeStr);
		
		// 毫秒ms
		Long diff = currentDate.getTime() - stopDate.getTime();
		
		Long diffSeconds = diff / 1000 ;
		//提前一天更新 
		diffSeconds=diffSeconds-86400;

		System.out.println("时间相差：");
		System.out.println(diffSeconds + " 秒.");

		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
