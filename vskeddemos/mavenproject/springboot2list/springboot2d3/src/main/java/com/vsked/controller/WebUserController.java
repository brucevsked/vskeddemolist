package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vsked.service.WebUserService;

@Controller
public class WebUserController {
	
	@Autowired
	WebUserService webUserService;
	
	@RequestMapping("/webapi/v1/towebuserlist")
	public ModelAndView towebuserlist(HttpServletRequest req){
		return new ModelAndView("manager/user/webUserList");
	}
	
	@RequestMapping("/webapi/v1/webuserlist")
	@ResponseBody
	public String webuserlist(HttpServletRequest req){
		return webUserService.webUserList(req);
	}
}
