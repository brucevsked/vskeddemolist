package com.vsked.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;


public class GenerateData {
	
	static Random r=new Random();
	static DecimalFormat floatFormat = new DecimalFormat("0.00");
	static String dateFormat="yyyy-MM-dd";
	static String timeFormat="HH:mm:ss";
	static DateFormat df = new SimpleDateFormat(dateFormat+" "+timeFormat);
	static String letterLow="abcdefghijklmnopqrstuvwxyz";
	static String letterUpper=letterLow.toUpperCase();
	
	public static int getIntData(int inD){
		return r.nextInt(inD);
	}
	
	public static float getFloatData(int inD){
		return new Float(floatFormat.format(r.nextFloat()*inD));
	}
	
	public static char getCharLow(){
		return letterLow.charAt(getIntData(26));
	}
	
	public static char getChineseChar0(){
		return (char)(0x4e00 + r.nextInt(0x9fa5 - 0x4e00 + 1));
	}
	public static char getChineseChar1() throws Exception {
		byte[] b = new byte[2];
		b[0] = (new Integer((176 + Math.abs(r.nextInt(39))))).byteValue();
		b[1] = (new Integer(161 + Math.abs(r.nextInt(93)))).byteValue();
		return new String(b, "GB2312").charAt(0);
	}
	
	public static String getChineseString0(int inLength){
		String s="";
		for(int i=0;i<inLength;i++) s+=getChineseChar0();
		return s;		
	}
	
	public static String getChineseString1(int inLength) throws Exception {
		String s="";
		for(int i=0;i<inLength;i++) s+=getChineseChar1();
		return s;		
	}
	
	public static char getCharUpper(){
		return letterUpper.charAt(getIntData(26));
	}
	
	public static String getStringLow(int inLentgh){
		StringBuilder sb=new StringBuilder("");
		for(int i=0;i<inLentgh;i++) sb.append(letterLow.charAt(getIntData(26)));
		return sb.toString();
	}
	
	public static String getStringUpper(int inLentgh){
		return getStringLow(inLentgh).toUpperCase();
	}
	
	public static String getSystemDateTime()  {
		return df.format(Calendar.getInstance().getTime());
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(GenerateData.getIntData(26));
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
		
	}

}
