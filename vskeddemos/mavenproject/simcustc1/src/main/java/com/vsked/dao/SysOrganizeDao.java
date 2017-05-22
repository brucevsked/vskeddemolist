package com.vsked.dao;

import java.util.List;
import java.util.Map;

public interface SysOrganizeDao {
	
	public int getSysOrganizeCount(Map<String, Object> m);
	
	public List<Map<String,Object>> getSysOrganizeList(Map<String, Object> m);
	
	public List<Map<String,Object>> getSysOrganizeListAll();
	
	public Map<String,Object> getSysOrganizeBySoId(String soId);
	
	public int sysOrganizeAdd(Map<String, Object> m);
	
	public int sysOrganizeEdit(Map<String, Object> m);
}
