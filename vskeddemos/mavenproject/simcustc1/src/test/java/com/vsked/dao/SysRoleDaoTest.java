package com.vsked.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.TestMyBatis;

public class SysRoleDaoTest extends TestMyBatis{
	
	private static Logger log = Logger.getLogger(SysRoleDaoTest.class);
	
	@Autowired
	SysRoleDao sysRoleDao;
	
//	@Test
	public void getSysRoleBySrId(){
		String srId="241490E510AB49198A944017DABAD831";
		Map<String, Object> role=sysRoleDao.getSysRoleBySrId(srId);
		log.debug(role);
	}
	
//	@Test
	public void getSysRoleCount(){
		Map<String, Object> m=new HashMap<String, Object>();
//		m.put("srName", "超级管理员");
		int roleCount=sysRoleDao.getSysRoleCount(m);
		log.debug(roleCount);
	}
	
//	@Test
	public void getSysRoleList(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("srName", "超级管理员");
		List<Map<String, Object>> roleList=sysRoleDao.getSysRoleList(m);
		log.debug(roleList);
		log.debug(roleList.size());
	}
	
//	@Test
	public void sysRoleAdd(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("srName", "tmptestrole测试junit角色");
		int effectLine=sysRoleDao.sysRoleAdd(m);
		log.debug(effectLine);
	}
	
//	@Test
	public void sysRoleEdit(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("srId", "241490E510AB49198A944017DABAD831");
		m.put("srName", "测试junit角色");
		int effectLine=sysRoleDao.sysRoleEdit(m);
		log.debug(effectLine);
	}
	
//	@Test
	public void sysRoleDel(){
		String srId="241490E510AB49198A944017DABAD831";
		int effectLine=sysRoleDao.sysRoleDel(srId);
		log.debug(effectLine);
	}

	
}
