package com.vsked.dao;

import java.util.List;
import java.util.Map;

public interface SysUserRoleDao {
	
	public List<Map<String, Object>> sysUserRoleList(Map<String,Object> m);//获取用户角色列表
	
	public List<Map<String, Object>> getSysUserRoleListBySuId(String suId);//根据用户ID查询用户角色
	
	public List<Map<String, Object>> getSysUserRoleListBySrId(String srId);//根据角色ID查询用户角色
	
	public List<Map<String, Object>> getHasSysUserList(String srId);//查询已分配用户
	
	public List<Map<String, Object>> getNoSysUserList(String srId);//查询未分配用户
	
	public List<Map<String, Object>> getHasSysRoleList(String suId);//查询已分配角色
	
	public List<Map<String, Object>> getNoSysRoleList(String suId);//查询未分配角色
				
	public int sysUserRoleAdd(Map<String,Object> m);
	
	public int sysUserRoleDelBySrId(String srId);//根据角色ID删除
	
	public int sysUserRoleDelBySuId(String suId);//根据用户ID删除
	
	public int isPermitted(Map<String,Object> m); //是否有权限操作
	
}
