package com.vsked.service.phoenix;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.test.BaseTest;


public class SysUserPhoenixServiceTest extends BaseTest{
	
	@Autowired
	SysUserPhoenixService sysUserPhoenixService;
	
//	@Test
	public void list(){
		//2
		sysUserPhoenixService.testQuery();
	}
	
	@Test
	public void testBatchInsert(){
		sysUserPhoenixService.testBatchInsert();
	}

}
