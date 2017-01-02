package com.vsked.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class UserSer extends BaseSer{
	
	public static String proc(HttpServletRequest req){
		String result="";
		
		Map<String, Object> myData=uploadFile(req);
		System.out.println(myData);
		result=myData.toString();
		
		return result;
	}

}
