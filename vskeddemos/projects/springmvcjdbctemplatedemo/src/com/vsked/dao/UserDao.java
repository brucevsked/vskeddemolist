package com.vsked.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.vsked.entity.User;


@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getMatchCount(String userName, String password) {
		String sqlString = "select count(*) from Users_T where username = ? and password = ?";
		return jdbcTemplate.queryForObject(sqlString, Integer.class,  new Object[]{userName, password});
	}
	
	public User findUserByUserName(final String userName) {
		String sqlString = "select userid, username, credits from Users_T where username=?";
		final User user = new User();
		jdbcTemplate.query(sqlString, new Object[] {userName},
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						user.setUserId(rs.getInt("userid"));
						user.setUserName(userName);
						user.setCredits(rs.getInt("credits"));
					}
		});
		return user;
	}
	
	
	public void updateLoginInfo(User user) {
		String sqlString = "update Users_T set lastvisit=?, lastip=?,credits=? where userid=?";
		jdbcTemplate.update(sqlString, new Object[]{user.getLastVisit(), user.getLastIp(),user.getCredits(), user.getUserId()});
		try{
			System.out.println("this is e");
			throw new Exception("let's gos error");
		}catch (Exception e) {
			System.out.println("this is ea1");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}
}
