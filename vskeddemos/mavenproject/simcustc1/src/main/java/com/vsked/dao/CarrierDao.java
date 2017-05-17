package com.vsked.dao;

import java.util.List;
import java.util.Map;

public interface CarrierDao {
	
	public int getCarrierCount(Map<String, Object> m);
	
	public List<Map<String,Object>> getCarrierList(Map<String, Object> m);
	
	public Map<String,Object> getCarrierByCarrierId(String carrierId);
	
	public int carrierAdd(Map<String, Object> m);
	
	public int carrierEdit(Map<String, Object> m);
}
