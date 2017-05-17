package com.vsked.dao;

import java.util.List;
import java.util.Map;

public interface SysRoleDao {
	
	public Map<String, Object> getSysRoleBySrId(String srId);
	
	public int getSysRoleCount(Map<String, Object> m);
	
	public List<Map<String,Object>> getSysRoleList(Map<String, Object> m);
	
	public int sysRoleAdd(Map<String, Object> m);
	
	public int sysRoleEdit(Map<String, Object> m);
	
	public int sysRoleDel(String srId);
	
}
