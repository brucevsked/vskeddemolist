package com.vsked.cqrs;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class UserEasyWriteService {
	
	@Resource
	UserEasyRepository userEasyRepository;
	
	public void userEasyAdd(UserEasy userEasy) {
		userEasyRepository.save(userEasy);
	}
	
	public void userEasyEdit(UserEasy userEasy) {
		userEasyRepository.save(userEasy);
	}
	
	public void userEasyDelete(UserEasy userEasy) {
		userEasyRepository.delete(userEasy);
	}

}
