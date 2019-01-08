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
		return "index";
	}
	
	@PostMapping("/sysUserLoginPc")
	@ResponseBody
	public String sysUserLoginPc(HttpServletRequest req) throws Exception{
		return sysUserService.sysUserLoginPc(req);
	}
	
	@RequestMapping("/toSysUserList")
	public String toSysUserList(){
		return "system/sysUserList";
	}
	
	@PostMapping("/sysUserList")
	@ResponseBody
	public String sysUserList(HttpServletRequest req) throws Exception{
		return sysUserService.sysUserList(req);
	}
	
	@RequestMapping("/toSysUserAdd")
	public String toSysUserAdd(){
		return "system/sysUserAdd";
	}
	
	@PostMapping("/sysUserAdd")
	@ResponseBody
	public String sysUserAdd(HttpServletRequest req) throws Exception{
		return sysUserService.sysUserAdd(req);
	}
	
	@RequestMapping("/tologout")
	public String tologout(HttpServletRequest req)throws Exception{
		return sysUserService.tologout(req);
	}
	
	@RequestMapping("/toIndex1")
	public String toIndex1(HttpServletRequest req)throws Exception{
		req.setAttribute("testid", "helloworld");
		return "index1";
	}

}
