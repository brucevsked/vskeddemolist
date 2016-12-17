package com.vsked.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vsked.dao.UserDao;

@Service
@Transactional
public class UserSer {
	
	@Autowired
	UserDao userDao;
	
	public Map<String, Object> getSysUserBySuId(String suId){
		Map<String, Object> userData=null;
		try{
			userData=userDao.getSysUserBySuId(suId);
			System.out.println(userData);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return userData;
	}

}
