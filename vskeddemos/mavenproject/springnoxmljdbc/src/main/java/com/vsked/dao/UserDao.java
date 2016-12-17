package com.vsked.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<String, Object> getSysUserBySuId(String suId) {
		String sql = "select * from sysUserT where suId=?";
		return jdbcTemplate.queryForMap(sql, new Object[] {suId});
	}

}
