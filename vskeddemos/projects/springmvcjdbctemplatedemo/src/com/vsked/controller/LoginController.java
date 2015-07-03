package com.vsked.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vsked.entity.LoginCommand;
import com.vsked.entity.User;
import com.vsked.service.UserService;


@Controller
public class LoginController {
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping("/login")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping("/loginCheck")
	public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
		boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(),loginCommand.getPassword());
		if (!isValidUser) {
			return new ModelAndView("login", "error", "error msg uname or passs was wrong");
		} else {
			User user = userService.findUserByUserName(loginCommand.getUserName());
			user.setLastIp(request.getRemoteAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}	
	}
	
}
