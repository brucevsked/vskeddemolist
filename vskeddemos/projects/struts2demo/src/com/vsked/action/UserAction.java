package com.vsked.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.vsked.bean.Logs;
import com.vsked.bean.User;
import com.vsked.util.BasicAction;

@Namespace("/userModule")
public class UserAction extends BasicAction{
	
	private User u;
	private Logs log;
	private String avInput;
	
	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}
	
	

	public Logs getLog() {
		return log;
	}

	public void setLog(Logs log) {
		this.log = log;
	}

	public String getAvInput() {
		return avInput;
	}

	public void setAvInput(String avInput) {
		this.avInput = avInput;
	}



	private static final long serialVersionUID = -5789370736826215759L;

	@Action(value="/touserLogin" , results={@Result(name="f1",location="/jsp/userModule/login.jsp")})
	public String touserLogin(){
		return "f1";
	}
	
	@Action(value="/userLogin" , results={@Result(name="f1",location="/jsp/userModule/loginok.jsp"),@Result(name="f2",location="/jsp/userModule/loginno.jsp")})
	public String userLogin(){
		/*
		System.out.println("|userName|"+dataMap.get("userName")+"|userPass|"+dataMap.get("userPass"));
		if("vsked".equals(dataMap.get("userName"))&& "vsked".equals(dataMap.get("userPass")))
			return "f1";
        */
		System.out.println("|userName|"+u.getUserName()+"|userPass|"+u.getUserPass());
		System.out.println(log.getLogId()+"||"+log.getLogName());
		System.out.println("|"+avInput+"|");
		if("vsked".equals(u.getUserName())&& "vsked".equals(u.getUserPass()))
			return "f1";
		return "f2";
	}

}
