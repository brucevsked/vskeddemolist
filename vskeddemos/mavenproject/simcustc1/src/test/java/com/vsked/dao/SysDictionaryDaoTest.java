package com.vsked.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.TestMyBatis;

public class SysDictionaryDaoTest extends TestMyBatis{
	
	private static Logger log = Logger.getLogger(SysDictionaryDaoTest.class);
	
	@Autowired
	SysDictionaryDao sysDictionaryDao;
	
//	@Test
	public void getSysDictionaryCount(){
		Map<String, Object> m=new HashMap<String, Object>();
//		m.put("sdName", "男");
//		m.put("sdValue", "1");
//		m.put("sdtName", "性别");
		int count=sysDictionaryDao.getSysDictionaryCount(m);
		log.debug(count);
	}
	
//	@Test
	public void getSysDictionaryList(){
		Map<String, Object> m=new HashMap<String, Object>();
//		m.put("sdName", "男");
//		m.put("sdValue", "1");
//		m.put("sdtName", "性别");
		List<Map<String, Object>> dataList=sysDictionaryDao.getSysDictionaryList(m);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void getSysDictionaryBySdtId(){
		String sdtId="sysDictionaryType000000000000001";
		List<Map<String, Object>> dataList=sysDictionaryDao.getSysDictionaryBySdtId(sdtId);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
	@Test
	public void getSysDictionaryBySdId(){
		String sdId="sysDictionary0000000000000000002";
		Map<String, Object> data=sysDictionaryDao.getSysDictionaryBySdId(sdId);
		log.debug(data);
	}
	
//	@Test
	public void sysDictionaryAdd(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("sdName", "电商组");
		m.put("sdValue", "dsz");
		m.put("sdSort", "0");
		m.put("sdtId", "B01D300EB18B4B56B64DC6F455E5F7B0");
		int effectLine=sysDictionaryDao.sysDictionaryAdd(m);
		log.debug(effectLine);
	}
	
//	@Test
	public void sysDictionaryEdit(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("sdId", "6AB6878998234B19B61B52E1822133DC");
		m.put("sdName", "电商组a");
		m.put("sdValue", "dszf");
		m.put("sdSort", "2");
		m.put("sdtId", "sysDictionaryType000000000000001");
		int effectLine=sysDictionaryDao.sysDictionaryEdit(m);
		log.debug(effectLine);
	}
	
}
