package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vsked.service.SysFunctionSer;

@Controller
public class FunctionController {
	
	@Autowired
	SysFunctionSer sysFunctionSer;
	
	@GetMapping("functionListPage")
	public String functionListPage(){
		return "functionList";
	}
	
	@PostMapping("functionListData")
	@ResponseBody
	public String functionListData(HttpServletRequest req){
		return sysFunctionSer.sysFunctionList(req);
	}
	
	@GetMapping("functionAddPage")
	public String functionAddPage(){
		return "functionAdd";
	}
	
	@PostMapping("functionAddProc")
	@ResponseBody
	public String functionAddProc(HttpServletRequest req){
		return sysFunctionSer.functionAddProc(req);
	}
	
	@GetMapping("functionEditPage")
	public String functionEditPage(HttpServletRequest req){
		return sysFunctionSer.functionEditPage(req);
	}
	
	@PostMapping("functionEditProc")
	@ResponseBody
	public String functionEditProc(HttpServletRequest req){
		return sysFunctionSer.functionEditProc(req);
	}
}
