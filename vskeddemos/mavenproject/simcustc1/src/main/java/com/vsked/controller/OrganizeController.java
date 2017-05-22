package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vsked.service.SysOrganizeSer;

@Controller
public class OrganizeController {
	
	@Autowired
	SysOrganizeSer sysOrganizeSer;
	
	@GetMapping("organizeListPage")
	public String organizeListPage(){
		return "organizeList";
	}
	
	@PostMapping("organizeListData")
	@ResponseBody
	public String organizeListData(HttpServletRequest req){
		return sysOrganizeSer.sysOrganizeList(req);
	}
	
	@PostMapping("organizeListDataAll")
	@ResponseBody
	public String organizeListDataAll(){
		return sysOrganizeSer.sysOrganizeListAll();
	}
	
	@GetMapping("organizeAddPage")
	public String organizeAddPage(){
		return "organizeAdd";
	}
	
	@PostMapping("organizeAddProc")
	@ResponseBody
	public String organizeAddProc(HttpServletRequest req){
		return sysOrganizeSer.organizeAddProc(req);
	}
	
	@GetMapping("organizeEditPage")
	public String organizeEditPage(HttpServletRequest req){
		return sysOrganizeSer.organizeEditPage(req);
	}
	
	@PostMapping("organizeEditProc")
	@ResponseBody
	public String organizeEditProc(HttpServletRequest req){
		return sysOrganizeSer.organizeEditProc(req);
	}

}
