package com.vsked.test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vsked.util.DbDrivers;
import com.vsked.util.FileProcess;

public class ConnectOracleOutJson {
	private static Connection conn;
	private static String dbHost="VskedWa1";
	private static String dbName="orcl";
	private static String userName = "brucevsked";
	private static String userPassword = "y4yhl9t";
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
		ConnectOracleOutJson.conn = conn;
	}

	public static String getDbHost() {
		return dbHost;
	}

	public static void setDbHost(String dbHost) {
		ConnectOracleOutJson.dbHost = dbHost;
	}

	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		ConnectOracleOutJson.dbName = dbName;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		ConnectOracleOutJson.userName = userName;
	}

	public static String getUserPassword() {
		return userPassword;
	}

	public static void setUserPassword(String userPassword) {
		ConnectOracleOutJson.userPassword = userPassword;
	}

	public static String getDbPort() {
		return dbPort;
	}

	public static void setDbPort(String dbPort) {
		ConnectOracleOutJson.dbPort = dbPort;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		ConnectOracleOutJson.url = url;
	}

	public static void main(String[] args) throws Exception {
		String fName="c:/tuser.txt";
		String tbName="usert";
		getAllJsonDataFromTable(tbName, fName);
	}
	
	public static void getAllJsonDataFromTable(String tbName,String fName) throws Exception{
		Connection c = ConnectOracleOutJson.getConnection();
		String sql = "select * from "+tbName.toUpperCase();
		PreparedStatement pt = c.prepareStatement(sql);
		
		ResultSet rs=pt.executeQuery();
		StringBuilder sb=new StringBuilder("[");
		while(rs.next()){
			sb.append("{");
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
				if(rs.getMetaData().getColumnType(i)==2){
					sb.append("\""+rs.getMetaData().getColumnName(i)+"\":"+rs.getString(i)+",");
				}else{
					sb.append("\""+rs.getMetaData().getColumnName(i)+"\":"+"\""+rs.getString(i)+"\",");
				}
			}
			sb.setLength(sb.length()-1);
			sb.append("},");
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
