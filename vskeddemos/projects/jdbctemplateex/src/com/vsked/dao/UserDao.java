package com.vsked.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
	
	public int getMatchCount(String usName, String password) {
		String sqlString = "select count(*) from userT where usName = ? and usPass = ?";
		return jdbcTemplate.queryForObject(sqlString, Integer.class,  new Object[]{usName, password});
	}
	
	public List<Map<String, Object>> getUserList(){
		String sql="select * from userT";
		return jdbcTemplate.queryForList(sql);
	}
	
	public User findUserByUsName(final String usName) {
		String sqlString = "select usId, usName, usPass, usCredits, usLastIp, usLastVisit from userT where usName=?";
		final User user = new User();
		jdbcTemplate.query(sqlString, new Object[] {usName},
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						user.setUsId(rs.getInt("usId"));
						user.setUsName(usName);
						user.setUsCredits(rs.getInt("usCredits"));
						user.setUsLastIp(rs.getString("usLastIp"));
						user.setUsLastVisit(rs.getDate("usLastVisit"));
					}
		});
		return user;
	}
	
	
	public void updateLoginInfo(User user) {
		String sqlString = "update userT set usLastVisit=?, usLastIp=?,usCredits=? where usId=?";
		jdbcTemplate.update(sqlString, new Object[]{user.getUsLastVisit(), user.getUsLastIp(),user.getUsCredits(), user.getUsId()});
//		try{
//			System.out.println("this is e");
//			throw new Exception("let's gos error");
//		}catch (Exception e) {
//			System.out.println("this is ea1");
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//		}
	}
}
