package com.vsked.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vsked.dao.TmpAgentDao;

@Service
@Transactional
public class TmpAgentService {
	
	Logger  log = Logger.getLogger(TmpAgentService.class);
	
	@Autowired
	TmpAgentDao tmpAgentDao;
	
	public void testService1(){
		try{
			tmpAgentDao.cleanAll(); //清空所有数据
			
			Set<String> myTestSet=new HashSet<String>();
			
			for(int i=0;i<10;i++){
				myTestSet.add(i+"|");
			}
			
			tmpAgentDao.batchAdd(myTestSet); //向数据库里添加数据
			
			List<Map<String, Object>> dataList=tmpAgentDao.getAll(); //获取所有数据
			for(Map<String, Object> data:dataList){
				log.debug(data);
			}
			
			throw new Exception("roll back 回滚信息"); //手工异常并测试回滚
			
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}
}
