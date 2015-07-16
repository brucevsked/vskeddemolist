package com.vsked.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Connection {
	private static Connection con;
    private static ComboPooledDataSource cpds; 
	
	public C3p0Connection(){ }
	
	public static Connection getConnection(){
		if (cpds == null) { initDataSource(); }
		try {
			con = cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void initDataSource(){
		cpds=new ComboPooledDataSource(true);
	}
	
	

	public static void main(String[] args) {
		Connection con;
		try {
			con = C3p0Connection.getConnection();
			String sql = "select * from help_category";
			PreparedStatement pt = con.prepareStatement(sql);
			ResultSet rs=pt.executeQuery();
			while(rs.next()){
				for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
