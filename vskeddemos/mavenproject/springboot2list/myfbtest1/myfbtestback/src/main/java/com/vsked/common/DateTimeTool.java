package com.vsked.common;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

public class DateTimeTool {
	
	public static String format1="yyyy-MM-dd HH:mm:ss";
	public static String format2="yyyy-MM-dd HH:mm:ss.S";
	
	public static String toFormat1(String dt){
		return DateTime.parse(dt, DateTimeFormat.forPattern(format2)).toString(format1);
	}
	
	/**
	 * 返回当前时间
	 * 格式为yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getCurDateTime(){
		return LocalDateTime.now().toString(format1);
	}
	
	/**
	 * 返回当前时间加几天
	 * @param days
	 * @return
	 */
	public static String curDaysPlusDay(int days){
		return LocalDateTime.now().plusDays(days).toString(format1);
	}
	
	/**
	 * 返回指定时间加几天
	 * @param dt
	 * @param days
	 * @return
	 */
	public static String myDatePlusDay(String dt,int days){
		return DateTime.parse(dt, DateTimeFormat.forPattern(format1)).plusDays(days).toString(format1);
	}
	
	/**
	 * 获取购买影片过期时间
	 * @param days
	 * @return
	 */
	public static String getVideoEndTime(int days){
		return LocalDateTime.now().plusDays(days).toString(format1);
	}
	
	/**
	 * 13位时间转yyyy-MM-dd HH:mm:ss
	 * @param s
	 * @return
	 */
    public static String dbDateToStr(String s){
		Long instant=new Long(s);
		DateTime dt=new DateTime(instant);
    	return dt.minusHours(13).toString(format1);
    }
	
	/**
	 * 传入日期与格式，判断是否超过当前时间
	 * @param d1 时间
	 * @param ft 格式
	 * @return
	 */
	public static boolean isAfterNow(String d1,String ft){
		return DateTime.parse(d1, DateTimeFormat.forPattern(ft)).isAfterNow();
	}
	
	/**
	 * 传入日期与格式，判断是否在当前时间之前
	 * @param d1
	 * @param ft
	 * @return
	 */
	public static boolean isBeforeNow(String d1,String ft){
		return DateTime.parse(d1, DateTimeFormat.forPattern(ft)).isBeforeNow();
	}

}
