package com.vsked.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.vsked.bean.User;
import com.vsked.dao.UserRepository;

@Transactional
@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public String findByUserName(String userName){
		String s="222";
		List<User> userList=userRepository.findByUserName(userName);
		s=JSON.toJSONString(userList);
		return s;
	}
	
	public String getAllUser(){
		Iterable<User> userAll=userRepository.findAll();
		List<User> userList=new LinkedList<User>();
		userAll.forEach(u->{userList.add(u);});
		String s=JSON.toJSONString(userList);
		return s;
	}
}
