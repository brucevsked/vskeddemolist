package com.vsked.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test1Service extends BaseService{
	
	private static final Logger log=LogManager.getLogger(Test1Service.class);
	
	public static  String proc1(HttpServletRequest req){
		String result="";
		Map<String, Object> m=getMaps(req);
		result="test1 back|"+m;
		log.debug(result);
		return result;
	}

}
