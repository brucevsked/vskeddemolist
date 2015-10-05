package com.vsked.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vsked.util.DbDrivers;

public class ConnectOracle {
	private static Connection conn;
	private static String dbHost="VskedWa1";
	private static String dbName="orcl";
	private static String userName = "aaabbb";
	private static String userPassword = "aaabbb";
	private static String dbPort="1521";
	private static String url = DbDrivers.oraclelUrl;

	public static Connection getConnection() throws Exception {
		Class.forName(DbDrivers.oraclelDriver).newInstance();
		url="jdbc:oracle:thin:@"+dbHost+":"+dbPort+":"+dbName;
		conn = DriverManager.getConnection(url,userName,userPassword);
		return conn;
	}
	
	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		ConnectOracle.conn = conn;
	}

	public static String getDbHost() {
		return dbHost;
	}

	public static void setDbHost(String dbHost) {
		ConnectOracle.dbHost = dbHost;
	}

	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		ConnectOracle.dbName = dbName;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		ConnectOracle.userName = userName;
	}

	public static String getUserPassword() {
		return userPassword;
	}

	public static void setUserPassword(String userPassword) {
		ConnectOracle.userPassword = userPassword;
	}

	public static String getDbPort() {
		return dbPort;
	}

	public static void setDbPort(String dbPort) {
		ConnectOracle.dbPort = dbPort;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		ConnectOracle.url = url;
	}

	public static void main(String[] args) throws Exception {
		Connection c = ConnectOracle.getConnection();
		String sql = "select * from testTableInfo ";
		PreparedStatement pt = c.prepareStatement(sql);
		ResultSet rs=pt.executeQuery();
		while(rs.next()){
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
		//insert the test data
		//insertTestData(c);
		//c.commit();
		
		try {
			if (rs != null) {
				rs.close();
			}
			if (pt != null) {
				pt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("close connection fail");
		}
	}
	
	public static void insertTestData(Connection inConn) throws Exception{
		Connection c=inConn;
		Statement st=c.createStatement();
		for(int i=2;i<1000;i++){
		st.addBatch("insert into testTableInfo(testIds,testNumberA,testVarchar,testVarchar2,testNVarchar2,testChar,testNChar) values ("+i+", "+GenerateData.getFloatData(10)+", '"+GenerateData.getStringLow(5)+GenerateData.getChineseString1(5)+"', '"+GenerateData.getStringLow(5)+GenerateData.getChineseString1(5)+"', '"+GenerateData.getStringLow(5)+GenerateData.getChineseString1(5)+"','"+GenerateData.getStringLow(5)+GenerateData.getChineseString1(5)+"', '"+GenerateData.getStringLow(5)+GenerateData.getChineseString1(5)+"' )");
		}
		st.executeBatch();
	}

}
