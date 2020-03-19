package com.vsked.dao.phoenix;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.BaseTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SysUser1DaoTest extends BaseTest{
	
	@Autowired
	SysUser1Dao sysUser1Dao;
	
	@Test
	public void list(){
		//2
		List<Map<String, Object>> dataList=sysUser1Dao.list();
		log.debug("|"+dataList+"|");
	}

}
