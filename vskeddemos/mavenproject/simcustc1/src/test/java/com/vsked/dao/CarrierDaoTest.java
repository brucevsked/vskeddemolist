package com.vsked.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.vsked.test.TestMyBatis;

public class CarrierDaoTest extends TestMyBatis{
	
	private static Logger log = Logger.getLogger(CarrierDaoTest.class);
	
	@Autowired
	CarrierDao carrierDao;
	
//	@Test
	public void getSysCarrierCount(){
		Map<String, Object> m=new HashMap<String, Object>();
//		m.put("carrierName", "通信");
//		m.put("carrierNick", "远特");
//		m.put("carrierShortName", "远特");
		int count=carrierDao.getCarrierCount(m);
		log.debug(count);
	}
	
//	@Test
	public void getSysCarrierList(){
		Map<String, Object> m=new HashMap<String, Object>();
//		m.put("carrierName", "通信");
//		m.put("carrierNick", "远特");
//		m.put("carrierShortName", "远特");
		List<Map<String, Object>> dataList=carrierDao.getCarrierList(m);
		log.debug(dataList);
		log.debug(dataList.size());
	}
	
//	@Test
	public void getCarrierByCarrierId(){
		String carrierId="carrier0000000000000000000000001";
		Map<String, Object> data=carrierDao.getCarrierByCarrierId(carrierId);
		log.debug(data);
	}
	
//	@Test
	public void carrierAdd(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("carrierName", "联想通信");
		m.put("carrierNick", "懂的通信");
		m.put("carrierShortName", "联想");
		m.put("officialWebSite", "http://10041.lenovo.com/MVNO-OBH/charge/toChargeIntro");
		m.put("hotline", "400-641-0041");
		int effectLine=carrierDao.carrierAdd(m);
		log.debug(effectLine);
	}
	
//	@Test
	public void carrierEdit(){
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("carrierId", "44E11BFDCB414153A2E7A616402A7B11");
		m.put("carrierName", "联想通信");
		m.put("carrierNick", "懂的通信");
		m.put("carrierShortName", "联想");
		m.put("officialWebSite", "http://10041.lenovo.com/MVNO-OBH/charge/toChargeIntro");
		m.put("hotline", "400-641-0041");
		int effectLine=carrierDao.carrierEdit(m);
		log.debug(effectLine);
	}

}
