package com.vsked.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsked.dao.SysUserDao;

@Service
public class SysUserService {
	
	@Autowired
	SysUserDao sysUserDao;
	
	public String list() {
		return sysUserDao.list().toString();
	}

}
