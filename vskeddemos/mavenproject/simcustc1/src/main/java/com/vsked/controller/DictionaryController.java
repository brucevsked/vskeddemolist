package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vsked.service.SysDictionarySer;

@Controller
public class DictionaryController {
	
	@Autowired
	SysDictionarySer sysDictionarySer;
	
	@GetMapping("dictionaryListPage")
	public String dictionaryListPage(){
		return "dictionaryList";
	}
	
	@PostMapping("dictionaryListData")
	@ResponseBody
	public String dictionaryListData(HttpServletRequest req){
		return sysDictionarySer.sysDictionaryList(req);
	}
	
	@GetMapping("dictionaryAddPage")
	public String dictionaryAddPage(){
		return "dictionaryAdd";
	}
	
	@PostMapping("dictionaryAddProc")
	@ResponseBody
	public String dictionaryAddProc(HttpServletRequest req){
		return sysDictionarySer.dictionaryAddProc(req);
	}
	
	@GetMapping("dictionaryEditPage")
	public String dictionaryEditPage(HttpServletRequest req){
		return sysDictionarySer.dictionaryEditPage(req);
	}
	
	@PostMapping("dictionaryEditProc")
	@ResponseBody
	public String dictionaryEditProc(HttpServletRequest req){
		return sysDictionarySer.dictionaryEditProc(req);
	}

}
