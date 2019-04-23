package com.appservercommon.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 字符串处理
 * @author brucevsked
 *
 */
public class StringTool {
	
	public static ObjectMapper jackson = new ObjectMapper();
	
	public static String format5="yyyy-MM-dd HH:mm:ss";
	public static String format6="yyyy-MM-dd";
	public static String format7="HH:mm:ss";
	public static String format8="yyMMdd";

	
	/**
	 * yyyyMMddHHmmss
	 */
	public static SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMddHHmmss");
	
	/**
	 * yyyyMMdd
	 */
	public static SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMdd");
	
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * yyyy-MM-dd
	 */
	public static SimpleDateFormat sdf4=new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * yyMMdd
	 */
	public static SimpleDateFormat sdf8=new SimpleDateFormat(format8);
	
	/**
	 * json字符串转map
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> jsonToMap(String s) throws Exception{
		Map<String, Object> m=jackson.readValue(s, new TypeReference<Map<String, Object>>(){});
		return m;
	}
	
	/**
	 * map转json
	 * @param m
	 * @return
	 * @throws Exception
	 */
	public static String mapToJson(Map<String, Object> m) throws Exception{
		String s=jackson.writeValueAsString(m);
		return s;
	}
	
	/**
	 * 
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	public static String listToJson(List<?> dataList) throws Exception{
		String s=jackson.writeValueAsString(dataList);
		return s;
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static List<?> jsonToList(String data)throws Exception{
		List<?> dataList=jackson.readValue(data, new TypeReference<List<?>>(){});
		return dataList;
	}
	
	public static List<Map<String, Object>> jsonToList1(String data)throws Exception{
		List<Map<String, Object>> dataList=jackson.readValue(data, new TypeReference<List<Map<String, Object>>>(){});
		return dataList;
	}
	
	/**
	 * 传入s返回"s"
	 * @param s
	 * @return
	 */
	public static String getJsonKey(String s){
		return "\""+s+"\"";
	}
	
	/**
	 * 获取32位序列号
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * 返回当前时间格式yyyyMMddHHmmss 如20180424094314
	 * @return
	 */
	public static String getCurTime(){
		return sdf1.format(new Date());
	}
	
	/**
	 * 返回当前时间格式yyyyMMdd 如20180424
	 * @return
	 */
	public static String getCurTime1(){
		return sdf2.format(new Date());
	}
	
	/**
	 * 返回当前时间格式yyyy-MM-dd hh:mm:ss 如2018-04-02 15:3:28
	 * @return
	 */
	public static String getCurTime2(){
		return sdf3.format(new Date());
	}
	
	/**
	 * 返回当前时间格式yyyy-MM-dd 如2018-04-02
	 * @return
	 */
	public static String getCurTime3(){
		return sdf4.format(new Date());
	}
	
	/**
	 * 返回前一天日期 格式yyyyMMdd 如20180423
	 * @return
	 */
	public static String getYesterday1(){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return sdf2.format(cal.getTime());
	}
	
	/**
	 * 返回当前时间格式yyyy-MM-dd 如2018-04-01
	 * @return
	 */
	public static String getYesterday2(){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return sdf4.format(cal.getTime());
	}
	
	/**
	 * 进行md5加密
	 * @param parStr
	 * @return
	 */
	public static String md5(String parStr){
		String s=DigestUtils.md5Hex(parStr.getBytes());
		return s;
	}
	
	/**
	 * 16进制数据转字符串
	 * @param hexStr
	 * @return
	 * @throws Exception
	 */
	public static String hexStr2Str(String hexStr) throws Exception {
		String str = "0123456789abcdef";
		char[] hexs = hexStr.toCharArray();
		byte[] bytes = new byte[hexStr.length() / 2];
		int n;
		for (int i = 0; i < bytes.length; i++) {
			n = str.indexOf(hexs[2 * i]) * 16;
			n += str.indexOf(hexs[2 * i + 1]);
			bytes[i] = (byte) (n & 0xff);
		}
		return new String(bytes,"GB2312");
	}
	
    /**
     * 字符串转为16进制
     * @param str
     * @return
     */
	public static String str2HexStr(String str) throws Exception {
		char[] chars = "0123456789abcdef".toCharArray();
		StringBuilder sb = new StringBuilder("");
		byte[] bs = str.getBytes("GB2312");
		int bit;
		for (int i = 0; i < bs.length; i++) {
			bit = (bs[i] & 0x0f0) >> 4;
		    sb.append(chars[bit]);
			bit = bs[i] & 0x0f;
			sb.append(chars[bit]);
		}
		return sb.toString().trim();
	}
	
	public static String bytes2hex(byte[] bytes) {
		StringBuilder buf = new StringBuilder(bytes.length * 2);
		for (byte b : bytes) { // 使用String的format方法进行转换
			buf.append(String.format("%02x", new Integer(b & 0xff)));
		}

		return buf.toString();
	}

	public static byte[] hex2byte(String str) {
		if (str == null || str.trim().equals("")) {
			return new byte[0];
		}
		byte[] bytes = new byte[str.length() / 2];
		for (int i = 0; i < str.length() / 2; i++) {
			String subStr = str.substring(i * 2, i * 2 + 2);
			bytes[i] = (byte) Integer.parseInt(subStr, 16);
		}
		return bytes;
	}

	@SuppressWarnings("resource")
	public static byte[] fileToByteAry(String filename) throws Exception {
		FileChannel fc = new RandomAccessFile(filename, "r").getChannel();
		MappedByteBuffer byteBuffer = fc.map(MapMode.READ_ONLY, 0, fc.size()).load();
		byte[] result = new byte[(int) fc.size()];
		if (byteBuffer.remaining() > 0) {
			byteBuffer.get(result, 0, byteBuffer.remaining());
		}
		fc.close();
		return result;
	}

	public static void hex2file(String hex,String filePath)throws Exception {
		File f=new File(filePath);
		OutputStream os=new FileOutputStream(f);
		os.write(hex2byte(hex));
		os.close();
	}
	
	/**
	 * 返回当前时间格式yyyy-MM-dd 如2018-04-02
	 * @return
	 */
	public static String getCurTime8(){
		return sdf8.format(new Date());
	}
	
	
	/**
	 * 传入日期与格式，判断是否超过当前时间
	 * @param d1
	 * @param ft
	 * @return
	 */
	public static boolean isAfterNow(String d1,String ft){
		return DateTime.parse(d1, DateTimeFormat.forPattern(ft)).isAfterNow();
	}
	
	/**
	 * 返回当前时间加N天或减N天的格式yyyy-MM-dd 如2018-04-01
	 * @return
	 */
	public static String getTheOtherDay(int otherDay){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, otherDay);
		return sdf4.format(cal.getTime());
	}
	
	
	/**
	 * 返回指定时间格式的加N天或减N天的时间格式yyyy-MM-dd 如2018-04-01
	 * @return
	 * @throws ParseException 
	 */
	public static String getTheOtherDay(String theDay,int otherDay) throws ParseException{
		Date date = sdf2.parse(theDay);
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, otherDay);
		return sdf2.format(cal.getTime());
	}
	
	
	/**
	 * 获取今天星期几
	 * @return
	 */
	public static int getCurWeek(){
		return LocalDateTime.now().getDayOfWeek();
	}
	
	/**
	 * 获取昨天星期几
	 * @return
	 */
	public static int getCurWeekOfYesterday(){
		return LocalDateTime.now().minusDays(1).getDayOfWeek();
	}
	
}
