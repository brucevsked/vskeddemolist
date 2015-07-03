package com.vsked.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Results({  
	  @Result(name="logina", location="login/Login.jsp")  
	}) 
public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = -6388663777202488265L;

	@Action("/Index")
	public String index() throws Exception {
        return "logina";
    }

}