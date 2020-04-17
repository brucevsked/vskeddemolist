package com.vsked.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vsked.service.SysUserService;

@Controller
public class SysUserController {
	
	@Autowired
	SysUserService sysUserService;
	
    @RequestMapping("/api/user")
    @ResponseBody
	public String list() {
		return sysUserService.list();
	}

}
