package com.vsked.dao;

import java.util.List;
import java.util.Map;

public interface SysUserDao {
	
	public Map<String, Object> getSysUserBySuName(String suName);
	
	public Map<String, Object> getSysUserBySuId(String suId);
	
	public int getSysUserCount(Map<String, Object> m);
	
	public List<Map<String,Object>> getSysUserList(Map<String, Object> m);
	
	/**
	 * @功能描述：	获取未和代理商绑定的用户信息
	 *
	 * @作者：zhangpj		@创建时间：2016年12月20日
	 * @return
	 */
	public List<Map<String,Object>> getSysUsersByNotAgentUserId();
	
	public int sysUserAdd(Map<String, Object> m);
	
	public int sysUserEdit(Map<String, Object> m);
	
	public int sysUserDel(String suId);
	
	public int sysUserPassChange(Map<String, Object> m);
	
	public Map<String, Object> agentGetByUserId(String suId);
	
}
