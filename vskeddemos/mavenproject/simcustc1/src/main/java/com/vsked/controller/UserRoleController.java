package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vsked.service.SysUserRoleSer;

@Controller
public class UserRoleController {
	
	@Autowired
	SysUserRoleSer sysUserRoleSer;

	@GetMapping("userRoleListPage")
	public String userRoleListPage(HttpServletRequest req){
		return sysUserRoleSer.userRoleListPage(req);
	}
	
	@PostMapping("hasSysRoleList")
	@ResponseBody
	public String hasSysRoleList(HttpServletRequest req){
		return sysUserRoleSer.hasSysRoleList(req);
	}
	
	@PostMapping("noSysRoleList")
	@ResponseBody
	public String noSysRoleList(HttpServletRequest req){
		return sysUserRoleSer.noSysRoleList(req);
	}
	
	@PostMapping("userRoleProc")
	@ResponseBody
	public String userRoleProc(HttpServletRequest req){
		return sysUserRoleSer.userRoleProc(req);
	}

}
