package com.appserveruser.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appservercommon.common.StringTool;
import com.appservercommon.service.BaseService;
import com.appserveruser.mapper.SysUserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class SysUserService extends BaseService{
	
	@Autowired
	SysUserMapper sysUserMapper;
	
	public String  getUser(String suid){
		String result="";
		try{
			Map<String, Object> userMap=sysUserMapper.getBySuId(suid);
			log.info("|"+userMap+"|");
			result=StringTool.mapToJson(userMap);
		}catch(Exception e){
			log.error("get user Error",e);
		}
		return result;
	}

}
