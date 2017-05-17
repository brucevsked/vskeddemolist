package com.vsked.dao;

import java.util.List;
import java.util.Map;


public interface SysRoleMenuDao {
	
	public List<Map<String, Object>> getHasSysRoleList(String smId);//查询已分配角色
	
	public List<Map<String, Object>> getNoSysRoleList(String smId);//查询未分配角色
	
	public int sysRoleMenuAdd(Map<String,Object> m);
	
	public int sysRoleMenuDelBySrId(String srId);//根据角色ID删除
	
	public int sysRoleMenuDelBySmId(String smId);//根据菜单ID删除
}
