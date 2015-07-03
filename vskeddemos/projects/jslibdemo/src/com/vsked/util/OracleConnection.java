package com.vsked.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class OracleConnection {
	
	public Connection conn;
	public PreparedStatement pt = null;
	public ResultSet rs = null;
	public String dbHost="192.168.2.217";
	public String dbName="orcl";
	public String userName = "YK";
	public String userPassword = "YK";
	public String dbPort="1521";
	
	public Connection getConnection(){
		try{
		Class.forName("oracle.jdbc.OracleDriver").newInstance();
		conn = DriverManager.getConnection("jdbc:oracle:thin:@"+dbHost+":"+dbPort+":"+dbName, userName, userPassword);
		conn.setAutoCommit(true); //for oracle commit
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("connect oracle fail"+dbHost+"|"+dbPort+"|"+userName+"|"+userPassword);
		}
		return conn;
	}
	
	public boolean executeUpdate(Connection conn,String sql) throws Exception{
		pt=conn.prepareStatement(sql);
		System.out.println(sql);
		boolean flag=pt.executeUpdate()>0;
		closeConnection();
		return flag;
		
	}
	
	
	public  void closeConnection() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pt != null) {
				pt.close();
			}
			if (conn != null) {
				conn.setAutoCommit(false);
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("close connection fail");
		}

	}
	
	public static void main(String[] args) throws Exception {
		OracleConnection oc=new OracleConnection();
		Connection c = oc.getConnection();
		String sql = "select * from vskUserT ";
		PreparedStatement pt = c.prepareStatement(sql);
		ResultSet rs=pt.executeQuery();
		while(rs.next()){
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
		oc.closeConnection();
	}
	
}
