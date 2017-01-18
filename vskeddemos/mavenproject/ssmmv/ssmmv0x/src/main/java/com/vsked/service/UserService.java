package com.vsked.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.vsked.dao.UserDAO;

@Service
public class UserService {
    
    @Autowired
    private UserDAO userDao;
    
    public boolean register(String username,String password){
    	boolean isRegisterSuccess=false;
    	try{
    		Map<String, Object> user=new HashMap<String, Object>();
    		user.put("username", username);
    		user.put("password", password);
    		isRegisterSuccess=userDao.register(user);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return isRegisterSuccess;
    }
    
    public ModelAndView login(String username, String password) {
    	ModelAndView modelAndView = new ModelAndView();
    	try{
    		Map<String, Object> user=userDao.login(username, password);
            if(user == null){
                modelAndView.addObject("message", "用户不存在或者密码错误！请重新输入");
                modelAndView.setViewName("error");
            }else{
                modelAndView.addObject("user", user);
                modelAndView.setViewName("userinfo");
            }
    	}catch(Exception e){
    		e.printStackTrace();
            modelAndView.addObject("message", "登陆发生异常:"+e.getMessage());
            modelAndView.setViewName("error");
    	}
        return modelAndView;
    }
}
