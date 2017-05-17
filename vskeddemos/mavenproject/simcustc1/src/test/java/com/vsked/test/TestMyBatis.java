package com.vsked.test;


import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Log4jConfigurer;

import com.vsked.dao.SysUserDao;
import com.vsked.service.SysUserSer;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:xml/spring-context-*.xml" })
/* 无论怎样都自动回滚
@Transactional
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
*/
public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	
	@Before
	public void initLog4j(){
        try {  
            Log4jConfigurer.initLogging("classpath:properties/log4j.properties");  
        } catch (Exception ex) {  
            System.err.println("Cannot Initialize log4j");  
        } 
	}
	
	@Autowired
	SysUserSer sysUserSer;
	
	@Autowired
	SysUserDao sysUserDao;

//	@Test
	public void testService(){
		String suName="admin";
		Map<String, Object> sysUser=sysUserSer.getSysUserBySuName(suName);
		logger.info(sysUser);
		
	}
	
//	@Test
	public void testDao(){
		String suName="admin";
        Map<String, Object> sysUser=sysUserDao.getSysUserBySuName(suName);
		logger.info(sysUser);
	}
	
//	@Test
	public void testA1(){
		logger.info(1);
	}
}
