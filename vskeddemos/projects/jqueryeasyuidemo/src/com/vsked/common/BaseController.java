package com.vsked.common;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
	
	public static Map getMaps(HttpServletRequest r){
		Map m=new HashMap();
		Enumeration e=r.getParameterNames();
		while(e.hasMoreElements()){
			String s=(String) e.nextElement();
			m.put(s, r.getParameter(s));
		}
		return m;
	}
	

}

