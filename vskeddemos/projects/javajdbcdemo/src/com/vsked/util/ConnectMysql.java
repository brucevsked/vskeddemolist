package com.vsked.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ConnectMysql {

	private static Connection conn;
	private static PreparedStatement pt = null;
	private static ResultSet rs = null;
	private static String dbHost="192.168.1.201";
	private static String dbName="mysql";
	private static String userName = "root";
	private static String userPassword = "110";
	private static String dbPort="3306";
	private static String url = "jdbc:mysql://192.168.1.201:3306/customs?user=root&password=root&useUnicode=true&characterEncoding=utf-8";

	public static Connection getMySqlConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		url="jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName+"?user="+userName+"&password="+userPassword+"&useUnicode=true&characterEncoding=utf-8&port="+dbPort+"&autoReconnect=true";
		System.out.println(url);
		conn = DriverManager.getConnection(url);
		return conn;
	}

	public static void closeMySqlConnection() {
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
		}

	}

	public static void main(String[] args) throws Exception {
		Connection conn = ConnectMysql.getMySqlConnection();
		String sql = "select * from help_category ";
		PreparedStatement pt = conn.prepareStatement(sql);
		ResultSet rs=pt.executeQuery();
		while(rs.next()){
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
		closeMySqlConnection();
	}

}
