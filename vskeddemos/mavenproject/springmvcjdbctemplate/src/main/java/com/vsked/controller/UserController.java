package com.vsked.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@Scope("prototype") //开启非单例模式 用于并发控制
@RequestMapping(value="UserController")
public class UserController {
	
	@RequestMapping("toLoginPage")
	public String toLoginPage(){
		return "login";
	}
	
}
