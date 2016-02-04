package com.vsked.datatest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.vsked.data.highchartData;
import com.vsked.highchart.HCGlobal;

public class highchartDataTest {
	
	public static String getLineBaseTest(){
		
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<13;i++) sb.append("\""+i+"月\",");
		sb.setLength(sb.length()-1);
		
		String title="主标题:虚商部2016年1月个人销售业绩f6888";
		String subTitle="副标题: 大家要向captain wang学习6000";
		String yAxis_title="销售总额(单位:万)";
		String tooltip_valueSuffix="万元";
		String series="";
		series+="{\"name\":\"线上online1\",  \"data\":["+getRandom(10)+"]},";
		series+="{\"name\":\"线上online2\", \"data\":["+getRandom(12)+"]},";
		series+="{\"name\":\"线上online3\", \"data\":["+getRandom(5)+"]},";
		series+="{\"name\":\"线上online4\", \"data\":["+getRandom(12)+"]},";
		series+="{\"name\":\"线下offline1\", \"data\":["+getRandom(6)+"]},";
		series+="{\"name\":\"线下offline2\", \"data\":["+getRandom(9)+"]},";
		series+="{\"name\":\"线下offline3\",  \"data\":["+getRandom(12)+"]}";
		
			
		Map<String, String> dtm=new HashMap<String, String>();
		dtm.put(HCGlobal.title, title);
		dtm.put(HCGlobal.subTitle, subTitle);
		dtm.put(HCGlobal.xAxis_categories,sb.toString());
		dtm.put(HCGlobal.yAxis_title, yAxis_title);
		dtm.put(HCGlobal.tooltip_valueSuffix, tooltip_valueSuffix);
		dtm.put(HCGlobal.series, series);
		
//		System.out.println(highchartData.getLineBase(dtm));
		
		return highchartData.getLineBase(dtm);
	}
	
	public static String getRandom(int count){
		Random rd=new Random();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<count;i++){
			sb.append(rd.nextInt(100)+",");
		}
		sb.setLength(sb.length()-1);
		return sb.toString();
	}

	public static void main(String[] args) {

	}

}
