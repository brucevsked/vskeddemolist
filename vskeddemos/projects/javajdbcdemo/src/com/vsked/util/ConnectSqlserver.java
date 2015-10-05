package com.vsked.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * connect sqlserver2008
 * @author brucevsked
 *
 */
public class ConnectSqlserver {

	private static Connection conn;
	private static PreparedStatement pt = null;
	private static ResultSet rs = null;
	private static String dbHost="127.0.0.1";
	private static String dbName="sssttest";
	private static String userName = "sa";
	private static String userPassword = "sa";
	private static String dbPort="1433";

	public static Connection getMySqlConnection() throws Exception {
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection("jdbc:sqlserver://"+dbHost+":"+dbPort+";databaseName="+dbName, userName, userPassword);
		return conn;
	}

	public static void main(String[] args) throws Exception {
		Connection conn = ConnectSqlserver.getMySqlConnection();
		String sql = "select * from testtablea1 ";
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
