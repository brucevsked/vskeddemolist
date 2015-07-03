package com.vsked.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;


public class BasicServlet {
	
	public static Page getPage(HttpServletRequest request){
		int pageNum=Integer.parseInt((request.getParameter("currentPage")!=null && !"".equals(request.getParameter("currentPage"))?request.getParameter("currentPage"):"1"));
		int pageSize = Integer.parseInt((request.getParameter("pageSize")!=null && !"".equals(request.getParameter("pageSize"))?request.getParameter("pageSize"):"10"));
		return new Page(pageNum,pageSize);
	}
	
	public static Map<String,String> getMapInParameter(HttpServletRequest r){
		Map<String,String> m=new HashMap<String,String>();
		Enumeration<?> e=r.getParameterNames();
		while(e.hasMoreElements()){
			String s=(String) e.nextElement();
			m.put(s, r.getParameter(s));
		}
		
		LogUtil.outPutBasicMap(m);
		
		return m;
	}
	
	public static Map<String,String> getMapInAttribute(HttpServletRequest r){
		Map<String,String> m=new HashMap<String,String>();
		Enumeration<?> e=r.getAttributeNames();
		while(e.hasMoreElements()){
			String s=(String) e.nextElement();
			m.put(s, r.getParameter(s));
		}
		
		LogUtil.outPutBasicMap(m);
		
		return m;
	}

}
