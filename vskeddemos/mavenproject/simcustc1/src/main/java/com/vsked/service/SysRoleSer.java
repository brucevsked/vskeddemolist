package com.vsked.service;

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
import com.vsked.dao.SysRoleDao;

@Service
@Transactional
public class SysRoleSer extends BaseService{
	
	private static final  Logger log = Logger.getLogger(SysRoleSer.class);
	
	@Autowired
	SysRoleDao sysRoleDao;
	
	public int getSysRoleCount(Map<String, Object> m){
		int count=0;
		try{
			count=sysRoleDao.getSysRoleCount(m);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return count;
	}
	
	public Map<String, Object> getSysRoleBySrId(String srId){
		return sysRoleDao.getSysRoleBySrId(srId);
	}
	
	
	public String sysRoleList(HttpServletRequest req){
		StringBuilder sb=new StringBuilder();
		try{
		Map<String, Object> m=getMaps(req); //封装前台参数为map
		Page p=getPage(m);//提取分页参数
		int total=getSysRoleCount(m);
		p.setCount(total);
		int pageNum=p.getCurrentPage();
		int pageSize=p.getPageSize();
		
		sb.append("{");
		sb.append(""+getKey("total")+":"+total+",");
		sb.append(""+getKey("rows")+":"+"");
		
		PageHelper.startPage(pageNum, pageSize);//mybatis分页插件
		List<Map<String, Object>> dataList=sysRoleDao.getSysRoleList(m);
		String dataListJson=BaseJson.listToJson(dataList);
		sb.append(dataListJson);
		sb.append("}");
		}catch(Exception e){
			log.error(e.getMessage());
		}
		
		return sb.toString();
	}
	
	public String roleAddProc(HttpServletRequest req){
		String result="";
		try{
			Map<String, Object> data=getMaps(req);
			int effectLine=sysRoleDao.sysRoleAdd(data);
			if(effectLine<=0){
				result="角色添加失败。";
			}else{
				result="角色:"+data.get("srName")+"添加成功.";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			result="角色添加出现异常,请联系管理员.";
		}
		return result;
	}
	
	public String roleEditProc(HttpServletRequest req){
		String result="";
		try{
			Map<String, Object> data=getMaps(req);
			int effectLine=sysRoleDao.sysRoleEdit(data);
			if(effectLine<=0){
				result="角色修改失败。";
			}else{
				result="角色:"+data.get("srName")+"修改成功.";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			result="角色修改出现异常,请联系管理员.";
		}
		return result;
	}
	
	public String roleEditPage(HttpServletRequest req){
		String result="roleListPage";
		try{
			Map<String, Object> parMap=getMaps(req);
			if(parMap.containsKey("srId")){
			Map<String, Object> data=sysRoleDao.getSysRoleBySrId((String) parMap.get("srId"));
			getSession().setAttribute("data", data);
			result="roleEdit";
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return result;
	}
	
}
