package com.vsked.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
	
	public Logger log = Logger.getLogger(UserController.class);
	
	@GetMapping("index")
	public String index(){
		System.out.println("get index");
		log.info("here is messagea1");
		return "index";
	}

}
