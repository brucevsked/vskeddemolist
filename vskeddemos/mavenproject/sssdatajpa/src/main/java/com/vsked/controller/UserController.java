package com.vsked.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vsked.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value="user/findByUserName")
	@ResponseBody
	public String findByUserName(@RequestParam("userName") String userName){
		String s="111";
		s=userService.findByUserName(userName);
		return s;
	}
	
	@RequestMapping(value="user/getAllUser",method=RequestMethod.POST)
	@ResponseBody
	public String getAllUser(){
		return userService.getAllUser();
	}
	


}
