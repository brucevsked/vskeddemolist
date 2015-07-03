package com.hs.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public class BaseController {
	
	public static Map<String,String> getMapInParameter(HttpServletRequest r){
		Map<String,String> m=new HashMap<String,String>();
		Enumeration<?> e=r.getParameterNames();
		while(e.hasMoreElements()){
			String s=(String) e.nextElement();
			m.put(s, r.getParameter(s));
		}
		BaseLog.outPutBasicMap(m);
		return m;
	}
	
	public static Map<String,String> getMapInAttribute(HttpServletRequest r){
		Map<String,String> m=new HashMap<String,String>();
		Enumeration<?> e=r.getAttributeNames();
		while(e.hasMoreElements()){
			String s=(String) e.nextElement();
			m.put(s, r.getParameter(s));
		}
		BaseLog.outPutBasicMap(m);
		return m;
	}
	
	public static boolean isNotNullInParameter(HttpServletRequest r,String p){
		return r.getParameter(p)!=null;
	}
	
	public static boolean isNotNullInAttribute(HttpServletRequest r,String p){
		return r.getAttribute(p)!=null;
	}

}
