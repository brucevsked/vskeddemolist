package com.vsked.test.db;


import java.sql.Connection;
import java.sql.DriverManager;

import com.vsked.util.DbDrivers;

public class ConnectMysql {

	private static Connection conn;
	private static String dbHost="127.0.0.1";
	private static String dbName="mysql";
	private static String userName = "root";
	private static String userPassword = "root";
	private static String dbPort="3306";
	private static String url = DbDrivers.mysqlUrl;

	public static Connection getConnection() throws Exception {
		Class.forName(DbDrivers.mysqlDriver).newInstance();
		url="jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName+"?user="+userName+"&password="+userPassword+"&useUnicode=true&characterEncoding=utf-8&port="+dbPort;
		conn = DriverManager.getConnection(url);
		return conn;
	}
	
	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		ConnectMysql.conn = conn;
	}

	public static String getDbHost() {
		return dbHost;
	}

	public static void setDbHost(String dbHost) {
		ConnectMysql.dbHost = dbHost;
	}

	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		ConnectMysql.dbName = dbName;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		ConnectMysql.userName = userName;
	}

	public static String getUserPassword() {
		return userPassword;
	}

	public static void setUserPassword(String userPassword) {
		ConnectMysql.userPassword = userPassword;
	}

	public static String getDbPort() {
		return dbPort;
	}

	public static void setDbPort(String dbPort) {
		ConnectMysql.dbPort = dbPort;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		ConnectMysql.url = url;
	}

	/**
	 * main method
	 * @param args
	 * @throws Exception
	 */
    public static void main(String[] args) throws Exception {
    	Connection inC=ConnectMysql.getConnection();
    	String sql="show databases";
    	//new DbUtil.getTableContent(inC,sql);
	}

}
