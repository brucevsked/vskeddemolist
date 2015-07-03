package com.vsked.dao;

import java.util.Map;

import com.vsked.util.Page;

public interface BasicDao {	
	public int getCount(String inTbName,Map<String, String> m);
	public String getWhereSql(Map<String, String> m);
	public Page getList(String inTbName,Page p,Map<String, String> m);
}
