package com.vsked.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.vsked.dao.UserTDAO;

@Repository
public class UserTDAOImpl implements UserTDAO{
	
	@Autowired
	JdbcTemplate jt;

	public int addUser(Map m) {
		int c=0;
		String sql="insert into UsersT(userName,password,credits,lastIp,lastVisit) values (?,?,?,?,current_timestamp)";
		try{
		Object[] o=new Object[]{m.get("userName"),m.get("password"),m.get("credits"),m.get("lastIp")};
		c=jt.update(sql,o);
		}catch (Exception e) { }
		return c;
	}
	
	public int updateUserLastIP(Map m) {
		int c=0;
		String sql="update UsersT set lastIp=?,lastVisit=current_timestamp where userId=?";
		try{
		Object[] o=new Object[]{m.get("ip"),m.get("userId")};
		c=jt.update(sql,o);
		
		System.out.println("this is ef");
		throw new Exception("let's gos error");
		
		}catch (Exception e) { 
			System.out.println("this is will rollback");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return c;
	}

	public Map userLogin(Map m) {
		String sql="select * from UsersT where userName=? and password=? ";
		Map rm=null;
		try{
		   Object[] o=new Object[]{m.get("userName"),m.get("password")};
		   rm=jt.queryForMap(sql,o);
		}catch (Exception e) {  }
		return rm;
	}
	
	

}
