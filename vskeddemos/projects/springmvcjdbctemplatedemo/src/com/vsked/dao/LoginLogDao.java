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
		String sqlString = "insert into LoginLog_T (loginLog,userid, ip, loginDate) values(?,?,?,?)";
		jdbcTemplate.update(sqlString, new Object[]{jdbcTemplate.queryForInt("select count(1)+1 from LoginLog_T"),loginLog.getUserId(),loginLog.getIp(), loginLog.getLoginDate()});
	}
}
