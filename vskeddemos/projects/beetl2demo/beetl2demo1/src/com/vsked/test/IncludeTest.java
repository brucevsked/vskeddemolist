package com.vsked.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.ext.servlet.ServletGroupTemplate;

public class IncludeTest {
	
	public static void procReq(HttpServletRequest req, HttpServletResponse res){
		res.setContentType("text/html;charset=UTF-8");			
		ServletGroupTemplate.instance().render("/testInclude/index.html", req, res);
	}

}
