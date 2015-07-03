package com.vsked.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class BaseController {
	
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public Map<Integer,String> setClientRequestTime(Map<Integer,String> pm){
		pm=new HashMap<Integer, String>();
		pm.put(4, new Timestamp(System.currentTimeMillis()).toString()); //客户端请求时间
		return pm;
	}
	public Map<Integer,String>  setMsg(Map<Integer,String> pm,String p1,String p2,String p3){
		pm.put(1, p1); //返回成功还是失败 0为失败 1为成功
		pm.put(2, p2); //错误消息
		pm.put(3, p3); //成功时返回消息体 失败时可以不取
		return pm;
	}
	public Map<Integer,String> setServerResponseTime(Map<Integer,String> pm){
		pm.put(5, new Timestamp(System.currentTimeMillis()).toString()); //服务端响应时间
		return pm;
	}
	
	/**
	 * 获取分页信息
	 * @param request
	 * @return Page
	 */
	public Page getPage(HttpServletRequest request){
		int pagenum=Integer.parseInt((request.getParameter("pagenum")!=null && !"".equals(request.getParameter("pagenum"))?request.getParameter("pagenum"):"1"));
		int pagesize = Integer.parseInt((request.getParameter("pagesize")!=null && !"".equals(request.getParameter("pagesize"))?request.getParameter("pagesize"):"10"));
		Page page=new Page(pagenum,pagesize);
		return page;
	}
	
	/**
	 * 获取参数
	 * @param r
	 * @return
	 */
	public Map getMaps(HttpServletRequest r){
		Map m=new HashMap();
		Enumeration e=r.getParameterNames();
		while(e.hasMoreElements()){
			String s=(String) e.nextElement();
			m.put(s, r.getParameter(s));
		}
		return m;
	}
	
	@RequestMapping(value="/{url}",method=RequestMethod.GET)
	public String toUrl(@PathVariable("url") String u){
		return "/"+u;
	}
	
	
	public Class<?> getObject(@ModelAttribute("o") Class<?> c){
		return c;
	}
	//抽取object然后对object进行操作 区分不同类型操作 添加与修改
	/*
	public T Class<T> getObject(@ModelAttribute("o") Class<T>){
		
	}
	*/
}
