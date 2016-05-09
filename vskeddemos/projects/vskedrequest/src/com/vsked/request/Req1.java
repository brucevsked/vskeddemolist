package com.vsked.request;

import com.vsked.util.ToolHttp;


public class Req1 {

	public static void main(String[] args) {
		xwwwformurlencodedSend();
//		formdataSend();
//		jsonSend();
//		textxmlSend();

	}
	
	public static void xwwwformurlencodedSend(){
		String postMethod="application/x-www-form-urlencoded";
		testR1(postMethod);
	}
	
	public static void formdataSend(){
		String postMethod="multipart/form-data";
		testR1(postMethod);
	}
	
	public static void jsonSend(){
		String postMethod="application/json";
		testR1(postMethod);
	}
	
	public static void textxmlSend(){
		String postMethod="text/xml";
		testR1(postMethod);
	}
	
	public static void testR1(String postMethod){
		String url="http://127.0.0.1:8080/vskedrequest/resp/r1.jsp";
		String orderid="0429326171241361";
		String state="9999";
		String failtime="2016-04-22 10:04:19";
		String faildesc="订单状态充值失败";
		
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		
		sb.append(getJsonKey("status")+":"+getJsonKey("0000")+",");
		sb.append(getJsonKey("userid")+":"+getJsonKey("146")+",");
		sb.append(getJsonKey("reports")+":");
		sb.append("[");
		
		sb.append("{");
		sb.append(getJsonKey("orderid")+":"+getJsonKey(orderid)+",");
		sb.append(getJsonKey("state")+":"+getJsonKey(state)+",");
		sb.append(getJsonKey("failtime")+":"+getJsonKey(failtime)+",");
		sb.append(getJsonKey("faildesc")+":"+getJsonKey(faildesc)+"");
		sb.append("}");
		
		sb.append("]");
		
		sb.append("}");
		
		String responseMsg=ToolHttp.post(false, url, sb.toString(), postMethod);
		System.out.println(responseMsg);
	}
	
	public static String getJsonKey(String s){
		return "\""+s+"\"";		
	}

}
