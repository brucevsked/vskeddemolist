package com.vsked.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;


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
		int maxWait = 0;
		int maxActive = 0;
		try {
			String path = DbcpConnection.class.getClass().getResource("/").getPath();
			is = new FileInputStream(path + "dbcp1.properties");
			p.load(is);
			driverClassName = p.getProperty("dbcp1.driverClassName");
			url = p.getProperty("dbcp1.url");
			username = p.getProperty("dbcp1.username");
			password = p.getProperty("dbcp1.password");

			initialSize = Integer.parseInt(p.getProperty("dbcp1.initialSize"));
			minIdle = Integer.parseInt(p.getProperty("dbcp1.minIdle"));
			maxIdle = Integer.parseInt(p.getProperty("dbcp1.maxIdle"));
			maxWait = Integer.parseInt(p.getProperty("dbcp1.maxWait"));
			maxActive = Integer.parseInt(p.getProperty("dbcp1.maxActive"));
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
		ds.setMaxActive(maxActive);
		ds.setMinIdle(minIdle);
		ds.setMaxIdle(maxIdle);
		ds.setMaxWait(maxWait);
		ds.setRemoveAbandoned(true);
		ds.setRemoveAbandonedTimeout(2000);
		dataSource = ds;

	}

	public static void print() {
		BasicDataSource ds = (BasicDataSource) dataSource;
		System.out.println(ds.getInitialSize());
		System.out.println(ds.getNumActive());
		System.out.println(ds.getNumIdle());
		System.out.println(ds.getDefaultAutoCommit());
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
