package com.vsked.dao;

import java.util.List;
import java.util.Map;

public interface SysFunctionDao {
	
	/**
	 * 获取所有权限过滤信息 <br/>
	 * @return
	 */
	public List<Map<String, Object>> getSysFunctionList();
	
	public List<Map<String, Object>> getSysFunction(Map<String,Object> m);//分页查询
	/**
	 * 查询表中的数据数
	 * @return
	 */
	public int getSysFunctionCount(Map<String,Object> m);
	
	/**
	 * 查询列表中数据
	 * @return
	 */
	public Map<String, Object> getSysFunctionBySfId(String sfId);
	
	public List<Map<String, Object>> sysGetRoleList();//查询所有角色
	
	public List<Map<String, Object>> sysGetPermissionList();//查询所有权限
	
	public int sysFunctionAdd(Map<String, Object> m);
	
	public int sysFunctionEdit(Map<String, Object> m);
	
	public int sysFunctionDel(String sfId);
	
	
}
