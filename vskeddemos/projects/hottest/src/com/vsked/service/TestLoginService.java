package com.vsked.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.vsked.dao.TestLoginDao;

public class TestLoginService {
	
	public static boolean testLogin(HttpServletRequest req){
		boolean loginState=false;
		String s="";
		s+=req.getParameter("uname");
		s+=req.getParameter("upass");
		Map<String, String> m=TestLoginDao.getUser(req.getParameter("uname"));
		if(m.get("uname").equals(req.getParameter("uname")) && m.get("upass").equals(req.getParameter("upass"))){
			s="登陆成功了!少年加油喽11";
			req.setAttribute("msg", s);
			loginState=true;
		}else{
			s="大侠名或密码错误请重新来过11";
			req.setAttribute("msg", s);
		}
		System.out.println(s);
		return loginState;
	}

}
