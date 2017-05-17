package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vsked.service.CarrierSer;

@Controller
public class CarrierController {
	
	@Autowired
	CarrierSer carrierSer;
	
	@GetMapping("carrierListPage")
	public String carrierListPage(){
		return "carrierList";
	}
	
	@PostMapping("carrierListData")
	@ResponseBody
	public String carrierListData(HttpServletRequest req){
		return carrierSer.carrierList(req);
	}
	
	@GetMapping("carrierAddPage")
	public String carrierAddPage(){
		return "carrierAdd";
	}
	
	@PostMapping("carrierAddProc")
	@ResponseBody
	public String carrierAddProc(HttpServletRequest req){
		return carrierSer.carrierAddProc(req);
	}
	
	@GetMapping("carrierEditPage")
	public String carrierEditPage(HttpServletRequest req){
		return carrierSer.carrierEditPage(req);
	}
	
	@PostMapping("carrierEditProc")
	@ResponseBody
	public String carrierEditProc(HttpServletRequest req){
		return carrierSer.carrierEditProc(req);
	}
}
