package com.vsked.service.postgre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class SysUserPostgreService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public void testQuery() {
		//phoenix查询速度老样子
		long begin = System.nanoTime();
		//开启批量开启手动提交模式
		SqlSession sqlSession=sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH,false);//1
		Connection conn=sqlSession.getConnection();//2
		
		String sql="SELECT * from sysusert";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				log.error(rs.getString(1)+rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        long end = System.nanoTime();
		
		log.error("c|"+(TimeUnit.NANOSECONDS.toSeconds(end-begin))+"|s");
	}

}
