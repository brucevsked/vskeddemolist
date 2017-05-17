package com.vsked.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.TestMyBatis;

public class SysRolePermissionDaoTest extends TestMyBatis{
	
	private static Logger log = Logger.getLogger(SysRolePermissionDaoTest.class);
	
	@Autowired
	SysRolePermissionDao sysRolePermissionDao;
	
//	@Test
	public void getSysRolePermissionBySrId(){
		String srId="30000000000000000000000000000001";
		List<Map<String, Object>> dataList=sysRolePermissionDao.getSysRolePermissionBySrId(srId);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void getHasSysPermissionList(){
		String srId="30000000000000000000000000000001";
		List<Map<String, Object>> dataList=sysRolePermissionDao.getHasSysPermissionList(srId);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void getNoSysPermissionList(){
		String srId="30000000000000000000000000000001";
		List<Map<String, Object>> dataList=sysRolePermissionDao.getNoSysPermissionList(srId);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void getHasSysRoleList(){
		String spId="20000000000000000000000000000001";
		List<Map<String, Object>> dataList=sysRolePermissionDao.getHasSysRoleList(spId);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void getNoSysRoleList(){
		String spId="20000000000000000000000000000001";
		List<Map<String, Object>> dataList=sysRolePermissionDao.getNoSysRoleList(spId);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void sysRolePermissionAdd(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("srId", "44C3CE3C132E4B879CC989EB62ACD8FE");
		m.put("spId", "7EA13C785165492EAA34CA21681E083F");
		int effectLine=sysRolePermissionDao.sysRolePermissionAdd(m);
		log.debug(effectLine);
		
	}
	
//	@Test
	public void sysRolePermissionDelBySrId(){
		String srId="44C3CE3C132E4B879CC989EB62ACD8FE";
		int effectLine=sysRolePermissionDao.sysRolePermissionDelBySrId(srId);
		log.debug(effectLine);
	}
	


}
