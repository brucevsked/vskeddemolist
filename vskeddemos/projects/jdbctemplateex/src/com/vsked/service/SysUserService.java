package com.vsked.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vsked.dao.SysUserDao;

@Service
@Transactional
public class SysUserService {
	
	@Autowired
	SysUserDao sysUserDao;
	
	public String getSysUserList(){
		String result="";
		List<Map<String, Object>> userList=sysUserDao.getSysUserList();
		for(Map<String, Object> user:userList){
			result+=user.toString()+"<br>";
		}
		return result;
	}

}
