package com.vsked.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.TestMyBatis;

public class SysPermissionDaoTest extends TestMyBatis{
	
	private static Logger log = Logger.getLogger(SysPermissionDaoTest.class);
	
	@Autowired
	SysPermissionDao sysPermissionDao;
	
//	@Test
	public void getSysPermissionBySpId(){
		String spId="20000000000000000000000000000001";
		Map<String, Object> permission=sysPermissionDao.getSysPermissionBySpId(spId);
		log.debug(permission);
	}
	
//	@Test
	public void getSysPermissionCount(){
		Map<String, Object> m=new HashMap<String, Object>();
//		m.put("spNick", "用户列表");
		int permissionCount=sysPermissionDao.getSysPermissionCount(m);
		log.debug(permissionCount);
		
	}
	
//	@Test
	public void getSysPermissionList(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("spNick", "用户列表");
		List<Map<String, Object>> permissionList=sysPermissionDao.getSysPermissionList(m);
		log.debug(permissionList);
		log.debug(permissionList.size());
	}
	
//	@Test
	public void sysPermissionAdd(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("spName", "test:edit");
		m.put("spNick", "单元测试");
		int effectLine=sysPermissionDao.sysPermissionAdd(m);
		log.debug(effectLine);
		
	}
	
//	@Test
	public void sysPermissionEdit(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("spId", "79BB89A755BA4F78B3E7D4C5CC26B99E");
		m.put("spName", "test:edit1");
		m.put("spNick", "单元测试1");
		int effectLine=sysPermissionDao.sysPermissionEdit(m);
		log.debug(effectLine);
	}
	
//	@Test
	public void sysPermissionDel(){
		String spId="79BB89A755BA4F78B3E7D4C5CC26B99E";
		int effectLine=sysPermissionDao.sysPermissionDel(spId);
		log.debug(effectLine);
	}

}
