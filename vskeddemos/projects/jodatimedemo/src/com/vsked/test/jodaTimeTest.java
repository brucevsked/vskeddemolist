package com.vsked.test;

import java.text.SimpleDateFormat;

import org.joda.time.DateTime;

import com.vsked.util.DateTimeUtilVsked;



public class jodaTimeTest {

	public static void main(String[] args) {
		System.out.println("获取当天日期:"+DateTimeUtilVsked.getCurrentDate("yyyy-MM-dd"));
		System.out.println("获取本周一日期:"+DateTimeUtilVsked.getMondayOfCurrentWeek());
		System.out.println("获取本周末日期:"+DateTimeUtilVsked.getSundayOfCurrentWeek());
		System.out.println("获取上周一日期:"+DateTimeUtilVsked.getMondayOfBeforeWeek());
		System.out.println("获取上周末日期:"+DateTimeUtilVsked.getSundayOfBeforeWeek());
		System.out.println("获取下周一日期:"+DateTimeUtilVsked.getMondayOfNextWeek());
		System.out.println("获取下周末日期:"+DateTimeUtilVsked.getSundayOfNextWeek());
		System.out.println("获取本月第一天日期:"+DateTimeUtilVsked.getFirstDayOfCurrentMonth());
		System.out.println("获取本月最后一天日期:"+DateTimeUtilVsked.getLastDayOfCurrentMonth());
		System.out.println("获取上月第一天日期:"+DateTimeUtilVsked.getFirstDayOfBeforeMonth());
		System.out.println("获取上月最后一天日期:"+DateTimeUtilVsked.getLastDayOfBeforeMonth());
		System.out.println("获取下月第一天日期:"+DateTimeUtilVsked.getFirstDayOfNextMonth());
		System.out.println("获取下月最后一天日期:"+DateTimeUtilVsked.getLastDayOfNextMonth());
		System.out.println("获取本年第一天日期:"+DateTimeUtilVsked.getFirstDayOfCurrentYear());
		System.out.println("获取本年最后一天日期:"+DateTimeUtilVsked.getLastDayOfCurrentYear());
		System.out.println("获取上年第一天日期:"+DateTimeUtilVsked.getFirstDayOfBeforeYear());
		System.out.println("获取上年最后一天日期:"+DateTimeUtilVsked.getLastDayOfBeforeYear());
		System.out.println("获取下年第一天日期:"+DateTimeUtilVsked.getFirstDayOfNextYear());
		System.out.println("获取下年最后一天日期:"+DateTimeUtilVsked.getLastDayOfNextYear());
		System.out.println("获取当前季度:"+DateTimeUtilVsked.getFirstDayOfCurrentSeason()); //测试中未完成
		System.out.println("两日期相差:"+DateTimeUtilVsked.getDaysBetweenTwoDate(new DateTime(2015, 5, 6, 20, 11, 40), new DateTime(2015, 5, 8, 20, 11, 40)));
//		System.out.println("获取当天日期:"+DateTimeUtilVsked);

	}
	
	

}
