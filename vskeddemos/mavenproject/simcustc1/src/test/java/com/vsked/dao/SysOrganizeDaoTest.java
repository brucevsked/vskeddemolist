package com.vsked.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.TestMyBatis;

public class SysOrganizeDaoTest extends TestMyBatis{
	
	private static Logger log = Logger.getLogger(SysOrganizeDaoTest.class);
	
	@Autowired
	SysOrganizeDao sysOrganizeDao;
	
//	@Test
	public void getSysOrganizeCount(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("soName", "B");
		m.put("soCode", "b");
		m.put("soName1", "山东");
		int count=sysOrganizeDao.getSysOrganizeCount(m);
		log.debug(count);
	}
	
//	@Test
	public void getSysOrganizeList(){
		Map<String, Object> m=new HashMap<String, Object>();
//		m.put("soName", "B");
		m.put("soCode", "b");
//		m.put("soName1", "山东");
		List<Map<String, Object>> dataList=sysOrganizeDao.getSysOrganizeList(m);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void getSysOrganizeBySoId(){
		String soId="orga0000000000000000000000010002";
		Map<String, Object> data=sysOrganizeDao.getSysOrganizeBySoId(soId);
		log.debug(data);
	}
	
//	@Test
	public void sysOrganizeAdd(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("soName", "电商组");
		m.put("soCode", "dsz");
		m.put("soSort", "3");
		m.put("parentSoId", "orga0000000000000000000000010005");
		int effectLine=sysOrganizeDao.sysOrganizeAdd(m);
		log.debug(effectLine);
	}
	
//	@Test
	public void sysOrganizeEdit(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("soId", "01A7123FE7AC48668515568E685FC41B");
		m.put("soName", "电商组");
		m.put("soCode", "dsz");
		m.put("soSort", "3");
		m.put("parentSoId", "orga0000000000000000000000010006");
		int effectLine=sysOrganizeDao.sysOrganizeEdit(m);
		log.debug(effectLine);
	}
	
}
