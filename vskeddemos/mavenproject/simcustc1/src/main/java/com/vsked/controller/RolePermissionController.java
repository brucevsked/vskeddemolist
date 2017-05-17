package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vsked.service.SysRolePermissionSer;

@Controller
public class RolePermissionController {
	
	@Autowired
	SysRolePermissionSer sysRolePermissionSer;
	
	@GetMapping("rolePermissionListPage")
	public String rolePermissionListPage(HttpServletRequest req){
		return sysRolePermissionSer.rolePermissionListPage(req);
	}
	
	@PostMapping("hasSysRoleListPermission")
	@ResponseBody
	public String hasSysRoleListPermission(HttpServletRequest req){
		return sysRolePermissionSer.hasSysRoleList(req);
	}
	
	@PostMapping("noSysRoleListPermission")
	@ResponseBody
	public String noSysRoleListPermission(HttpServletRequest req){
		return sysRolePermissionSer.noSysRoleList(req);
	}
	
	@PostMapping("rolePermissionProc")
	@ResponseBody
	public String rolePermissionProc(HttpServletRequest req){
		return sysRolePermissionSer.rolePermissionProc(req);
	}
}
