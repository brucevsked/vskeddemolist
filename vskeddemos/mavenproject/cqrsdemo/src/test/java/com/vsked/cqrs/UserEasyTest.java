package com.vsked.cqrs;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;

import com.vsked.test.BaseTest;

public class UserEasyTest extends BaseTest{
	
	@Resource
	UserEasyReadService userEasyReadService;
	@Resource
	UserEasyWriteService userEasyWriteService;
	
//	@Test
	public void queryAll() {
		List<UserEasy> userEasyList=userEasyReadService.queryAll();
		for(UserEasy userEasy:userEasyList) {
			System.out.println(userEasy.toString());
		}
	}
	
//	@Test
	public void query() {
		UserEasy paramUserEasy=new UserEasy("kkv");
		UserEasy userEasy=userEasyReadService.query(paramUserEasy);
		System.out.println(userEasy.toString());
	}
	
//	@Test
	public void userEasyAdd() {
		UserEasy userEasy=new UserEasy(4,"kkv4","pass4");
		UserEasyCommand userCreateCommand=new UserEasyCreateCommand(userEasyWriteService);
		UserEasyInvoker userEasyCreateInvoker=new UserEasyInvoker(userCreateCommand);
		userEasyCreateInvoker.action(userEasy);
	}
	
//	@Test
	public void userEasyEdit() {
		UserEasy userEasy=new UserEasy(4,"kkv4aa","pass4aa");
		UserEasyCommand userCreateCommand=new UserEasyEditCommand(userEasyWriteService);
		UserEasyInvoker userEasyCreateInvoker=new UserEasyInvoker(userCreateCommand);
		userEasyCreateInvoker.action(userEasy);
	}
	
	@Test
	public void userEasyDelete() {
		UserEasy userEasy=new UserEasy(4);
		UserEasyCommand userCreateCommand=new UserEasyDeleteCommand(userEasyWriteService);
		UserEasyInvoker userEasyCreateInvoker=new UserEasyInvoker(userCreateCommand);
		userEasyCreateInvoker.action(userEasy);
	}

}
