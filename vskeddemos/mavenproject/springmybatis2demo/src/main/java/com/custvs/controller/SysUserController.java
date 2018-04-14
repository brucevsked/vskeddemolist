package com.custvs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.custvs.service.SysUserService;

@Controller
@RequestMapping(value="SysUserController")
public class SysUserController {
	
	@Autowired
	SysUserService sysUserService;
	
	@RequestMapping("/toUserLogin")
	public String toUserLogin(){
		return "system/sysUserLogin";
	}
	
	@RequestMapping("/toIndex")
	public String toIndex(){
		return "system/index";
	}
	
	@PostMapping("/sysUserLoginPc")
	@ResponseBody
	public String sysUserLoginPc(HttpServletRequest req) throws Exception{
		return sysUserService.sysUserLoginPc(req);
	}

}
