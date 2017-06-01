package com.vsked.dao;

import java.util.List;
import java.util.Map;

public interface SysDictionaryDao {
	
	public int getSysDictionaryCount(Map<String, Object> m);
	
	public List<Map<String,Object>> getSysDictionaryList(Map<String, Object> m);
	
	public List<Map<String,Object>> getSysDictionaryBySdtId(String sdtId);
	
	public Map<String,Object> getSysDictionaryBySdId(String sdId);
	
	public int sysDictionaryAdd(Map<String, Object> m);
	
	public int sysDictionaryEdit(Map<String, Object> m);
}
