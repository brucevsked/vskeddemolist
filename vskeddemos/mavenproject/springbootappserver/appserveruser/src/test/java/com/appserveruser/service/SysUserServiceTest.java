package com.appserveruser.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.appserveruser.BaseTest;
import com.appserveruser.service.SysUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SysUserServiceTest extends BaseTest{
	
	@Autowired
	SysUserService sysUserService;
	
	@Test
	public void testEvn(){
		String suid="10000000000000000000000000000001";
		String userMap=sysUserService.getUser(suid);
		log.debug("|"+userMap+"|");
	}
	

}
