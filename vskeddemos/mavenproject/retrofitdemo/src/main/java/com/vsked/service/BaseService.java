package com.vsked.service;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseService {
	
	private static final Logger log=LogManager.getLogger(BaseService.class);
	
	public static Map<String,Object> getMaps(HttpServletRequest req){
		Map<String,Object> m=new HashMap<String, Object>();
		Enumeration<String> e=req.getParameterNames();
		while(e.hasMoreElements()){
			String s=(String) e.nextElement();
			m.put(s, req.getParameter(s));
		}
		log.debug(m);
		return m;
	}
	
}
