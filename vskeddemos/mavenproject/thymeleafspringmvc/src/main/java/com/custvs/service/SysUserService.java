package com.custvs.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.custvs.common.StringTool;
import com.custvs.dao.SysUserDao;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
@Transactional
public class SysUserService extends BaseService{
	
	private static final Logger log=LoggerFactory.getLogger(SysUserService.class);
	
	@Autowired
	SysUserDao sysUserDao;
	
	public String sysUserList(HttpServletRequest req) throws Exception{
		String result="";
		try{
			Map<String, Object> m=getMaps(req); //封装前台参数为map
			if(log.isDebugEnabled()){
				log.debug("server path|"+getServerPath(req));
				log.debug("parMap:"+m);
			}
			result=sysUserListData(m);

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
	
	public String sysUserListData(Map<String, Object> m) throws Exception{
		String result="";
		try{
			Page<Object> p=getPage(m);
			
			long total=sysUserDao.getSysUserCount(m);
			p.setTotal(total);
			
			if(log.isDebugEnabled()){
				log.debug("page:"+p);
			}

			PageHelper.startPage(p.getPageNum(),p.getPageSize());//mybatis分页插件
			List<Map<String, Object>> dataList=sysUserDao.getSysUserList(m);
			
			String rowData=StringTool.listToJson(dataList);
			
			result="{"+getKey("total")+":"+total+","+getKey("rows")+":"+rowData+"}";
			
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
	
	public String sysUserAdd(HttpServletRequest req) throws Exception{
		String result="";
		try{
			Map<String, Object> m=getMaps(req); //封装前台参数为map
			if(log.isDebugEnabled()){
				log.debug("server path|"+getServerPath(req));
				log.debug("parMap:"+m);
			}
			result=sysUserAddExt(m);

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
	
	
	public String sysUserAddExt(Map<String, Object> m) throws Exception{
		String result="";
		try{
			String suPass=(String) m.get("suPass");
			m.remove("suPass");
			suPass=StringTool.md5(suPass).toLowerCase();
			m.put("suPass", suPass);
			int count=sysUserDao.sysUserAdd(m);
			result=count==0?"添加失败":"添加成功";
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
	
	
	public String sysUserLoginPc(HttpServletRequest req) throws Exception{
		String result="";
		try{
		Map<String, Object> userMap=getMaps(req);
		
		if(log.isDebugEnabled()){
			log.debug("|"+userMap+"|");
		}
		
		if(userMap.containsKey("suName")){
			Map<String, Object> dataMap=sysUserDao.getSysUserBySuName(userMap.get("suName").toString());
			if(dataMap==null){
				result=getJsonMessage("2", "登录失败,用户名不存在");
			}else{
				String suPass=dataMap.get("suPass").toString();
				String suPass1=StringTool.md5((String)userMap.get("suPass")).toLowerCase();
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
	
	public String tologout(HttpServletRequest req) throws Exception{
		String result="system/sysUserLogin";
		try{
			removeUserSession(req);
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
