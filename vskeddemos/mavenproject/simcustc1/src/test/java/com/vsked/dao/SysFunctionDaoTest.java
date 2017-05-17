package com.vsked.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.TestMyBatis;

public class SysFunctionDaoTest extends TestMyBatis{
	
	private static Logger log = Logger.getLogger(SysFunctionDaoTest.class);
	
	@Autowired
	SysFunctionDao sysFunctionDao;

//	@Test
	public void getSysFunction(){
		Map<String, Object> m=new HashMap<String, Object>();
//		m.put("sfId", "40000000000000000000000000000001");
//		m.put("sfValue", "/LoginController/login.html");
		List<Map<String, Object>> functionList=sysFunctionDao.getSysFunctionList(m);
		log.debug(functionList);
		log.debug(functionList.size());
	}
	
//	@Test
	public void getSysFunctionCount(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("sfId", "40000000000000000000000000000001");
		m.put("sfValue", "/LoginController/login.html");
		int functionCount=sysFunctionDao.getSysFunctionCount(m);
		log.debug(functionCount);
	}
	
//	@Test
	public void getSysFunctionBySfId(){
		String sfId="40000000000000000000000000000002";
		Map<String, Object> functionData=sysFunctionDao.getSysFunctionBySfId(sfId);
		log.debug(functionData);
	}
	
//	@Test
	public void sysFunctionAdd(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("sfValue", "/junit.html");
		m.put("spId", "20000000000000000000000000000001");
		m.put("srId", "30000000000000000000000000000001");
		m.put("sfType", "anon");
		int effectLine=sysFunctionDao.sysFunctionAdd(m);
		log.debug(effectLine);
		
	}
	
//	@Test
	public void sysFunctionEdit(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("sfId", "A89B644D9D7E4C86A8DC3BB480F3AA6D");
		m.put("sfValue", "/junitfixed.html");
		m.put("spId", "20000000000000000000000000000002");
		m.put("srId", "30000000000000000000000000000002");
		m.put("sfType", "roles");
		int effectLine=sysFunctionDao.sysFunctionEdit(m);
		log.debug(effectLine);
	}
	
//	@Test
	public void sysFunctionDel(){
		String sfId="A89B644D9D7E4C86A8DC3BB480F3AA6D";
		int effectLine=sysFunctionDao.sysFunctionDel(sfId);
		log.debug(effectLine);
	}
	
	
}
