package com.hs.service;

import java.util.List;
import java.util.Map;

import com.hs.bean.BaseUserT;

public interface BaseUserTService extends BaseService {
	
	public BaseUserT queryById(int buId);  
	
	public BaseUserT queryByName(String buLoginName);  
    
    public void add(BaseUserT u);  
      
    public void update(BaseUserT u);  
    
    public void login(Map<String, String> u);  
      
    public void delete(Integer buId);  
      
    public List<BaseUserT> queryAll();  

}
