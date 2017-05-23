package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vsked.service.SysDictionaryTypeSer;

@Controller
public class DictionaryTypeController {
	
	@Autowired
	SysDictionaryTypeSer sysDictionaryTypeSer;
	
	@GetMapping("dictionaryTypeListPage")
	public String dictionaryTypeListPage(){
		return "dictionaryTypeList";
	}
	
	@PostMapping("dictionaryTypeListData")
	@ResponseBody
	public String dictionaryTypeListData(HttpServletRequest req){
		return sysDictionaryTypeSer.sysDictionaryTypeList(req);
	}
	
	@PostMapping("dictionaryTypeListDataAll")
	@ResponseBody
	public String dictionaryTypeListDataAll(){
		return sysDictionaryTypeSer.sysDictionaryTypeListAll();
	}

	@GetMapping("dictionaryTypeAddPage")
	public String dictionaryTypeAddPage(){
		return "dictionaryTypeAdd";
	}
	
	@PostMapping("dictionaryTypeAddProc")
	@ResponseBody
	public String dictionaryTypeAddProc(HttpServletRequest req){
		return sysDictionaryTypeSer.dictionaryTypeAddProc(req);
	}
	
	@GetMapping("dictionaryTypeEditPage")
	public String dictionaryTypeEditPage(HttpServletRequest req){
		return sysDictionaryTypeSer.dictionaryTypeEditPage(req);
	}
	
	@PostMapping("dictionaryTypeEditProc")
	@ResponseBody
	public String dictionaryTypeEditProc(HttpServletRequest req){
		return sysDictionaryTypeSer.dictionaryTypeEditProc(req);
	}
}
