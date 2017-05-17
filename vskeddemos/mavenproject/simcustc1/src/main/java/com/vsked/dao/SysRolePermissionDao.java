package com.vsked.dao;

import java.util.List;
import java.util.Map;


public interface SysRolePermissionDao {
	
	public List<Map<String, Object>> getSysRolePermissionBySrId(String srId);
	
	public List<Map<String, Object>> getHasSysPermissionList(String srId);//查询已分配用户
	
	public List<Map<String, Object>> getNoSysPermissionList(String srId);//查询未分配用户
	
	public List<Map<String, Object>> getHasSysRoleList(String spId);//查询已分配角色
	
	public List<Map<String, Object>> getNoSysRoleList(String spId);//查询未分配角色
	
	public int sysRolePermissionAdd(Map<String,Object> m);
	
	public int sysRolePermissionDelBySrId(String srId);//根据角色ID删除
	
	public int sysRolePermissionDelBySpId(String spId);//根据权限ID删除
}
