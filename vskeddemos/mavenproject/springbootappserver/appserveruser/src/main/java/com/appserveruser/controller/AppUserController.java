package com.appserveruser.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appserveruser.security.AuthToken;
import com.appserveruser.service.AppUserService;

@Controller
public class AppUserController {
	
	@Autowired
	AppUserService appUserService;
	
	@RequestMapping("/appuser/login")
	@ResponseBody
	public String login(HttpServletRequest req){
		return appUserService.login(req);
	}
	
	@AuthToken //需要授权验证加此注解
	@RequestMapping("/appuser/test")
	@ResponseBody
	public String test(HttpServletRequest req){
		return "you have test url";
	}

}
