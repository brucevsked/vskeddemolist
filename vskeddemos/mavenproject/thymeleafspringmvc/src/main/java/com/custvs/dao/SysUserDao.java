package com.custvs.dao;

import java.util.List;
import java.util.Map;

public interface SysUserDao {
	
	public Map<String, Object> getSysUserBySuName(String suName);
	
	public Map<String, Object> getSysUserBySuId(String suId);
	
	public int getSysUserCount(Map<String, Object> m);
	
	public List<Map<String,Object>> getSysUserList(Map<String, Object> m);
	
	public int sysUserAdd(Map<String, Object> m);
	
	public int sysUserEdit(Map<String, Object> m);
	
	public int sysUserDel(String suId);
	
	public int sysUserPassChange(Map<String, Object> m);
	
}
