package com.vsked.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jt;
	
	public Map<String, Object> getSysUserBySuId(String suId) {
		String sql = "select * from sysUserT where suId=?";
		return jt.queryForMap(sql, new Object[] {suId});
	}

}
