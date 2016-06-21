package com.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="user")
public class UserController {
	/**
	 * 跳转到myjsp页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "myjsp")
	public String home() {
		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser.isPermitted("user.html?myjsp")){
			return "my";
		}else{
			return "error/noperms";
		}
	}
	@RequestMapping(params = "notmyjsp")
	public String nopermission() {
		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser.isPermitted("user.html?notmyjsp")){
			return "notmyjsp";
		}else{
			return "error/noperms";
		}
	}
}
