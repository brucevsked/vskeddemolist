package com.vsked.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.vsked.entity.User;
import com.vsked.interceptor.UserInterceptor;

@Before(UserInterceptor.class)
public class UserController extends Controller{
	
	public void index(){
		Page<User> p=User.dao.list(getParaToInt(0, 1),10);
		setAttr("p", p);
		render("/userList.jsp");
	}
	
	public void add(){
		User u=this.getModel(User.class);
		//u.set("id", "userseq.nextval");  //oracle 设置序列
		u.save();
		forwardAction("/user");
	}
	
	public void update(){
		User u=this.getModel(User.class);
		u.update();
		forwardAction("/user");
	}
	
	public void del(){
		User.dao.deleteById(getParaToInt());
		forwardAction("/user");
	}
	
}
