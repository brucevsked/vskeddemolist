package com.vsked.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HikaricpTest {
	
	private static final Logger log = LoggerFactory.getLogger(HikaricpTest.class);
	
	@Test
	public void t1(){
		try{
		String configFilePath="/properties/jdbc.properties";
		HikariConfig hikariConfig = new HikariConfig(configFilePath);
		HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
		Connection conn=hikariDataSource.getConnection();
		
		String sql = "select * from lotteryDataT";
		PreparedStatement pt = conn.prepareStatement(sql);
		ResultSet rs=pt.executeQuery();
		String rowData="";
		while(rs.next()){
			rowData="";
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
				rowData+=(rs.getString(i)+"\t");
			}
			log.debug(rowData);
		}
		rs.close();
		pt.close();
		conn.close();
		hikariDataSource.close();
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}

}
