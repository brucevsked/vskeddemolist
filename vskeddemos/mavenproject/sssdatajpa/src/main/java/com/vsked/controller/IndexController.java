package com.vsked.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value="index")
	public String index(){
		System.out.println(11);
		return "index";
	}
	
	@RequestMapping(value="hello")
	public String hello(){
		System.out.println(22);
		return "hello";
	}
}
