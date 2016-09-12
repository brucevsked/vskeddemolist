package com.vsked.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ConnectOracle {

	private static Connection conn;
	private static PreparedStatement pt = null;
	private static ResultSet rs = null;
	private static String dbHost="127.0.0.1";
	private static String dbName="ORCL";
	private static String userName = "test";
	private static String userPassword = "test";
	private static String dbPort="1521";

	public static Connection getMySqlConnection() throws Exception {
		conn = DriverManager.getConnection("jdbc:oracle:thin:@"+dbHost+":"+dbPort+":"+dbName, userName, userPassword);
		return conn;
	}

	public static void main(String[] args) throws Exception {
		Connection conn = ConnectOracle.getMySqlConnection();
		String sql = "select * from user_tables ";
		pt = conn.prepareStatement(sql);
		rs=pt.executeQuery();
		while(rs.next()){
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
	}

}
