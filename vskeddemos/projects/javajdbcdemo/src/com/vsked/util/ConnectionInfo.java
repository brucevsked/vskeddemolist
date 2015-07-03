package com.vsked.util;


public class ConnectionInfo {
	/**
	 * database username
	 */
	private String userName;
	/**
	 * password
	 */
	private String userPass;
	/**
	 * server address
	 */
	private String serverAddr;
	/**
	 * database port
	 */
	private int dbPort;
	/**
	 * databaseName
	 */
	private String dbName;
	/**
	 * driver String 
	 */
	private String driverStr;
	
	/**
	 * database type
	 */
	private String dbType;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getServerAddr() {
		return serverAddr;
	}
	public void setServerAddr(String serverAddr) {
		this.serverAddr = serverAddr;
	}
	public int getDbPort() {
		return dbPort;
	}
	public void setDbPort(int dbPort) {
		this.dbPort = dbPort;
	}
	
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDriverStr() {
		return driverStr;
	}
	public void setDriverStr(String driverStr) {
		this.driverStr = driverStr;
	}
	
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public ConnectionInfo() {
	}
	
	public static ConnectionInfo getDefaultSqlServer2000Info(){
		ConnectionInfo ci=new ConnectionInfo();
		ci.setDriverStr(DatabaseDriverString.SQLSERVER2000_DRIVER);
		ci.setDbName("pubs");
		ci.setServerAddr("localhost");
		ci.setDbPort(1433);
		ci.setUserName("sa");
		ci.setUserPass("123456");
		ci.setDbType("MsSqlServer2000");
		return ci;
	}
	public static ConnectionInfo getDefaultOracleInfo(){
		ConnectionInfo ci=new ConnectionInfo();
		ci.setDriverStr(DatabaseDriverString.ORACLE_DRIVER);
		ci.setDbName("orcl");
		ci.setServerAddr("localhost");
		ci.setDbPort(1521);
		ci.setUserName("scott");
		ci.setUserPass("tiger");
		ci.setDbType("Oracle");
		return ci;
	}
	public static ConnectionInfo getDefaultMySqlInfo(){
		ConnectionInfo ci=new ConnectionInfo();
		ci.setDriverStr(DatabaseDriverString.MYSQL_DRIVER);
		ci.setDbName("mysql");
		ci.setServerAddr("localhost");
		ci.setDbPort(3306);
		ci.setUserName("root");
		ci.setUserPass("root");
		ci.setDbType("MySql");
		return ci;
	}
	
	
}
