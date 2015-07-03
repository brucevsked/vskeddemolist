package com.vsked.test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vsked.util.DbDrivers;
import com.vsked.util.FileProcess;

public class ConnectOracle {
	private static Connection conn;
	private static String dbHost="wdd-PC";
	private static String dbName="orcl";
	private static String userName = "aj";
	private static String userPassword = "aj";
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
		String fName="c:/depart1";
		getAllDataFromTableT1(fName);
	}
	
	public void getAllDataFromTable() throws Exception{
		Connection c = ConnectOracle.getConnection();
		String sql = "select * from tdepartment ";
		PreparedStatement pt = c.prepareStatement(sql);
		ResultSet rs=pt.executeQuery();
		while(rs.next()){
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
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
	
	public static void getAllDataFromTableT1(String fName) throws Exception{
		Connection c = ConnectOracle.getConnection();
		String sql = "Select * from tdepartment t  where substr(haschild,2,1)='0' Start With t.ID =16  Connect By Prior t.ID=t.PARENTID  order by t.code desc ";
		PreparedStatement pt = c.prepareStatement(sql);
		ResultSet rs=pt.executeQuery();
		
		StringBuilder sb=new StringBuilder("[");
		while(rs.next()){
			sb.append("{ id: "+formatLengthWithSpaceEnd(10,rs.getInt("ID")+"")+", pId: "+formatLengthWithSpaceEnd(10,rs.getInt("PARENTID")+"")+", name: '"+formatLengthWithSpaceEnd(15,rs.getString("NODNAME"))+"' },\r\n");
		}
		sb.setLength(sb.length()-1);
		sb.append("]");
		FileProcess.writeFile(fName, sb.toString());
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
	
	public static String formatLengthWithSpaceEnd(int inLength,String a){
		String s=a+"";
		StringBuilder sb=new StringBuilder(s);
		if(s.length()<inLength){
			for(int i=0;i<inLength-s.length();i++)sb.append(" ");
		}
		return sb.toString();
	}

}
