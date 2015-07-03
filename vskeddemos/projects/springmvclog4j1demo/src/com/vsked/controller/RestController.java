package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vsked.util.BaseLog;

@Controller
public class RestController {

	public RestController() {

	}

	@RequestMapping(value = "/login/{userName}", method = RequestMethod.GET)
	public ModelAndView myMethod(HttpServletRequest req,HttpServletResponse res, @PathVariable("userName") String u,ModelMap mm) throws Exception {
		mm.put("loginUser", u);
		BaseLog.getLog(this.getClass(), new Exception("login as "+u));
		return new ModelAndView("/login/logined", mm);
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String registPost() {
		BaseLog.getLog(this.getClass(), new Exception("U have welcome"));
		return "/index";
	}
}
