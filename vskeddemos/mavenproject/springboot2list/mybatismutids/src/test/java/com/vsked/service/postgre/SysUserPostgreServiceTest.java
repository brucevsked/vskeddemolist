package com.vsked.service.postgre;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.BaseTest;


public class SysUserPostgreServiceTest extends BaseTest{
	
	@Autowired
	SysUserPostgreService sysUserPostgreService;
	
	@Test
	public void list(){
		//1
		sysUserPostgreService.testQuery();
	}

}
