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
import com.vsked.dao.SysOrganizeDao;

@Service
@Transactional
public class SysOrganizeSer extends BaseService {
	
	private static final Logger log = Logger.getLogger(SysOrganizeSer.class);
	
	@Autowired
	SysOrganizeDao sysOrganizeDao;
	
	public int getSysOrganizeCount(Map<String, Object> m) {
		int count = 0;
		try {
			count = sysOrganizeDao.getSysOrganizeCount(m);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return count;
	}
	
	public String sysOrganizeList(HttpServletRequest req){
		StringBuilder sb=new StringBuilder();
		try{
		Map<String, Object> m=getMaps(req); //封装前台参数为map
		Page p=getPage(m);//提取分页参数
		int total=getSysOrganizeCount(m);
		p.setCount(total);
		int pageNum=p.getCurrentPage();
		int pageSize=p.getPageSize();
		
		sb.append("{");
		sb.append(""+getKey("total")+":"+total+",");
		sb.append(""+getKey("rows")+":"+"");
		
		PageHelper.startPage(pageNum, pageSize);//mybatis分页插件
		List<Map<String, Object>> dataList=sysOrganizeDao.getSysOrganizeList(m);
		String dataListJson=BaseJson.listToJson(dataList);
		sb.append(dataListJson);
		sb.append("}");
		}catch(Exception e){
			log.error(e.getMessage());
		}
		
		return sb.toString();
	}
	
	public String sysOrganizeListAll(){
		StringBuilder sb=new StringBuilder();
		try{
		List<Map<String, Object>> dataList=sysOrganizeDao.getSysOrganizeListAll();
		String dataListJson=BaseJson.listToJson(dataList);
		sb.append(dataListJson);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		
		return sb.toString();
	}
	
	public String organizeAddProc(HttpServletRequest req){
		String result="";
		try{
			Map<String, Object> data=getMaps(req);
			int effectLine=sysOrganizeDao.sysOrganizeAdd(data);
			if(effectLine<=0){
				result="组织添加失败。";
			}else{
				result="组织:"+data.get("soName")+"添加成功.";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			result="组织添加出现异常,请联系管理员.";
		}
		return result;
	}
	
	public String organizeEditProc(HttpServletRequest req){
		String result="";
		try{
			Map<String, Object> data=getMaps(req);
			int effectLine=sysOrganizeDao.sysOrganizeEdit(data);
			if(effectLine<=0){
				result="组织修改失败。";
			}else{
				result="组织:"+data.get("soName")+"修改成功.";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			result="组织修改出现异常,请联系管理员.";
		}
		return result;
	}
	
	public String organizeEditPage(HttpServletRequest req){
		String result="organizeListPage";
		try{
			Map<String, Object> parMap=getMaps(req);
			if(parMap.containsKey("soId")){
			Map<String, Object> data=sysOrganizeDao.getSysOrganizeBySoId((String) parMap.get("soId"));
			getSession().setAttribute("data", data);
			result="organizeEdit";
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return result;
	}

}
