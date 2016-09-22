package com.vsked.test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.vsked.database.DbTool;

public class DbTest {
	public static void main(String[] args) {
//		testGetDataSource();
//		testTransaction();
//		testGetUserBalanceByUserName();
//		testGetUUID();
		testUserRecharge();
	}

	public static void testGetDataSource() {
		try {
			DataSource ds = DbTool.getDataSource();
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from account");
			while (rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void testTransaction() {
		DataSource ds = null;
		Connection conn = null;
		try {
			ds = DbTool.getDataSource();
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from account");
			while (rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}
			conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (conn != null) {
					conn.rollback();
					conn.setAutoCommit(true);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}
	
	public static void testGetUserBalanceByUserName(){
		String username="testuser1";
		String userBalance=DbTool.getUserBalanceByUserName(username);
		System.out.println(userBalance);
	}
	
	public static void testGetUUID(){
		String myUUID=DbTool.getUUID();
		System.out.println(myUUID);
	}
	
	public static void testUserRecharge(){
		String username="testuser1";
		BigDecimal money=new BigDecimal("-3111");
		DbTool.userRecharge(username, money);
	}

}
