package com.vsked.dao;

import java.util.List;
import java.util.Map;

public interface SysDictionaryTypeDao {
	
	public Map<String, Object> getSysDictionaryTypeBySdtId(String sdtId);
	
	public int getSysDictionaryTypeCount(Map<String, Object> m);
	
	public List<Map<String,Object>> getSysDictionaryTypeList(Map<String, Object> m);
	
	public int sysDictionaryTypeAdd(Map<String, Object> m);
	
	public int sysDictionaryTypeEdit(Map<String, Object> m);
	
	public int sysDictionaryTypeDel(String sdtId);
	
}
