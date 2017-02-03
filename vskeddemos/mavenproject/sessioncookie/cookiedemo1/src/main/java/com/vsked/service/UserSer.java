package com.vsked.service;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vsked.common.CookieUtil;
import com.vsked.dao.UserDao;

public class UserSer {
	
	String cookiUserName="myCookieA1userName";
	String cookiUserPass="myCookieA1userPass";
	
	UserDao userDao=new UserDao();
	
	public String login(HttpServletRequest req,HttpServletResponse res){
		String resultPage="../login.jsp";
		try{
			String userName=req.getParameter("userName");
			String userPass=req.getParameter("userPass");
			Map<String, String> userMap=userDao.getUserByUserName(userName);
			if(userMap!=null && userMap.get("userPass").equals(userPass)){
				resultPage="../index.jsp";
				req.getSession().setAttribute("userSession", userMap);
				
				int maxAge=30*24*60*60; //一个月
				
				Cookie myCookie=CookieUtil.getCookieByName(req, cookiUserName);
				if(myCookie==null){
					CookieUtil.addCookie(res, cookiUserName, userName, maxAge);
					CookieUtil.addCookie(res, cookiUserPass, userPass, maxAge);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultPage;
	}
	
	public String logout(HttpServletRequest req){
		String resultPage="../index.jsp";
		try{
			req.getSession().removeAttribute("userSession");
			resultPage="../login.jsp";
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultPage;
	}

}
