package com.training.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.training.jpa.domain.AccountInfo;
import com.training.jpa.domain.UserInfo;
import com.training.jpa.service.UserService;

public class JPATest extends BaseTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void getAccountInfo(){
		AccountInfo account = userService.findAccountInfoById(1L);
		System.out.println("Account 余额: " + account.getBalance());
		UserInfo user = account.getUserInfo();
		System.out.println("账户所有人: " + user.getUsername());
	}
	
	@Test
	public void createAccountInfo(){
		userService.createNewAccount("sam", "password", 999999999);
	}
	
	@Test
	public void updateAccountInfo(){
		UserInfo user = new UserInfo();
		user.setPassword("password");
		user.setUsername("david");
		userService.updateAccountInfo(1L, user);
	}
	
	@Test
	public void deleteAccountInfo(){
		userService.deleteAccountInfo(1L);
	}

}
