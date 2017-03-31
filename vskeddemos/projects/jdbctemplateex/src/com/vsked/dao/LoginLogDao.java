package com.vsked.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vsked.entity.LoginLog;


@Repository
public class LoginLogDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertLoginLog(LoginLog loginLog) {
		String sqlString = "insert into loginLogT (llId,usId, llIp, llDate) values(?,?,?,?)";
		jdbcTemplate.update(sqlString, new Object[]{jdbcTemplate.queryForObject("select count(1)+1 from loginLogT", Integer.class,  new Object[]{}),loginLog.getUserId(),loginLog.getIp(), loginLog.getLoginDate()});
	}
}
