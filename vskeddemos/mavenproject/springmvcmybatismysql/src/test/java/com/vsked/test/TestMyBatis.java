package com.vsked.test;


import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vsked.service.SysUserSer;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:xml/spring-mybatis.xml" })
public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	
	@Resource
	SysUserSer sysUserSer;

	@Test
	public void test(){
		String suName="admin";
		Map<String, Object> sysUser=sysUserSer.getSysUserBySuName(suName);
		
		System.out.println(sysUser);
		logger.info(sysUser);
		
		
	}
}
