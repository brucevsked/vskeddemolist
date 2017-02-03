package com.vsked.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.vsked.dao.UserDao;

public class UserSer {
	
	UserDao userDao=new UserDao();
	
	public String login(HttpServletRequest req){
		String resultPage="../login.jsp";
		try{
			String userName=req.getParameter("userName");
			String userPass=req.getParameter("userPass");
			Map<String, String> userMap=userDao.getUserByUserName(userName);
			if(userMap!=null && userMap.get("userPass").equals(userPass)){
				resultPage="../index.jsp";
				req.getSession().setAttribute("userSession", userMap);
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
