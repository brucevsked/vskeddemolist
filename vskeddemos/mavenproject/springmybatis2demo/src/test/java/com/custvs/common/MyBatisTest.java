package com.custvs.common;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:xml/spring-context-*.xml" })
/* 无论怎样都自动回滚
@Transactional
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
*/
public class MyBatisTest {
	
	private static final Logger log=LoggerFactory.getLogger(MyBatisTest.class);
	
}
