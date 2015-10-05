package com.vsked.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectSqlserver {

	private static Connection conn;
	private static PreparedStatement pt = null;
	private static ResultSet rs = null;
	private static String dbHost="127.0.0.1";
	private static String dbName="aabb";
	private static String userName = "aabb";
	private static String userPassword = "aabb";
	private static String dbPort="1433";

	public static Connection getMySqlConnection() throws Exception {
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection("jdbc:sqlserver://"+dbHost+":"+dbPort+";databaseName="+dbName, userName, userPassword);
		return conn;
	}

	public static void main(String[] args) throws Exception {
		Connection conn = ConnectSqlserver.getMySqlConnection();
		
		//insertTestData(conn);
		
		String sql = "select * from testpagea1 ";
		pt = conn.prepareStatement(sql);
		rs=pt.executeQuery();
		while(rs.next()){
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
	}
	
	public static void insertTestData(Connection inConn) throws Exception{
		Connection c=inConn;
		Statement st=c.createStatement();
		for(int i=1;i<1000;i++){
		st.addBatch("insert into testpagea1(testid,testname) values ("+i+", '"+GenerateData.getStringLow(5)+GenerateData.getChineseString1(5)+"')");
		}
		st.executeBatch();
	}

}
