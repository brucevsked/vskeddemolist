package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vsked.service.UserService;

@Controller
//@Scope("prototype") //开启非单例模式 用于并发控制
@RequestMapping(value="UserController")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("toLoginPage")
	public String toLoginPage(){
		return "login";
	}
	
	@RequestMapping("toIndexPage")
	public String toIndexPage(){
		return "index";
	}
	
	@RequestMapping("loginproc")
	public String loginproc(HttpServletRequest req){
		return userService.loginproc(req);
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest req){
		return userService.logout(req);
	}
	
}
