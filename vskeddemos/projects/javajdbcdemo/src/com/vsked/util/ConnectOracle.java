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
	private static String dbName="ORCLVSKED";
	private static String userName = "scott";
	private static String userPassword = "Y4yhl9tbf110";
	private static String dbPort="1521";
	private static String url = "";

	public static Connection getMySqlConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver").newInstance();
		conn = DriverManager.getConnection("jdbc:oracle:thin:@"+dbHost+":"+dbPort+":"+dbName, userName, userPassword);
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
		Connection conn = ConnectOracle.getMySqlConnection();
		String sql = "select * from user_tables ";
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
