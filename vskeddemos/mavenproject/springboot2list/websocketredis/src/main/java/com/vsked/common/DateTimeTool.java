package com.vsked.common;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeTool {

	public static String format1="yyyy-MM-dd HH:mm:ss";
	public static String format2="yyyy-MM-dd HH:mm:ss.S";
	public static String format3="yyyyMMddHHmmssSSS";

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
	 * 返回当前时间
	 * 格式为yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getCurDateTime(String format){
		return LocalDateTime.now().toString(format);
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
	 * 返回指定时间加分钟
	 * @param dt
	 * @param Minutes
	 * @return
	 */
	public static String myDatePlusMin(String dt,int Minutes){
		return DateTime.parse(dt, DateTimeFormat.forPattern(format1)).plusMinutes(Minutes).toString(format1);
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
	//获取随机一段时间内的随机时间值（下面方法调用）
	public static long random(long begin, long end) {
		long rtn = begin + (long) (Math.random() * (end - begin));
		// 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
		if (rtn == begin || rtn == end) {
			return random(begin, end);
		}
		return rtn;
	}
	/**
	 * 一段时间内的随机时间值
	 * @param
	 * @param
	 * @return
	 */
	public static Date randomDate(String beginDate, String endDate) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date start = format.parse(beginDate);// 构造开始日期
			Date end = format.parse(endDate);// 构造结束日期
			if (start.getTime() >= end.getTime()) {
				return null;
			}
			long date = random(start.getTime(), end.getTime());
			return new Date(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
