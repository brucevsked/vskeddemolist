package com.vsked.dao;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vsked.mapper.UserMapper;

@Repository
public class UserDAO {
    
    @Autowired
    private UserMapper userMapper;
    
    public boolean register(Map<String, Object> user){
        return userMapper.insertUser(user)==1?true:false;
    }
    
    public Map<String, Object> login(String username ,String password){
        return userMapper.selectByUsernameAndPwd(username, password);
    }
}
