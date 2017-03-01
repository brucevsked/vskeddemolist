package com.vsked.dao;

import java.util.List;
import java.util.Map;

public interface SysPermissionDao {
	
	public Map<String, Object> getSysPermissionBySpId(String spId);
	
	public int getSysPermissionCount(Map<String, Object> m);
	
	public List<Map<String,Object>> getSysPermissionList(Map<String, Object> m);
	
	public int sysPermissionAdd(Map<String, Object> m);
	
	public int sysPermissionEdit(Map<String, Object> m);
	
	public int sysPermissionDel(String spId);
	
}
