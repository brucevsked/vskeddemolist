package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vsked.service.SysPermissionSer;

@Controller
public class PermissionController {
	
	@Autowired
	SysPermissionSer sysPermissionSer;
	
	@GetMapping("permissionListPage")
	public String permissionListPage(){
		return "permissionList";
	}
	
	@PostMapping("permissionListData")
	@ResponseBody
	public String permissionListData(HttpServletRequest req){
		return sysPermissionSer.sysPermissionList(req);
	}
	
	@PostMapping("permissionListDataAll")
	@ResponseBody
	public String permissionListDataAll(){
		return sysPermissionSer.sysPermissionList();
	}
	
	@GetMapping("permissionAddPage")
	public String permissionAddPage(){
		return "permissionAdd";
	}
	
	@PostMapping("permissionAddProc")
	@ResponseBody
	public String permissionAddProc(HttpServletRequest req){
		return sysPermissionSer.permissionAddProc(req);
	}
	
	@GetMapping("permissionEditPage")
	public String permissionEditPage(HttpServletRequest req){
		return sysPermissionSer.permissionEditPage(req);
	}
	
	@PostMapping("permissionEditProc")
	@ResponseBody
	public String permissionEditProc(HttpServletRequest req){
		return sysPermissionSer.permissionEditProc(req);
	}
}
