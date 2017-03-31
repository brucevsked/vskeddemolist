package com.vsked.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vsked.service.UserService;

@Controller
@RequestMapping(value="UserController")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/userList")
	@ResponseBody
	public String userList(){
		return userService.getUserList();
	}

}
