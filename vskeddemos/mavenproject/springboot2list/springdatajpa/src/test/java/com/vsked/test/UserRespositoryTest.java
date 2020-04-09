package com.vsked.test;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;

import com.vsked.entity.User;
import com.vsked.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserRespositoryTest extends BaseTest{
	
	@Resource
	UserRepository userRepository;
	
	@Test
	public void save() {
		User user=new User(6,"username5","thisis5");
		userRepository.save(user);
		log.debug("save ok");
	}

}
