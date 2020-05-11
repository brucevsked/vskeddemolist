package com.vsked.test;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.vsked.entity.User;
import com.vsked.repository.UserRepository;
import org.testng.annotations.Test;

public class UserRespositoryTest extends BaseTest{

	Logger log= LoggerFactory.getLogger(UserRespositoryTest.class);
	
	@Resource
	UserRepository userRepository;
	
	//@Test
	public void save() {
		User user=new User(7,"username7","thisis7");
		userRepository.save(user);
		log.debug("save ok");
	}
	
//	@Test
	public void saveAll() {
		List<User> saveUserList=new LinkedList<User>();
		for(int i=10;i<50;i++) {
			saveUserList.add(new User(i,"username"+i,"thisis"+i));
		}
		userRepository.saveAll(saveUserList);
		log.debug("save batch ok");
	}
	
//	@Test
	public void delete() {
		Integer uid=6;
		userRepository.deleteById(uid);
		log.debug("delete ok");
	}
	
//	@Test
	public void edit() {
		User user=new User(1,"usernameaaa","thisisttttaaa");
		userRepository.save(user);
		log.debug("update ok");
	}
	
	@Test
	public void query() {
		List<User> userList=userRepository.findAll();
		for(User user:userList) {
			log.info(user.getUid() +user.getUsername());
		}
		
		Integer uid=7;
		User user=userRepository.findById(uid).get();
		log.info(user.getUid() +user.getUsername());
	}
	
//	@Test
	public void page1() {
		Pageable pageable=PageRequest.of(1, 5);
		List<User> userList=userRepository.findAll(pageable).getContent();
		for(User user:userList) {
			log.info(user.getUid() +user.getUsername());
		}
	}
	
//	@Test
	public void page2() {
		String sortColumn="uid";
		Pageable pageable=PageRequest.of(0, 10,Sort.Direction.ASC,sortColumn);
		List<User> userList=userRepository.findAll(pageable).getContent();
		for(User user:userList) {
			log.info(user.getUid() +user.getUsername());
		}
	}

}
