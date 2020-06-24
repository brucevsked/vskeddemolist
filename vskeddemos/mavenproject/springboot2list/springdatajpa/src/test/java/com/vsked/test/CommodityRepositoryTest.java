package com.vsked.test;

import java.math.BigDecimal;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.entity.Commodity;
import com.vsked.repository.CommodityRepository;

public class CommodityRepositoryTest extends BaseTest{
	
	private static final Logger log = LoggerFactory.getLogger(CommodityRepositoryTest.class);
	
	@Autowired
	CommodityRepository commodityRepository;
	
	@Test
	public void test1() {
		Commodity commodity=new Commodity(1, "apple", new BigDecimal(15.52));
		commodityRepository.save(commodity);
		log.debug("save ok");
		
	}
	
	@Test
	public void test2() {
		Commodity myCommodity=commodityRepository.findById(1).get();
		log.debug("query ok"+myCommodity);
	}
	
}
