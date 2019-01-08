package com.custvs.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.LocalDate;
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
	
	public static String format2="yyyyMMdd";
	public static String format3="yyyy-MM-dd HH:mm:ss";
	public static String format4="yyyy-MM-dd";
	public static String format5="yyyy-MM-dd HH:mm";
	
	/**
	 * 正则表达式抽取yyyy-MM-dd HH:mm
	 */
	static String pattern1="\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}";
	static Pattern p1 = Pattern.compile(pattern1);
	
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
	public static SimpleDateFormat sdf4=new SimpleDateFormat(format4);
	
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
	 * 返回当天日期格式yyyyMMdd 如20180424
	 * @return
	 */
	public static String getToday(){
		return LocalDate.now().toString(format2);
	}
	
	/**
	 * 返回明天日期格式yyyyMMdd 如20180424
	 * @return
	 */
	public static String getTomorrow1(){
		return LocalDate.now().plusDays(1).toString(format2);
	}
	
	/**
	 * 返回明天日期格式yyyy-MM-dd 如2018-10-26
	 * @return
	 */
	public static String getTomorrow2(){
		return LocalDate.now().plusDays(1).toString(format4);
	}
	
	/**
	 * 返回后天日期格式yyyyMMdd 如20180424
	 * @return
	 */
	public static String getAfterTomorrow1(){
		return LocalDate.now().plusDays(2).toString(format2);
	}
	
	/**
	 * 返回后天日期格式yyyyMMdd 如20180424
	 * @return
	 */
	public static String getAfterTomorrow2(){
		return LocalDate.now().plusDays(2).toString(format4);
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
	 * 返回昨天日期格式yyyy-MM-dd 如2018-04-01
	 * @return
	 */
	public static String getYesterday2(){
		return LocalDate.now().minusDays(1).toString(format4);
	}
	
	/**
	 * 返回前天日期格式yyyy-MM-dd 如2018-04-01
	 * @return
	 */
	public static String getBeforeYesterday2(){
		return LocalDate.now().minusDays(2).toString(format4);
	}
	
	/**
	 * 传入日期获取星期几 日期格式yyyyMMdd 如20180424
	 * @param date
	 * @return
	 */
	public static int dateToWeek(String date){
		return LocalDate.parse(date, DateTimeFormat.forPattern(format2)).getDayOfWeek();
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
	 * 对数字进行补0操作
	 * @param count 总计位数
	 * @param myNum 要补0的数字
	 * @return
	 */
	public static String patchZero(int count,int myNum){
		return String.format("%0"+count+"d", myNum);
	}
	
	/**
	 * 在传入字符串中抽取日期部分yyyy-MM-dd HH:mm
	 * @param str
	 * @return
	 */
	public static String getDateFromStr1(String str){
		Matcher m = p1.matcher(str);
		while(m.find()){
			return m.group();
		}
		return "";
	}
	
	/**
	 * 将传入时间减去几小时 如传入2018-10-24 18:00与2会得到2018-10-24 16:00
	 * @param curTime yyyy-MM-dd HH:mm
	 * @param minusHours 2
	 * @return
	 */
	public static String curTimeMinusHours(String curTime,int minusHours){
		return LocalDateTime.parse(curTime, DateTimeFormat.forPattern(format5)).minusHours(minusHours).toString(format5);
	}
	
	/**
	 * 将传入时间与传入毫秒数进行相加, 如传入2018-10-24 18:00:00与2会得到2018-10-24 18:02:11
	 * @param curTime yyyy-MM-dd HH:mm:ss
	 * @param minusHours 2
	 * @return
	 */
	public static String curTimePlusMillis(String curTime,int minusHours){
		return LocalDateTime.parse(curTime, DateTimeFormat.forPattern(format3)).plusMillis(minusHours).toString(format3);
	}
	
	/**
	 * 将传入时间加几天 如传入2018-10-24,3,yyyy-MM-dd得到结果2018-10-27
	 * @param curTime 当前时间
	 * @param days 加天数
	 * @param format 日期格式
	 * @return
	 */
	public static String curTimePlusDays(String curTime,int days,String format){
		return LocalDateTime.parse(curTime, DateTimeFormat.forPattern(format)).plusDays(days).toString(format);
	}
	
	/**
	 * 将传入时间减去几天 如传入2018-10-24,3,yyyy-MM-dd得到结果2018-10-21
	 * @param curTime 当前时间
	 * @param days 减去天数
	 * @param format 日期格式
	 * @return
	 */
	public static String curTimeMinusDays(String curTime,int days,String format){
		return LocalDateTime.parse(curTime, DateTimeFormat.forPattern(format)).minusDays(days).toString(format);
	}
	
	/**
	 * 对11选5号码进行排序操作，传入10 09类型字符串，返回排序后字符串
	 * @param content
	 * @return
	 */
	public static String sortNo(String content){
		
		Map<String,String> m=new TreeMap<String,String>();
        
		String [] no=content.split(" ");
		
		String contents="";
		
		for (int i = 0; i < no.length; i++) {
			m.put(no[i],no[i]);
		}
		
		for (String  key: m.keySet()) {
			contents+=","+m.get(key);
		}
		return contents.substring(1);
		
	}
}
