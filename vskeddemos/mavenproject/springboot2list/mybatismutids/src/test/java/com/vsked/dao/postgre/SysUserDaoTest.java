package com.vsked.dao.postgre;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.BaseTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SysUserDaoTest extends BaseTest{
	
	@Autowired
	SysUserDao sysUserDao;
	
	@Test
	public void list(){
		List<Map<String, Object>> dataList=sysUserDao.list();
		log.debug("|"+dataList+"|");
		
	}

}
