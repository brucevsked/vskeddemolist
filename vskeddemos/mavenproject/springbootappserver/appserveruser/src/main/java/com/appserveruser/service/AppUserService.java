package com.appserveruser.service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appservercommon.common.StringTool;
import com.appservercommon.service.BaseService;
import com.appservercommon.token.ConstantKit;
import com.appservercommon.token.Md5TokenGenerator;
import com.appserveruser.mapper.AppUserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class AppUserService extends BaseService{
	
	@Autowired
	AppUserMapper appUserMapper;
	
	@Autowired
	Md5TokenGenerator tokenGenerator;
	
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
	
	public String login(HttpServletRequest req){
		String result="";
		Map<String, Object> userMapTmp=getMaps(req);
		log.info("|"+userMapTmp+"|");
		try{
			String userName=(String) userMapTmp.get("username");
			String userPass=(String) userMapTmp.get("userpass");
			if(userName==null){
				result=getJsonMessage("100001", "缺少参数用户名");
		    }else{
		    	if(userPass==null){
		    		result=getJsonMessage("100002", "缺少参数用户密码");
		    	}else{
		    		Map<String, Object> userMap=appUserMapper.getAppUserByUserName(userName);
		    		if(userMap==null){
		    			result=getJsonMessage("100003", "用户名不存在");
		    		}else{
		    			userPass=StringTool.md5(userPass);
		    			userPass=userPass.toLowerCase();//转小写
		    			String dbPass=(String) userMap.get("userpass");
		    			dbPass=dbPass.toLowerCase();
		    			if(!dbPass.equals(userPass)){
		    				result=getJsonMessage("100004", "密码错误");
		    			}else{
		    				//登录成功处理
		    				String token=tokenGenerator.generate(userName,dbPass);
		    				redisTemplate.opsForValue().set(userName, token);
		    				redisTemplate.expire(userName, ConstantKit.TOKEN_EXPIRE_TIME, TimeUnit.SECONDS);//设置过期时间
		    				redisTemplate.opsForValue().set(token, userName);
		    				redisTemplate.expire(token, ConstantKit.TOKEN_EXPIRE_TIME, TimeUnit.SECONDS);//设置过期时间
		    				result=getJsonMessage("000000", token);//登录成功
		    			}
		    		}
		    	}
			
		    }
		}catch(Exception e){
			log.error("app user login exception",e);
			result="{\"code\":\"900001\",\"msg\":\"登录异常请联系管理员"+e.getMessage()+"\"}";
		}
		
		return result;
	}
	
	

}
