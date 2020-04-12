package com.vsked.cqrs;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class UserHardWriteService {
	
	@Resource
	UserHardWriteRepository userHardWriteRepository;
	
	public void userHardAdd(UserHardWrite userHard) {
		userHardWriteRepository.save(userHard);
	}
	
	public void userHardEdit(UserHardWrite userHard) {
		userHardWriteRepository.save(userHard);
	}
	
	public void userHardDelete(UserHardWrite userHard) {
		userHardWriteRepository.delete(userHard);
	}

}
