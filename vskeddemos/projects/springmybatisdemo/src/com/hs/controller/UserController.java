package com.hs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hs.bean.BaseUserT;
import com.hs.service.BaseUserTService;
import com.hs.util.BaseController;
import com.hs.util.BaseValidate;
import com.hs.util.GlobalControllerPath;

@Controller
@RequestMapping(value=GlobalControllerPath.userC)
public class UserController extends BaseController{
	
	@Autowired
	BaseUserTService buts;
	
	/*
	@RequestMapping(value="login")
	public ModelAndView login() {
		ModelAndView mav=new ModelAndView();
		
		return mav;		
	}
	*/
	
	@RequestMapping(value="add")
	public String add(BaseUserT u){
		buts.add(u);
		return toIndex();
	}
	
	@RequestMapping(value="edit")
	public String edit(BaseUserT u){
		buts.update(u);
		return toIndex();
	}
	
	@RequestMapping(value="toIndex")
	public String toIndex(){
		return "index";
	}
	
	@RequestMapping(value="toLogin")
	public String toLogin(){
		return "user/login";
	}
	
	@RequestMapping(value="toAdd")
	public String toAdd(HttpServletRequest r){
		r.setAttribute("method", "add");
		return "user/userop";
	}
	
	@RequestMapping(value="toEdit")
	public String toEdit(HttpServletRequest r){
		r.setAttribute("method", "edit");
		if(isNotNullInParameter(r, "buId") && BaseValidate.isNumber(r.getParameter("buId")));
		r.setAttribute("u", buts.queryById(Integer.parseInt(r.getParameter("buId"))));
		return "user/userop";
	}
	
	@RequestMapping(value="usersList")
	public String queryAll(HttpServletRequest r){
		r.setAttribute("dataList", buts.queryAll());
		return "user/usersList";
	}

}
