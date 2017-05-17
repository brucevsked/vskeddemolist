package com.vsked.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.TestMyBatis;

public class SysRoleMenuDaoTest extends TestMyBatis{
	
	private static Logger log = Logger.getLogger(SysRoleMenuDaoTest.class);
	
	@Autowired
	SysRoleMenuDao sysRoleMenuDao;
	
//	@Test
	public void getHasSysRoleList(){
		String smId="1";
		List<Map<String, Object>> dataList=sysRoleMenuDao.getHasSysRoleList(smId);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void getNoSysRoleList(){
		String smId="1";
		List<Map<String, Object>> dataList=sysRoleMenuDao.getNoSysRoleList(smId);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void sysRoleMenuAdd(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("srId", "30000000000000000000000000000002");
		m.put("smId", "DB5B0B8AA0DD408BB70E7C6DB15B5F30");
		int effectLine=sysRoleMenuDao.sysRoleMenuAdd(m);
		log.debug(effectLine);
	}
	
//	@Test
	public void sysRoleMenuDelBySrId(){
		String srId="30000000000000000000000000000002";
		int effectLine=sysRoleMenuDao.sysRoleMenuDelBySrId(srId);
		log.debug(effectLine);
	}

//	@Test
	public void sysRoleMenuDelBySmId(){
		String smId="DB5B0B8AA0DD408BB70E7C6DB15B5F30";
		int effectLine=sysRoleMenuDao.sysRoleMenuDelBySmId(smId);
		log.debug(effectLine);
	}

}
