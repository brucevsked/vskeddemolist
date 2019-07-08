package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsked.service.WebUserService;

@RestController
public class WebUserController {
	
	@Autowired
	WebUserService webUserService;
	
	@RequestMapping("/api/v1/testadd")
	public String testadd(HttpServletRequest req){
		return webUserService.add1(req);
	}
	
	@RequestMapping("/api/v1/testlist")
	public String testlist(HttpServletRequest req){
		return webUserService.list1(req);
	}

}
