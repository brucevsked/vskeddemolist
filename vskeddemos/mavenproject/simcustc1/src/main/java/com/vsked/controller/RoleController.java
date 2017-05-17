package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vsked.service.SysRoleSer;

@Controller
public class RoleController {
	
	@Autowired
	SysRoleSer sysRoleSer;
	
	@GetMapping("roleListPage")
	public String roleListPage(){
		return "roleList";
	}
	
	@PostMapping("roleListData")
	@ResponseBody
	public String roleListData(HttpServletRequest req){
		return sysRoleSer.sysRoleList(req);
	}

	@GetMapping("roleAddPage")
	public String roleAddPage(){
		return "roleAdd";
	}
	
	@PostMapping("roleAddProc")
	@ResponseBody
	public String roleAddProc(HttpServletRequest req){
		return sysRoleSer.roleAddProc(req);
	}
	
	@GetMapping("roleEditPage")
	public String roleEditPage(HttpServletRequest req){
		return sysRoleSer.roleEditPage(req);
	}
	
	@PostMapping("roleEditProc")
	@ResponseBody
	public String roleEditProc(HttpServletRequest req){
		return sysRoleSer.roleEditProc(req);
	}
}
