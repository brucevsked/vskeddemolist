package com.vsked.dao;

import java.util.List;
import java.util.Map;

public interface SysFunctionDao {
	
	public List<Map<String, Object>> getSysFunctionList(Map<String,Object> m);//分页查询
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
	
	public int sysFunctionAdd(Map<String, Object> m);
	
	public int sysFunctionEdit(Map<String, Object> m);
	
	public int sysFunctionDel(String sfId);
	
	
}
