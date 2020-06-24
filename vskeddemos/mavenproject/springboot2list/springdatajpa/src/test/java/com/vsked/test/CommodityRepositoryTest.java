package com.vsked.test;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.entity.Commodity;
import com.vsked.repository.CommodityRepository;

public class CommodityRepositoryTest extends BaseTest{
	
	private static final Logger log = LoggerFactory.getLogger(CommodityRepositoryTest.class);
	
	@Autowired
	CommodityRepository CommodityRepository;
	
	@Test
	public void test1() {
		Commodity commodity=new Commodity(1, "apple", new BigDecimal(15.52));
		CommodityRepository.save(commodity);
		log.debug("save ok");
		
	}
	
//	@Test
	public void test2() {
		Integer myid=new Integer(1);
		Commodity myCommodity=CommodityRepository.findById(myid).get();
		log.debug("query ok"+myCommodity);
	}
	
}
