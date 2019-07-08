package com.vsked.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vsked.common.StringTool;
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
	
	public String list1(HttpServletRequest req){
		String result="add is ok";
		try{
			Map<String, Object> m=getMaps(req);
			log.info("|"+m+"|");
			result=list(m);
		}catch(Exception e){
			rollBack(e, log);
			result="list exception"+e.getMessage();
		}
		log.info("|"+result+"|");
		return result;
	}
	
	public String list(Map<String, Object> data){
		String result="add is ok";
		try{
			log.info("|------------------------get user list--------------------------------|");
			 Page<?> p = getPageForApp(data);// 提取分页参数
			 PageHelper.startPage(p.getPageNum(), p.getPageSize());
			List<Map<String, Object>> dataList=webUserDao.list(data);
			result=StringTool.listToJson(dataList) ;
		}catch(Exception e){
			rollBack(e, log);
			result="list exception"+e.getMessage();
		}
		log.info("|"+result+"|");
		return result;
	}

}
