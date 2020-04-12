package com.vsked.cqrs;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class UserEasyReadService {
	
	@Resource
	UserEasyRepository userEasyRepository;
	
	public List<UserEasy> queryAll() {
		List<UserEasy> userEasyList=userEasyRepository.findAll();
		return userEasyList;
	}
	
	public UserEasy query(UserEasy userEasy) {
		UserEasy userEasyResult=userEasyRepository.findById(userEasy.getUserId()).get();
		return userEasyResult;
	}

}
