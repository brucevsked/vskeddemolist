package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vsked.service.SysRoleMenuSer;

@Controller
public class RoleMenuController {
	
	@Autowired
	SysRoleMenuSer sysRoleMenuSer;
	
	@GetMapping("roleMenuListPage")
	public String roleMenuListPage(HttpServletRequest req){
		return sysRoleMenuSer.roleMenuListPage(req);
	}
	
	@PostMapping("hasSysRoleListMenu")
	@ResponseBody
	public String hasSysRoleListMenu(HttpServletRequest req){
		return sysRoleMenuSer.hasSysRoleList(req);
	}
	
	@PostMapping("noSysRoleListMenu")
	@ResponseBody
	public String noSysRoleListMenu(HttpServletRequest req){
		return sysRoleMenuSer.noSysRoleList(req);
	}
	
	@PostMapping("roleMenuProc")
	@ResponseBody
	public String roleMenuProc(HttpServletRequest req){
		return sysRoleMenuSer.roleMenuProc(req);
	}
}
