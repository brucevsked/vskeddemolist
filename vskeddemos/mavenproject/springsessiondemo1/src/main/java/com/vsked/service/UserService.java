package com.vsked.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vsked.dao.UserDao;


@Service
@Transactional
public class UserService {
	
	Logger  log = Logger.getLogger(UserService.class);
	
	@Autowired
	UserDao userDao;
	
	public String loginproc(HttpServletRequest req){
		String resultPage="index";
		try{
			log.debug("login");
			String userName=req.getParameter("userName");
			String userPass=req.getParameter("userPass");
			Map<String, Object> userMap=userDao.getUserByName(userName);
			if(userMap!=null){
				if(userMap.get("userPass").equals(userPass)){
					req.getSession().setAttribute("userSession", userMap);
					req.getSession().setAttribute("backMsg", "登录成功!");
					log.debug("login ok");
				}else{
					req.getSession().setAttribute("backMsg", "密码错误");
					log.debug("login password wrong");
				}
			}else{
				req.getSession().setAttribute("backMsg", "用户名不存在");
				log.debug("login user not exists");
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return resultPage;
	}
	
	public String logout(HttpServletRequest req){
		String resultPage="login";
		try{
		HttpSession session=req.getSession();
		session.removeAttribute("backMsg");
		session.removeAttribute("userSession");
		session.invalidate();
		log.debug("logout");
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return resultPage;
	}

}
