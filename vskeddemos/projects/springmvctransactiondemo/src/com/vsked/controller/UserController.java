package com.vsked.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vsked.service.UserTService;
import com.vsked.util.BaseController;

@Controller
public class UserController extends BaseController{
	
	@Autowired
	UserTService us;
	
	@RequestMapping(value = "/toIndex", method = RequestMethod.GET)
	public String toIndex() {
		return "/index";
	}
	
	@RequestMapping(value = "/userc/reg", method = RequestMethod.POST)
	public String reg(HttpServletRequest r) {
		Map m=getMaps(r);
		us.addUser(m,r);
		return toIndex();
	}
	
	@RequestMapping(value = "/userc/login", method = RequestMethod.POST)
	public String login(HttpServletRequest r) {
		Map m=getMaps(r);
		us.userLogin(m,r);
		return toIndex();
	}

}
