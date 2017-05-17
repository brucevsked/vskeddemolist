package com.vsked.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.vsked.common.BaseJson;
import com.vsked.dao.SysPermissionDao;
import com.vsked.dao.SysRolePermissionDao;

@Service
@Transactional
public class SysRolePermissionSer extends BaseService {
	
	private static final Logger log = Logger.getLogger(SysRolePermissionSer.class);

	@Autowired
	SysRolePermissionDao sysRolePermissionDao;
	
	@Autowired
	SysPermissionDao sysPermissionDao;
	
	public List<Map<String, Object>> getSysRolePermissionBySrId(String srId) {
		List<Map<String, Object>> dataList=new LinkedList<Map<String,Object>>();
		try{
			dataList=sysRolePermissionDao.getSysRolePermissionBySrId(srId);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return dataList;
	}
	
	public String rolePermissionListPage(HttpServletRequest req){
		String resultPage="rolePermissionList";
		try{
			Map<String, Object> parMap=getMaps(req);
			if(parMap.containsKey("spId")){
				Map<String, Object> data=sysPermissionDao.getSysPermissionBySpId((String) parMap.get("spId"));
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
			if(parMap.containsKey("spId")){
				List<Map<String, Object>> dataList=sysRolePermissionDao.getHasSysRoleList((String) parMap.get("spId"));
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
			if(parMap.containsKey("spId")){
				List<Map<String, Object>> dataList=sysRolePermissionDao.getNoSysRoleList((String) parMap.get("spId"));
				String dataListJson=BaseJson.listToJson(dataList);
				sb.append(dataListJson);
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return sb.toString();
	}
	
	public String rolePermissionProc(HttpServletRequest req){
		String result="";
		int resultCount=0;
		try{
			Map<String, Object> parMap=getMaps(req);
			if(parMap.containsKey("spId")){
				String spId=(String) parMap.get("spId");
				sysRolePermissionDao.sysRolePermissionDelBySpId(spId); //clean suData
			    if(parMap.containsKey("srIds")){
			    	String srIds=(String) parMap.get("srIds");
			    	String[] srIdArray=srIds.split(",");
			    	for(String srId:srIdArray){
			    		if(!"".equals(srId)){
			    		Map<String, Object> m=new HashMap<String, Object>();
			    		m.put("spId", spId);
			    		m.put("srId", srId);
			    		int effectLine=sysRolePermissionDao.sysRolePermissionAdd(m);
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
