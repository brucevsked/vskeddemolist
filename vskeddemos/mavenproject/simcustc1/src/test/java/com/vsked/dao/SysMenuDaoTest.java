package com.vsked.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.TestMyBatis;

public class SysMenuDaoTest extends TestMyBatis{
	
	private static Logger log = Logger.getLogger(SysMenuDaoTest.class);
	
	@Autowired
	SysMenuDao sysMenuDao;
	
//	@Test
	public void getSysMenuCount(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("smName", "");
		m.put("smHref", "");
		m.put("smClick", "");
		m.put("smName1", "");
		int count=sysMenuDao.getSysMenuCount(m);
		log.debug(count);
	}
	
//	@Test
	public void getSysMenuList(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("smName", "");
		m.put("smHref", "");
		m.put("smClick", "");
		m.put("smName1", "");
		List<Map<String, Object>> dataList=sysMenuDao.getSysMenuList(m);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void getSysMenuBySmId(){
		String smId="DB5B0B8AA0DD408BB70E7C6DB15B5F30";
		Map<String, Object> data=sysMenuDao.getSysMenuBySmId(smId);
		log.debug(data);
	}
	
//	@Test
	public void getSysUserMenuBySuId(){
		String suId="10000000000000000000000000000001";
		List<Map<String, Object>> dataList=sysMenuDao.getSysUserMenuBySuId(suId);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void sysMenuAdd(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("smName", "testmenu");
		m.put("smHref", "");
		m.put("smClick", "");
		m.put("smClass", "");
		m.put("smDataOptions", "");
		m.put("parentSmId", "");
		int effectLine=sysMenuDao.sysMenuAdd(m);
		log.debug(effectLine);
	}
	
//	@Test
	public void sysMenuEdit(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("smId", "DB5B0B8AA0DD408BB70E7C6DB15B5F30");
		m.put("smName", "testmenuedit");
		m.put("smHref", "");
		m.put("smClick", "");
		m.put("smClass", "");
		m.put("smDataOptions", "");
		m.put("parentSmId", "");
		int effectLine=sysMenuDao.sysMenuEdit(m);
		log.debug(effectLine);
	}

}
