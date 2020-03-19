package com.vsked.service.phoenix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsked.config.PhoenixInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class SysUserPhoenixService {

	@Autowired
	PhoenixInfo phoenixInfo;

	public void testQuery() {
		log.error(phoenixInfo.getDriverClassName() + phoenixInfo.getJdbcUrl());

		try {
			Class.forName(phoenixInfo.getDriverClassName());//1

			// phoenix查询速度老样子
			long begin = System.nanoTime();
			// 开启批量开启手动提交模式 2
			Connection conn = DriverManager.getConnection(phoenixInfo.getJdbcUrl(),phoenixInfo.getUsername(),phoenixInfo.getPassword());

			String sql = "SELECT * from vskedtest";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					log.error(rs.getString(1) + rs.getString(2));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			long end = System.nanoTime();

			log.error("c|" + (TimeUnit.NANOSECONDS.toSeconds(end - begin)) + "|s");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void testBatchInsert() {
		log.error(phoenixInfo.getDriverClassName() + phoenixInfo.getJdbcUrl());

		try {
			Class.forName(phoenixInfo.getDriverClassName());//1

			// phoenix查询速度老样子
			long begin = System.nanoTime();
			// 开启批量开启手动提交模式 2
			Connection conn = DriverManager.getConnection(phoenixInfo.getJdbcUrl(),phoenixInfo.getUsername(),phoenixInfo.getPassword());

			String sql="upsert into vskedtest(id,testname,userid) values (?, ?, ?)";
			try {
				conn.setAutoCommit(false);
				PreparedStatement ps = conn.prepareStatement(sql);
				for(int i=8;i<2008;i++) {
					ps.setInt(1, i);
					ps.setString(2, "vsked1001"+i);
					ps.setInt(3, i);
					ps.execute();
					}
				conn.commit();
				if(ps!=null) {
					ps.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			long end = System.nanoTime();

			log.error("c|" + (TimeUnit.NANOSECONDS.toSeconds(end - begin)) + "|s");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
