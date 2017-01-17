package com.vsked.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsked.dao.UserDAO;
import com.vsked.model.User;

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
    
    public User login(String username, String password) {
        return userDao.login(username, password);
    }
}
