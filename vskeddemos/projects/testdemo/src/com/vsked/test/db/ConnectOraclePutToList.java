package com.vsked.test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vsked.util.DbDrivers;
import com.vsked.util.FileProcess;

public class ConnectOraclePutToList {
	private static Connection conn;
	private static String dbHost="VskedWa1";
	private static String dbName="orcl";
	private static String userName = "ajold";
	private static String userPassword = "y4yhl9t";
	private static String dbPort="1521";
	private static String url = DbDrivers.oraclelUrl;

	public static Connection getConnection() throws Exception {
		Class.forName(DbDrivers.oraclelDriver).newInstance();
		url="jdbc:oracle:thin:@"+dbHost+":"+dbPort+":"+dbName;
		conn = DriverManager.getConnection(url,userName,userPassword);
		return conn;
	}
	
	public static void main(String[] args) throws Exception {
		String fName="c:/sameTable.txt";
		getAllDataFromTableT1(fName);
	}
	
	public void getAllDataFromTable() throws Exception{
		Connection c = ConnectOraclePutToList.getConnection();
		String sql = "select * from tdepartment ";
		PreparedStatement pt = c.prepareStatement(sql);
		ResultSet rs=pt.executeQuery();
		while(rs.next()){
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
		closeConnection(rs, pt, c);
	}
	
	public static void getAllDataFromTableT1(String fName) throws Exception{
		List<Map<String, String>> al=new ArrayList<Map<String,String>>();
		Connection c = ConnectOraclePutToList.getConnection();
		String sql = "select * from tableInfoT ";
		PreparedStatement pt = c.prepareStatement(sql);
		ResultSet rs=pt.executeQuery();
		
		StringBuilder sb=new StringBuilder("");
		while(rs.next()){
			Map<String, String> m=new HashMap<String, String>();
			m.put("tname", rs.getString(1));
			m.put("tcol", rs.getString(2));
			al.add(m);
		}
		
		for(int i=0;i<al.size();i++){
			Map<String, String> mx=al.get(i);
			sb.append("当前表:"+mx.get("tname")+"\r\n");
			int count=1;
			for(int k=al.size()-1;k>0;k--){
				Map<String, String> mc=al.get(k);
				if(mx.get("tcol").equals(mc.get("tcol")) && (!mx.get("tname").equals(mc.get("tname")))){
					sb.append("第"+count+"个重复表|表名|"+mc.get("tname")+"|\r\n");
				    count++;
				    al.remove(k);
				}
			}
		}
		FileProcess.writeFile(fName, sb.toString());
		closeConnection(rs, pt, c);

	}
	
	public static String formatLengthWithSpaceEnd(int inLength,String a){
		String s=a+"";
		StringBuilder sb=new StringBuilder(s);
		if(s.length()<inLength){
			for(int i=0;i<inLength-s.length();i++)sb.append(" ");
		}
		return sb.toString();
	}
	
	public static void closeConnection(ResultSet rs,PreparedStatement pt,Connection conn){
		try {
			if (rs != null) { rs.close(); }
			if (pt != null) { pt.close(); }
			if (conn != null) { conn.close(); }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("close connection fail");
		}
	}

}
