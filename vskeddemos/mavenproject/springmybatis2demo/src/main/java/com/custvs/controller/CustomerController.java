package com.custvs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="CustomerController")
public class CustomerController {
	
	@RequestMapping("/toCustomerNav")
	public String toCustomerNav(){
		return "customer/customerNav";
	}
	
}
