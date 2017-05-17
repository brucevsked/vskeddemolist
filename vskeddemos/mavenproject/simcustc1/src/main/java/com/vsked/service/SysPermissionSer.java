package com.vsked.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.vsked.common.BaseJson;
import com.vsked.common.Page;
import com.vsked.dao.SysPermissionDao;

@Service
@Transactional
public class SysPermissionSer extends BaseService{
	
	private static final Logger log = Logger.getLogger(SysPermissionSer.class);
	
	@Autowired
	SysPermissionDao sysPermissionDao;
	
	public int getSysPermissionCount(Map<String, Object> m){
		int count=0;
		try{
			count=sysPermissionDao.getSysPermissionCount(m);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return count;
	}
	
	public Map<String, Object> getSysPermissionBySpId(String spId) {
		Map<String, Object> m=new HashMap<String, Object>();
		try{
			m=sysPermissionDao.getSysPermissionBySpId(spId);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return m;
	}
	
	public String sysPermissionList(HttpServletRequest req){
		StringBuilder sb=new StringBuilder();
		try{
		Map<String, Object> m=getMaps(req); //封装前台参数为map
		Page p=getPage(m);//提取分页参数
		int total=getSysPermissionCount(m);
		p.setCount(total);
		int pageNum=p.getCurrentPage();
		int pageSize=p.getPageSize();
		
		sb.append("{");
		sb.append(""+getKey("total")+":"+total+",");
		sb.append(""+getKey("rows")+":"+"");
		
		PageHelper.startPage(pageNum, pageSize);//mybatis分页插件
		List<Map<String, Object>> dataList=sysPermissionDao.getSysPermissionList(m);
		String dataListJson=BaseJson.listToJson(dataList);
		sb.append(dataListJson);
		sb.append("}");
		}catch(Exception e){
			log.error(e.getMessage());
		}
		
		return sb.toString();
	}
	
	public String sysPermissionList(){
		StringBuilder sb=new StringBuilder();
		try{
			Map<String, Object> m=new HashMap<String, Object>();
		    List<Map<String, Object>> dataList=sysPermissionDao.getSysPermissionList(m);
		    String dataListJson=BaseJson.listToJson(dataList);
		    sb.append(dataListJson);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		
		return sb.toString();
	}
	
	public String permissionAddProc(HttpServletRequest req){
		String result="";
		try{
			Map<String, Object> data=getMaps(req);
			int effectLine=sysPermissionDao.sysPermissionAdd(data);
			if(effectLine<=0){
				result="权限添加失败。";
			}else{
				result="权限:"+data.get("spName")+"添加成功.";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			result="权限添加出现异常,请联系管理员.";
		}
		return result;
	}
	
	public String permissionEditProc(HttpServletRequest req){
		String result="";
		try{
			Map<String, Object> data=getMaps(req);
			int effectLine=sysPermissionDao.sysPermissionEdit(data);
			if(effectLine<=0){
				result="权限修改失败。";
			}else{
				result="权限:"+data.get("spNick")+"修改成功.";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			result="权限修改出现异常,请联系管理员.";
		}
		return result;
	}
	
	public String permissionEditPage(HttpServletRequest req){
		String result="permissionListPage";
		try{
			Map<String, Object> parMap=getMaps(req);
			if(parMap.containsKey("spId")){
			Map<String, Object> data=sysPermissionDao.getSysPermissionBySpId((String) parMap.get("spId"));
			getSession().setAttribute("data", data);
			result="permissionEdit";
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return result;
	}
	
}
