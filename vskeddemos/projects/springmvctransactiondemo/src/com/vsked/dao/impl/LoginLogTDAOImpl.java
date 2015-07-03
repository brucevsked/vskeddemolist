package com.vsked.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vsked.dao.LoginLogTDAO;

@Repository
public class LoginLogTDAOImpl implements LoginLogTDAO{

	@Autowired
	JdbcTemplate jt;

	public int addLog(Map m) {
		int c=0;
		String sql="insert into LoginLogT(userId,ip,loginDate) values (?,?,current_timestamp);";
		try{
		Object[] o=new Object[]{m.get("userId"),m.get("ip")};
		c=jt.update(sql,o);
		}catch (Exception e) { }
		return c;
	}
}
