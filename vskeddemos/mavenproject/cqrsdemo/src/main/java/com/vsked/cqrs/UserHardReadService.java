package com.vsked.cqrs;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class UserHardReadService {
	
	@Resource
	UserHardReadRepository userHardReadRepository;
	
	public List<UserHardRead> queryAll() {
		List<UserHardRead> userHardList=userHardReadRepository.findAll();
		return userHardList;
	}
	
	public UserHardRead query(UserHardRead userHard) {
		UserHardRead userHardResult=userHardReadRepository.findById(userHard.getUserId()).get();
		return userHardResult;
	}

}
