package com.vsked.dao;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.vsked.test.BaseDaoTest;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SysUserDaoTest extends BaseDaoTest {
	
	@Autowired
	SysUserDao sysUserDao;
	
	@Autowired
	DataSourceTransactionManager dataSourceTransactionManager;
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
//	@Test
	public void list(){
		List<Map<String, Object>> dataList=sysUserDao.list();
		log.error(dataList+"");
	}
	
//	@Test
	public void testInsert() {
		long begin = System.nanoTime();
		for(int i=8;i<12;i++) {
		Map<String, Object> userMap=new HashMap<String, Object>();
		userMap.put("sysuserid", i);
		userMap.put("sysusername", "vsked1001"+i);
		userMap.put("sysuserpwd", i);
		int c=sysUserDao.add(userMap);
		log.info("|"+c+"|");
		}
		
		long end = System.nanoTime();
		
		log.error("a|"+(TimeUnit.NANOSECONDS.toSeconds(end-begin))+"|s");
		
	}
	
//	@Test
	public void testInsertBatch() {
		long begin = System.nanoTime();
		//开启批量开启手动提交模式
		SqlSession sqlSession=sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH,false);
		//设置提交的dao
		sysUserDao=sqlSession.getMapper(SysUserDao.class);
		for(int i=8;i<2008;i++) {
		Map<String, Object> userMap=new HashMap<String, Object>();
		userMap.put("sysuserid", i);
		userMap.put("sysusername", "vsked1001"+i);
		userMap.put("sysuserpwd",i);
		int c=sysUserDao.add(userMap);
		log.info("|"+c+"|");
		}
		
		sqlSession.commit();//手动提交
        long end = System.nanoTime();
		
		log.error("b|"+(TimeUnit.NANOSECONDS.toSeconds(end-begin))+"|s");
		
	}
	
//	@Test
	public void testInsertPhoenix() {
		//此方案测试未通过
		long begin = System.nanoTime();
		//开启批量开启手动提交模式
		SqlSession sqlSession=sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH,false);
		String sql="upsert into vskedtest(id,testname,userid) values (?, ?, ?)";
		try {
			PreparedStatement ps=sqlSession.getConnection().prepareStatement(sql);
		
		for(int i=8;i<1000;i++) {
		//Map<String, Object> userMap=new HashMap<String, Object>();
		ps.setInt(1, i);
		ps.setString(2, "vsked1001"+i);
		ps.setInt(3, i);
		ps.addBatch();
		//int c=sysUserDao.add(userMap);
		//log.info("|"+c+"|");
		}
		
		ps.executeBatch();
		sqlSession.commit();//手动提交
		} catch (Exception e) {
			e.printStackTrace();
		}
        long end = System.nanoTime();
		
		log.error("c|"+(TimeUnit.NANOSECONDS.toSeconds(end-begin))+"|s");
	}
	
//	@Test
	public void testInsertPhoenixOnlyOne() {
		//phoenix 批量提交 ok
		long begin = System.nanoTime();
		//开启批量开启手动提交模式
		SqlSession sqlSession=sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH,false);
		Connection conn=sqlSession.getConnection();
		
		String sql="upsert into vskedtest(id,testname,userid) values (?, ?, ?)";
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps=conn.prepareStatement(sql);
		
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
		
		log.error("c|"+(TimeUnit.NANOSECONDS.toSeconds(end-begin))+"|s");
	}
	
	@Test
	public void testQuery() {
		//phoenix查询速度老样子
		long begin = System.nanoTime();
		//开启批量开启手动提交模式
		SqlSession sqlSession=sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH,false);
		Connection conn=sqlSession.getConnection();
		
		String sql="SELECT SUBSTR( wz.ps_mine_entertime, 0, 10 ) AS TIME,COUNT ( DISTINCT wz.ps_person_card ) AS rjcount FROM RYWZ wz	LEFT JOIN RYRYCdim ry ON wz.RYRY_sk = ry.RYRY_sk	group by time";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				log.error(rs.getString(1));
			}
		    conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
        long end = System.nanoTime();
		
		log.error("c|"+(TimeUnit.NANOSECONDS.toSeconds(end-begin))+"|s");
	}

}
