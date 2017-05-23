package com.vsked.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.vsked.test.TestMyBatis;

public class SysDictionaryTypeDaoTest extends TestMyBatis{
	
	private static Logger log = Logger.getLogger(SysDictionaryTypeDaoTest.class);
	
	@Autowired
	SysDictionaryTypeDao sysDictionaryTypeDao;
	
	
//	@Test
	public void getSysDictionaryTypeBySdtId(){
		String sdtId="sysDictionaryType000000000000001";
		Map<String, Object> data=sysDictionaryTypeDao.getSysDictionaryTypeBySdtId(sdtId);
		log.debug(data);
	}
	
//	@Test
	public void getSysDictionaryTypeCount(){
		Map<String, Object> m=new HashMap<String, Object>();
//		m.put("sdtName", "性别");
		int count=sysDictionaryTypeDao.getSysDictionaryTypeCount(m);
		log.debug(count);
	}
	
//	@Test
	public void getSysDictionaryTypeList(){
		Map<String, Object> m=new HashMap<String, Object>();
//		m.put("sdtName", "性别");
		List<Map<String, Object>> dataList=sysDictionaryTypeDao.getSysDictionaryTypeList(m);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void sysDictionaryTypeAdd(){
		Map<String, Object> m=new HashMap<String, Object>();
//		m.put("sdtName", "tmptest测试junit");
		int effectLine=sysDictionaryTypeDao.sysDictionaryTypeAdd(m);
		log.debug(effectLine);
	}
	
//	@Test
	public void sysDictionaryTypeEdit(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("sdtId", "B01D300EB18B4B56B64DC6F455E5F7B0");
		m.put("sdtName", "测试junit");
		int effectLine=sysDictionaryTypeDao.sysDictionaryTypeEdit(m);
		log.debug(effectLine);
	}

}
