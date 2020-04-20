package com.vsked.dao;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.vsked.test.BaseDaoTest;

import lombok.extern.slf4j.Slf4j;

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
	
	
	//@Test
	public void list(){
		List<Map<String, Object>> dataList=sysUserDao.list();
		log.debug(dataList+"");
	}
	
//	@Test
	public void testInsert() {
		long begin = System.nanoTime();
		for(int i=0;i<5000;i++) {
		Map<String, Object> userMap=new HashMap<String, Object>();
		userMap.put("sysuserid", "10001"+i);
		userMap.put("sysusername", "vsked1001"+i);
		userMap.put("sysuserpwd", "abc12346"+i);
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
		for(int i=0;i<50000;i++) {
		Map<String, Object> userMap=new HashMap<String, Object>();
		userMap.put("sysuserid", "10001"+i);
		userMap.put("sysusername", "vsked1001"+i);
		userMap.put("sysuserpwd", "abc12346"+i);
		int c=sysUserDao.add(userMap);
		log.info("|"+c+"|");
		}
		
		sqlSession.commit();//手动提交
        long end = System.nanoTime();
		
		log.error("b|"+(TimeUnit.NANOSECONDS.toSeconds(end-begin))+"|s");
		
	}
	
	@Test
	public void saveOrUpdateTest() {
		long begin = System.nanoTime();
		Map<String, Object> userMap=new HashMap<String, Object>();
		userMap.put("sysuserid", "10003");
		userMap.put("sysusername", "vsked=======");
		userMap.put("sysuserpwd", "abc12346");
		int c=sysUserDao.saveOrUpdate(userMap);
		log.info("|"+c+"|");
		
		long end = System.nanoTime();
		
		log.error("a|"+(TimeUnit.NANOSECONDS.toSeconds(end-begin))+"|s");
		
	}

}
