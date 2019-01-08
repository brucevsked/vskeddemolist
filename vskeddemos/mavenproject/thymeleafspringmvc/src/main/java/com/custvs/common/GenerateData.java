package com.custvs.common;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

/**
 * 数据生成器
 * @author brucevsked
 *
 */
public class GenerateData {
	
	static Random r=new Random();
	
	/**
	 * 两位小数
	 */
	static DecimalFormat floatFormat = new DecimalFormat("0.00");
	
	/**
	 * yyyy-MM-dd
	 */
	static String dateFormat="yyyy-MM-dd";
	
	/**
	 * HH:mm:ss
	 */
	static String timeFormat="HH:mm:ss";
	
	/**
	 * yyyyMMDDHHmmssSSS
	 */
	static String longDateFormat="yyyyMMDDHHmmssSSS";
	
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	static DateFormat df = new SimpleDateFormat(dateFormat+" "+timeFormat);
	
	/**
	 * yyyyMMDDHHmmssSSS
	 */
	static DateFormat dfl=new SimpleDateFormat(longDateFormat);
	
	static String letterLow="abcdefghijklmnopqrstuvwxyz";
	static String letterUpper=letterLow.toUpperCase();
	
	/**
	 * 随机取一个小于输入数据整数
	 * @param inD
	 * @return
	 */
	public static int getIntData(int inD){
		return r.nextInt(inD);
	}
	
	/**
	 * 获取inCount个小于inMax随机数
	 * @param inMax
	 * @param inCount
	 * @return
	 */
	public static int getIntData(int inMax,int inCount){
		String c="";
		int x=0;
		while(c.length()<inCount){
			x=getIntData(inMax);
			c+=""+x+"";
		}
		return new Integer(c);
	}
	
	/**
	 * 生成inCount位0-9随机数
	 * @param inCount
	 * @return
	 */
	public static int getIntDataEx(int inCount){
		return getIntData(9, inCount);
	}
	
	/**
	 * 小于输入数据并保留两位小数
	 * @param inD
	 * @return
	 */
	public static float getFloatData(int inD){
		return new Float(floatFormat.format(r.nextFloat()*inD));
	}
	
	/**
	 * 26个字母中随机一位小写字母
	 * @return
	 */
	public static char getCharLow(){
		return letterLow.charAt(getIntData(26));
	}
	
	/**
	 * 随机汉字一个
	 * @return
	 */
	public static char getChineseChar0(){
		return (char)(0x4e00 + r.nextInt(0x9fa5 - 0x4e00 + 1));
	}
	
	/**
	 * 随机GB2312编码汉字一个
	 * @return
	 * @throws Exception
	 */
	public static char getChineseChar1() throws Exception {
		byte[] b = new byte[2];
		b[0] = (new Integer((176 + Math.abs(r.nextInt(39))))).byteValue();
		b[1] = (new Integer(161 + Math.abs(r.nextInt(93)))).byteValue();
		return new String(b, "GB2312").charAt(0);
	}
	
	/**
	 * 随机中文长度为inLength
	 * @param inLength
	 * @return
	 */
	public static String getChineseString0(int inLength){
		String s="";
		for(int i=0;i<inLength;i++) s+=getChineseChar0();
		return s;		
	}
	
	/**
	 * 随机中文长度为inLength编码为 GB2312
	 * @param inLength
	 * @return
	 * @throws Exception
	 */
	public static String getChineseString1(int inLength) throws Exception {
		String s="";
		for(int i=0;i<inLength;i++) s+=getChineseChar1();
		return s;		
	}
	
	/**
	 * 26个英文字母中随机取一个大写
	 * @return
	 */
	public static char getCharUpper(){
		return letterUpper.charAt(getIntData(26));
	}
	
	/**
	 * 随机取小写字母inLength位
	 * @param inLentgh
	 * @return
	 */
	public static String getStringLow(int inLentgh){
		StringBuilder sb=new StringBuilder("");
		for(int i=0;i<inLentgh;i++) sb.append(letterLow.charAt(getIntData(26)));
		return sb.toString();
	}
	
	/**
	 * 随机大写字母inLength位
	 * @param inLentgh
	 * @return
	 */
	public static String getStringUpper(int inLentgh){
		return getStringLow(inLentgh).toUpperCase();
	}
	
	/**
	 * 系统日期格式
	 * yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getSystemDateTime()  {
		return df.format(Calendar.getInstance().getTime());
	}
	
	/**
	 * 系统日期格式
	 * yyyyMMDDHHmmssSSS
	 * @return
	 */
	public static String getLongDate(){
		return dfl.format(Calendar.getInstance().getTime());
	}
	
	/**
	 * 32位uuid
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(GenerateData.getIntData(26));
		System.out.println(GenerateData.getIntData(9,6));
		System.out.println(GenerateData.getFloatData(10));
		System.out.println(GenerateData.getCharLow());
		System.out.println(GenerateData.getChineseChar0());
		System.out.println(GenerateData.getChineseString0(15));
		System.out.println(GenerateData.getChineseChar1());
		System.out.println(GenerateData.getChineseString1(15));
		System.out.println(GenerateData.getCharUpper());
		System.out.println(GenerateData.getStringLow(5));
		System.out.println(GenerateData.getStringUpper(5));
		System.out.println(GenerateData.getSystemDateTime());
		System.out.println(GenerateData.getLongDate());
		System.out.println(GenerateData.getUUID());
		
		
	}

}
