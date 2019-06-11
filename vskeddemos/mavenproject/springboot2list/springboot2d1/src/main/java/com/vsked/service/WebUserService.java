package com.vsked.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vsked.dao.WebUserDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class WebUserService extends BaseService{
	
	@Autowired
	WebUserDao webUserDao;
	
	public String add1(HttpServletRequest req){
		Map<String, Object> data=new HashMap<String, Object>();
		data.put("uid", "testaa1902");
		data.put("username", "testvsked902");
		data.put("userpass", "902");
		data.put("phone", "902");
		return add(data);
	}
	
	public String add(Map<String, Object> data){
		String result="add is ok";
		try{
			int rows=webUserDao.add(data);
			log.info("|"+rows+"|");
//			int a=0/0;
//			log.info("f2|"+a+"|");
		}catch(Exception e){
			rollBack(e, log);
			result="add exception"+e.getMessage();
		}
		log.info("|"+result+"|");
		return result;
	}

}
