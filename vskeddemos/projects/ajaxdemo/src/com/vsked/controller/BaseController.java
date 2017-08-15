package com.vsked.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
	
	/**
	 * input and radio
	 * @param r
	 * @return
	 */
	public static Map<String,Object> getMaps(HttpServletRequest r){
		Map<String,Object> m=new HashMap<String, Object>();
		Enumeration<String> e=r.getParameterNames();
		while(e.hasMoreElements()){
			String s=(String) e.nextElement();
			m.put(s, r.getParameter(s));
		}
		return m;
	}
	
	/**
	 * input text,radio,checkbox
	 * @param r
	 * @return
	 */
	public static Map<String,Object> getMapsEx1(HttpServletRequest r){
		Map<String,Object> m=new HashMap<String, Object>();
		Enumeration<String> e=r.getParameterNames();
		while(e.hasMoreElements()){
			String s=(String) e.nextElement();
			String[] checkValues=r.getParameterValues(s);
			m.put(s, checkValues.length==1?r.getParameter(s):checkValues);
		}
		return m;
	}
}

