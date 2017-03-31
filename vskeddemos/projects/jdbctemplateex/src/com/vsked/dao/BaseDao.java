package com.vsked.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class BaseDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
    public void add(Map m){
    	
    }
    
    public void edit(Map m){
    	
    }
    
    public void del(Map m){
    	
    }
    
    public List findAll(Map m){
    	List l=new ArrayList();
    	return l;
    }
	
}
