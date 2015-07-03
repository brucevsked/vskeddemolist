package com.vsked.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vsked.po.Login;
import com.vsked.service.ILoginService;

@Controller
@Results({  
	  @Result(name="input", location="login/Login.jsp"),
	  @Result(name="succ", location="login/Welcome.jsp")
	}) 
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 5033459742031477727L;
	
	@Autowired
	private ILoginService loginService;
	private String username;
	private String password;
	
	@Action("/Login")
	public String login() throws Exception {
		
		Login lg = loginService.getByID(username);
		if(lg == null)
			return "input";
		else
		{
			 ActionContext.getContext().getSession().put("user", lg);
	         return "succ";
		}
    }
	
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    } 

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}