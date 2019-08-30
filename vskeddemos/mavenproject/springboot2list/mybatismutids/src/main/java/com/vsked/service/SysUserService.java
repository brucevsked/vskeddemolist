package com.vsked.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsked.dao.phoenix.SysUser1Dao;
import com.vsked.dao.postgre.SysUserDao;

@Service
public class SysUserService {
	
	@Autowired
	SysUserDao sysUserDaoPostgre;
	@Autowired
	SysUser1Dao sysUserDaoPhoenix;
	
	public String list(){
		String result="";
		result+=sysUserDaoPostgre.list()+"";
		result+=sysUserDaoPhoenix.list()+"";
		return result;
	}

}
