package com.vsked.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vsked.entity.User;
import com.vsked.util.BaseController;

@Controller
@RequestMapping (value="/restc")
public class RestController extends BaseController{

	@RequestMapping(value = "/login/{userName}", method = RequestMethod.GET)
	public ModelAndView myMethod(HttpServletRequest req,HttpServletResponse res, @PathVariable("userName") String u,ModelMap mm) throws Exception {
		mm.put("loginUser", u);
		return new ModelAndView("/login/logined", mm);
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String registPost() {
		return "/index";
	}
	
	@RequestMapping(value = "/userOperate", method = RequestMethod.POST)
	@ResponseBody
	public String userOperate(HttpServletRequest r) {
		Map m=getMaps(r);
		return m.toString();
	}
	
	@RequestMapping(value = "/userOperate1", method = RequestMethod.POST)
	@ResponseBody
	public String userOperate1(User u) {
		String s="";
		s+="{";
		s+="userId:"+u.getUserId()+",";
		s+="userName:"+u.getUserName()+",";
		s+="userNickName:"+u.getUserNickName()+",";
		s+="userPass:"+u.getUserPass()+",";
		s+="userPass1:"+u.getUserPass1()+",";
		s+="userEmail:"+u.getUserEmail()+",";
		s+="userMobile:"+u.getUserMobile()+"";
		s+="}";
		return s;
	}
}
