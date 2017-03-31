package com.vsked.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vsked.service.BaseService;

@Controller
@RequestMapping(value="BaseController")
public class BaseController {
	
	@Autowired
	BaseService bs;
	
	@RequestMapping("/index")
	public String index(){
		
		return "test/index";
	}
	
	@RequestMapping("/addOrUpDate")
	public String addOrUpDate(HttpServletRequest r){
		Map m=getMaps(r);
		//TODO we can write this map to db
		Iterator<Map.Entry> it=m.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry et=it.next();
			System.out.println("|"+et.getKey()+" | "+et.getValue()+"|");
		}
		return index();
	}
	
	public Map getMaps(HttpServletRequest r){
		Map m=new HashMap();
		Enumeration e=r.getParameterNames();
		while(e.hasMoreElements()){
			String s=(String) e.nextElement();
			m.put(s, r.getParameter(s));
		}
		return m;
	}

}
