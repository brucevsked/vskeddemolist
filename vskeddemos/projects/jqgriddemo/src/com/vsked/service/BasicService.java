package com.vsked.service;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public class BasicService {
	
	public static String getJsonKey(String key){
		return "\""+key+"\"";
	}
	
	public String getMyAppPath(HttpServletRequest req){
		return req.getSession().getServletContext().getRealPath("/").replace("\\", "/");
	}
	
	public Map<String,Object> getMaps(HttpServletRequest req){
		Map<String,Object> m=new HashMap<String, Object>();
		Enumeration<?> e=req.getParameterNames();
		while(e.hasMoreElements()){
			String s=(String) e.nextElement();
			m.put(s, req.getParameter(s));
		}
		return m;
	}
}
