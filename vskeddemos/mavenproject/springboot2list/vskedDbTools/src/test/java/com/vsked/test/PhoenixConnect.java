package com.vsked.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.vsked.vskedDbTools.test.BaseTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PhoenixConnect extends BaseTest{
	
	@Test
	public void query() {
		log.info("----------start phoenix query----------");
		try {
			String driverClassName="org.apache.phoenix.jdbc.PhoenixDriver";
			String jdbcUrl="jdbc:phoenix:dev1centos7:2181";
			String userName="";
			String password="";
			Class.forName(driverClassName);//1
			Connection conn = DriverManager.getConnection(jdbcUrl,userName,password);
			String sql = "SELECT * from vskedtest";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				log.info(rs.getString(1) + rs.getString(2));
			}
			rs.close();
			ps.close();
			conn.close();
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}
		log.info("----------end phoenix query----------");
	}

}
