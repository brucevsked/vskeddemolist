package com.vsked.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DuiYingDao {
	
	Logger  log = Logger.getLogger(DuiYingDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> getAll(){
		String sql="select * from DUIYING";
		log.debug(sql);
		return jdbcTemplate.queryForList(sql);
	}

}
