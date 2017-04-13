package com.vsked.test;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Log4jConfigurer;

import com.vsked.dao.DuiYingDao;
import com.vsked.service.TmpAgentService;


@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:xml/spring-context-*.xml" })
/* 无论怎样都自动回滚
@Transactional
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
*/
public class TestJdbcTemplate {
	private static Logger log = Logger.getLogger(TestJdbcTemplate.class);
	
	@Before
	public void initLog4j(){
        try {  
            Log4jConfigurer.initLogging("classpath:properties/log4j.properties");  
        } catch (Exception ex) {  
            System.err.println("Cannot Initialize log4j");  
        } 
	}
	
	@Resource
	DuiYingDao duiYingDao;
	
	@Autowired
	TmpAgentService tmpAgentService;

	
//	@Test
	public void testDao(){
		List<Map<String, Object>> dataList=duiYingDao.getAll();
		log.debug(dataList.size());
	}
	
	@Test
	public void testService(){
		tmpAgentService.testService1();
	}
	
	
	public void testA1(){
		log.info(1);
	}
}
