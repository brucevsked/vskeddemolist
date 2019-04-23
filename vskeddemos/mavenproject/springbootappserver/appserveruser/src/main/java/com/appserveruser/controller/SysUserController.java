package com.appserveruser.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appserveruser.service.SysUserService;

@RestController
public class SysUserController {
	
	@Autowired
	SysUserService sysUserService;
	
	@RequestMapping("/")
	public String index(HttpServletRequest req){
		return "hello appserveruser";
	}
	
	@RequestMapping("/getuser")
	public String getUser(HttpServletRequest req){
		String suid="10000000000000000000000000000001";
		String userMap=sysUserService.getUser(suid);
		return userMap;
	}
	

}
