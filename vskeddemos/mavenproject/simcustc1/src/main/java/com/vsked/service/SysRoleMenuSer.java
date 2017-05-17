package com.vsked.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.vsked.common.BaseJson;
import com.vsked.dao.SysMenuDao;
import com.vsked.dao.SysRoleMenuDao;

@Service
@Transactional
public class SysRoleMenuSer extends BaseService {
	
	private static final Logger log = Logger.getLogger(SysRoleMenuSer.class);
	
	@Autowired
	SysRoleMenuDao sysRoleMenuDao;
	
	@Autowired
	SysMenuDao sysMenuDao; 
	
	public String roleMenuListPage(HttpServletRequest req){
		String resultPage="roleMenuList";
		try{
			Map<String, Object> parMap=getMaps(req);
			if(parMap.containsKey("smId")){
				Map<String, Object> data=sysMenuDao.getSysMenuBySmId((String) parMap.get("smId"));
				getSession().setAttribute("data", data);
				
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return resultPage;
	}
	
	public String hasSysRoleList(HttpServletRequest req){
		StringBuilder sb=new StringBuilder();
		try{
			Map<String, Object> parMap=getMaps(req);
			if(parMap.containsKey("smId")){
				List<Map<String, Object>> dataList=sysRoleMenuDao.getHasSysRoleList((String) parMap.get("smId"));
				String dataListJson=BaseJson.listToJson(dataList);
				sb.append(dataListJson);
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return sb.toString();
	}
	
	public String noSysRoleList(HttpServletRequest req){
		StringBuilder sb=new StringBuilder();
		try{
			Map<String, Object> parMap=getMaps(req);
			if(parMap.containsKey("smId")){
				List<Map<String, Object>> dataList=sysRoleMenuDao.getNoSysRoleList((String) parMap.get("smId"));
				String dataListJson=BaseJson.listToJson(dataList);
				sb.append(dataListJson);
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return sb.toString();
	}
	
	public String roleMenuProc(HttpServletRequest req){
		String result="";
		int resultCount=0;
		try{
			Map<String, Object> parMap=getMaps(req);
			if(parMap.containsKey("smId")){
				String smId=(String) parMap.get("smId");
				sysRoleMenuDao.sysRoleMenuDelBySmId(smId); //clean suData
			    if(parMap.containsKey("srIds")){
			    	String srIds=(String) parMap.get("srIds");
			    	String[] srIdArray=srIds.split(",");
			    	for(String srId:srIdArray){
			    		if(!"".equals(srId)){
			    		Map<String, Object> m=new HashMap<String, Object>();
			    		m.put("smId", smId);
			    		m.put("srId", srId);
			    		int effectLine=sysRoleMenuDao.sysRoleMenuAdd(m);
			    		resultCount+=effectLine;
			    		}
			    	}
			    }
			    result="总计绑定角色"+resultCount+"个";
			}else{
				result="参数不完整请联系管理员.";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			result="角色绑定出现异常,请联系管理员.";
			//手动回滚事务
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	

}
