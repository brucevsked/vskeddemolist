package com.vsked.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.entity.Menu;
import com.vsked.repository.MenuRepository;

public class MenuRepositoryTest extends BaseTest{
	
	private static final Logger log = LoggerFactory.getLogger(MenuRepositoryTest.class);
	
	@Autowired
	MenuRepository menuRepository;
	
	@Test
	public void save1() {
		log.info("start save");		
		Menu menuLevel1=new Menu(1,"china","my href1china");		
		menuRepository.save(menuLevel1);		
		log.info("save ok");		
	}
	
	@Test
	public void save2() {
		log.info("start save");
		
		Menu menuLevel1=new Menu(1,"china","my href1china");
		menuRepository.save(menuLevel1);
		
		Menu menuLevel2=new Menu(201,"shandong","my href1 shandong",1);
		menuRepository.save(menuLevel2);
		
		Menu menuLevel3_1=new Menu(3001,"jinan","my href jinan",201);
		menuRepository.save(menuLevel3_1);
		
		Menu menuLevel3_2=new Menu(3002,"zibo","my href zibo",201);
		menuRepository.save(menuLevel3_2);
		
		log.info("save ok");
		
	}
	
	@Test
	public void find1() {
		log.info("start find");
		Menu menuLevel1=menuRepository.findById(1).get();
		log.debug(menuLevel1.toString());
	}
	
	@Test
	public void find2() {
		log.info("start find");
		Menu menuLevel1=menuRepository.findById(3001).get();
		log.debug(menuLevel1.toString());
	}

}
