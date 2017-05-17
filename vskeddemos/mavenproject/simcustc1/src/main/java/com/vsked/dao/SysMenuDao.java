package com.vsked.dao;

import java.util.List;
import java.util.Map;

public interface SysMenuDao {
	
	public int getSysMenuCount(Map<String, Object> m);
	
	public List<Map<String,Object>> getSysMenuList(Map<String, Object> m);
	
	public Map<String,Object> getSysMenuBySmId(String smId);
	
	/**
	 * 根据用户编号获取用户拥有菜单，其实这个菜单是跟用户所在角色绑定的,先会查出用户所有角色,再根据所有角色查询角色拥有菜单
	 * @param suId
	 * @return
	 */
	public List<Map<String,Object>> getSysUserMenuBySuId(String suId);
	
	public int sysMenuAdd(Map<String, Object> m);
	
	public int sysMenuEdit(Map<String, Object> m);
	
}
