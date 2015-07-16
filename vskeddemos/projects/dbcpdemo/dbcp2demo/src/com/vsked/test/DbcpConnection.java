package com.vsked.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;



public class DbcpConnection {
	private static DataSource dataSource;
	private static Connection con;

	public DbcpConnection() {
	}

	public static Connection getConnection() {
		if (dataSource == null) { initDataSource(); }
		try {
			con = dataSource.getConnection();
			print();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

	public static void initDataSource() {
		FileInputStream is = null;
		Properties p = new Properties();
		String driverClassName = null;
		String url = null;
		String username = null;
		String password = null;
		int initialSize = 0;
		int minIdle = 0;
		int maxIdle = 0;
		int maxWaitMillis = 0;
		int maxTotal = 0;
		try {
			String path = DbcpConnection.class.getClass().getResource("/").getPath();
			is = new FileInputStream(path + "dbcp2.properties");
			p.load(is);
			driverClassName = p.getProperty("dbcp2.driverClassName");
			url = p.getProperty("dbcp2.url");
			username = p.getProperty("dbcp2.username");
			password = p.getProperty("dbcp2.password");

			initialSize = Integer.parseInt(p.getProperty("dbcp2.initialSize"));
			minIdle = Integer.parseInt(p.getProperty("dbcp2.minIdle"));
			maxIdle = Integer.parseInt(p.getProperty("dbcp2.maxIdle"));
			maxWaitMillis = Integer.parseInt(p.getProperty("dbcp2.maxWaitMillis"));
			maxTotal = Integer.parseInt(p.getProperty("dbcp2.maxTotal"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(url);
		ds.setDriverClassName(driverClassName);
		ds.setUsername(username);
		ds.setPassword(password);

		ds.setInitialSize(initialSize);
		ds.setMaxTotal(maxTotal);
		ds.setMinIdle(minIdle);
		ds.setMaxIdle(maxIdle);
		ds.setMaxWaitMillis(maxWaitMillis);
		ds.setRemoveAbandonedTimeout(2000);
		dataSource = ds;

	}

	public static void print() {
		BasicDataSource ds = (BasicDataSource) dataSource;
		System.out.println(ds.getInitialSize());
		System.out.println(ds.getNumActive());
		System.out.println(ds.getNumIdle());
	}

	public static void main(String[] args) {

		Connection con;
		try {
			con = DbcpConnection.getConnection();
			print();
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
