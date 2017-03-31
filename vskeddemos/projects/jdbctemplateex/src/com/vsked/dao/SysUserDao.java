package com.vsked.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SysUserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate1;
	
	public List<Map<String, Object>> getSysUserList(){
		String sql="select * from SYSUSERT";
		return jdbcTemplate1.queryForList(sql);
	}

}
