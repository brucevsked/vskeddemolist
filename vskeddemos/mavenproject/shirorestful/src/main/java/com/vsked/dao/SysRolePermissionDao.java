package com.vsked.dao;

import java.util.List;
import java.util.Map;


public interface SysRolePermissionDao {
	
	public List<Map<String, Object>> getSysRolePermissionBySrId(String srId);
	
	public int getSysRolePermissionCount(Map<String, Object> m);
	
	public List<Map<String, Object>> getHasSysPermissionList(String srId);//查询已分配用户
	
	public List<Map<String, Object>> getNoSysPermissionList(String srId);//查询未分配用户
	
	public int sysRolePermissionDelBySrId(String srId);//根据角色ID删除
	
	public int sysRolePermissionAdd(Map<String,Object> m);
}
