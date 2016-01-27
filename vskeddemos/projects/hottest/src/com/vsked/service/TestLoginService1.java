package com.vsked.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.vsked.dao.TestLoginDao;

public class TestLoginService1 {
	
	public static boolean testLogin(HttpServletRequest req){
		boolean loginState=false;
		String s="";
		s+=req.getParameter("uname");
		s+=req.getParameter("upass");
		Map<String, String> m=TestLoginDao.getUser(req.getParameter("uname"));
		if(m.get("uname").equals(req.getParameter("uname")) && m.get("upass").equals(req.getParameter("upass"))){
			s="hello word this is test登陆成功了!少年加油喽222";
			req.setAttribute("msg", s);
			loginState=true;
		}else{
			s="hello word this is testvvt大侠名或密码错误请重新来过222";
			req.setAttribute("msg", s);
		}
		System.out.println(s);
		return loginState;
	}

}
