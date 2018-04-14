package com.custvs.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.custvs.dao.SysUserDao;

@Service
@Transactional
public class SysUserService extends BaseService{
	
	private static final Logger log=LoggerFactory.getLogger(SysUserService.class);
	
	@Autowired
	SysUserDao sysUserDao;
	
	public String sysUserLoginPc(HttpServletRequest req) throws Exception{
		String result="";
		try{
		Map<String, Object> userMap=getMaps(req);
		
		if(userMap.containsKey("suName")){
			Map<String, Object> dataMap=sysUserDao.getSysUserBySuName(userMap.get("suName").toString());
			if(dataMap==null){
				result=getJsonMessage("2", "登录失败,用户名不存在");
			}else{
				String suPass=dataMap.get("suPass").toString();
				String suPass1=userMap.get("suPass").toString();
				if(!suPass.equals(suPass1)){
					result=getJsonMessage("3", "登录失败,密码验证未通过");
				}else{
					result=getJsonMessage("0", "登录成功");
					setUserSession(req, dataMap);
				}
				
			}
		}else{
			result=getJsonMessage("1", "参数错误,未传入用户名");
		}
		
		}catch(Exception e){
    		e.printStackTrace();
    		log.error(e.getMessage());
    		throw e;
		}
		
		if(log.isDebugEnabled()){
			log.debug(result);
		}
		
		return result;
	}
	
}
