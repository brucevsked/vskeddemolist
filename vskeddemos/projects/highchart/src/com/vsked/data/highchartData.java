package com.vsked.data;

import java.util.Map;

import com.vsked.highchart.HCGlobal;

public class highchartData {
	
	public static String getJsonKey(String key){
		return "\""+key+"\"";
	}
	
	public static String getLineBase(Map<String, String> dtm){
		StringBuilder sb=new StringBuilder();
		sb.append("{");//start chart
		sb.append(getJsonKey("credits")+":{"+getJsonKey("enabled")+":false},");
		if(dtm.containsKey(HCGlobal.title)){
			sb.append(getJsonKey("title")+":{"+getJsonKey("text")+":"+getJsonKey(dtm.get(HCGlobal.title))+"},");
		}
		if(dtm.containsKey(HCGlobal.subTitle)){
			sb.append(getJsonKey("subtitle")+":{"+getJsonKey("text")+":"+getJsonKey(dtm.get(HCGlobal.subTitle))+"},");
		}
		
		sb.append(getJsonKey("xAxis") + ": {"); //start x
		if(dtm.containsKey(HCGlobal.xAxis_categories)){
			sb.append(getJsonKey("categories")+":["+dtm.get(HCGlobal.xAxis_categories)+"]");
		}
		sb.append("},");//end x
		
		sb.append(getJsonKey("yAxis")+": {");//start y
		
		if(dtm.containsKey(HCGlobal.yAxis_title)){
			sb.append(getJsonKey("title")+": { "+getJsonKey("text")+": "+getJsonKey(dtm.get(HCGlobal.yAxis_title))+"}");
		}
		
		sb.append("},");//end y
		
		sb.append(getJsonKey("tooltip")+": {");
		if(dtm.containsKey(HCGlobal.tooltip_valueSuffix)){
			sb.append(getJsonKey("valueSuffix")+": "+getJsonKey(dtm.get(HCGlobal.tooltip_valueSuffix))+"");
		}
		sb.append("},");
		
		sb.append(getJsonKey("series")+":["+dtm.get(HCGlobal.series)+"]");
		sb.append("}");//end chart
		
		return sb.toString();
	}
	

}
