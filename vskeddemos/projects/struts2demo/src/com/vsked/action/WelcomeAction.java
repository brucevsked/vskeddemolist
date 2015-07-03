package com.vsked.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.vsked.util.BasicAction;

@Namespace("/")
public class WelcomeAction extends BasicAction{
	
	private static final long serialVersionUID = -8080082320299626760L;

	@Action(value="welcome" , results={@Result(name="w",location="/jsp/index.jsp")})
	public String welcome(){
		System.out.println("welcome Young man");
		return "w";
	}
}
