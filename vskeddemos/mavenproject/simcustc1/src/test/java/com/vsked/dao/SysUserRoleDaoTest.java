package com.vsked.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.TestMyBatis;

public class SysUserRoleDaoTest extends TestMyBatis{
	
	private static Logger log = Logger.getLogger(SysUserRoleDaoTest.class);
	
	@Autowired
	SysUserRoleDao sysUserRoleDao;
	
//	@Test
	public void getSysUserRoleListBySuId(){
		String suId="10000000000000000000000000000001";
		List<Map<String, Object>> dataList=sysUserRoleDao.getSysUserRoleListBySuId(suId);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void getSysUserRoleListBySrId(){
		String srId="30000000000000000000000000000002";
		List<Map<String, Object>> dataList=sysUserRoleDao.getSysUserRoleListBySrId(srId);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void getHasSysUserList(){
		String srId="30000000000000000000000000000001";
		List<Map<String, Object>> dataList=sysUserRoleDao.getHasSysUserList(srId);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void getNoSysUserList(){
		String srId="30000000000000000000000000000001";
		List<Map<String, Object>> dataList=sysUserRoleDao.getNoSysUserList(srId);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void getHasSysRoleList(){
		String suId="10000000000000000000000000000001";
		List<Map<String, Object>> dataList=sysUserRoleDao.getHasSysRoleList(suId);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void getNoSysRoleList(){
		String suId="10000000000000000000000000000001";
		List<Map<String, Object>> dataList=sysUserRoleDao.getNoSysRoleList(suId);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void sysUserRoleAdd(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("suId", "54008A632D45470AAFC74D740C94DC52");
		m.put("srId", "44C3CE3C132E4B879CC989EB62ACD8FE");
		int effectLine=sysUserRoleDao.sysUserRoleAdd(m);
		log.debug(effectLine);
		
	}
	
//	@Test
	public void sysUserRoleDelBySrId(){
		String srId="44C3CE3C132E4B879CC989EB62ACD8FE";
		int effectLine=sysUserRoleDao.sysUserRoleDelBySrId(srId);
		log.debug(effectLine);
	}
	
//	@Test
	public void sysUserRoleDelBySuId(){
		String suId="54008A632D45470AAFC74D740C94DC52";
		int effectLine=sysUserRoleDao.sysUserRoleDelBySuId(suId);
		log.debug(effectLine);
	}
	

}
