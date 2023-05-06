package com.jat.auth.service;

import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jat.auth.infrastructure.persistence.jpa.UserDto;
import com.jat.auth.infrastructure.persistence.jpa.UserRepository;

@Service
public class TestUserService {
	
	private static final Logger log = LoggerFactory.getLogger(TestUserService.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public void test(UserDto user) {
		log.info("TestUserService test start");
		userRepository.save(user);
		log.info("TestUserService test end");
	}
	
	public UserDto findByid(int id) {
		return userRepository.findByid(id);
	}
	
	public List<UserDto> findAllBy() {
		return userRepository.findAllBy();
	}
	
}
