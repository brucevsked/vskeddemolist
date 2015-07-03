package com.vsked.util;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport{
	
	private static final long serialVersionUID = -6213389937747907710L;
	
    public Map<String,String> dataMap=new HashMap<String,String>();
	
	public Map<String,String> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String,String> dataMap) {
		this.dataMap = dataMap;
	}
}
