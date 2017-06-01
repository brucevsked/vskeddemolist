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
import com.vsked.dao.SysDictionaryTypeDao;

@Service
@Transactional
public class SysDictionaryTypeSer extends BaseService{
	
	private static final  Logger log = Logger.getLogger(SysDictionaryTypeSer.class);
	
	@Autowired
	SysDictionaryTypeDao sysDictionaryTypeDao;
	
	public int getSysDictionaryTypeCount(Map<String, Object> m){
		int count=0;
		try{
			count=sysDictionaryTypeDao.getSysDictionaryTypeCount(m);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return count;
	}
	
	public Map<String, Object> getSysDictionaryTypeBySdtId(String sdtId){
		return sysDictionaryTypeDao.getSysDictionaryTypeBySdtId(sdtId);
	}
	
	
	public String sysDictionaryTypeList(HttpServletRequest req){
		StringBuilder sb=new StringBuilder();
		try{
		Map<String, Object> m=getMaps(req); //封装前台参数为map
		Page p=getPage(m);//提取分页参数
		int total=getSysDictionaryTypeCount(m);
		p.setCount(total);
		int pageNum=p.getCurrentPage();
		int pageSize=p.getPageSize();
		
		sb.append("{");
		sb.append(""+getKey("total")+":"+total+",");
		sb.append(""+getKey("rows")+":"+"");
		
		PageHelper.startPage(pageNum, pageSize);//mybatis分页插件
		List<Map<String, Object>> dataList=sysDictionaryTypeDao.getSysDictionaryTypeList(m);
		String dataListJson=BaseJson.listToJson(dataList);
		sb.append(dataListJson);
		sb.append("}");
		}catch(Exception e){
			log.error(e.getMessage());
		}
		
		return sb.toString();
	}
	
	public String sysDictionaryTypeListAll(){
		StringBuilder sb=new StringBuilder();
		try{
		Map<String, Object> m=new HashMap<String, Object>();
		List<Map<String, Object>> dataList=sysDictionaryTypeDao.getSysDictionaryTypeList(m);
		String dataListJson=BaseJson.listToJson(dataList);
		sb.append(dataListJson);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		
		return sb.toString();
	}
	
	public String dictionaryTypeAddProc(HttpServletRequest req){
		String result="";
		try{
			Map<String, Object> data=getMaps(req);
			int effectLine=sysDictionaryTypeDao.sysDictionaryTypeAdd(data);
			if(effectLine<=0){
				result="字典类型添加失败。";
			}else{
				result="字典类型:"+data.get("sdtName")+"添加成功.";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			result="字典类型添加出现异常,请联系管理员.";
		}
		return result;
	}
	
	public String dictionaryTypeEditProc(HttpServletRequest req){
		String result="";
		try{
			Map<String, Object> data=getMaps(req);
			int effectLine=sysDictionaryTypeDao.sysDictionaryTypeEdit(data);
			if(effectLine<=0){
				result="字典类型修改失败。";
			}else{
				result="字典类型:"+data.get("sdtName")+"修改成功.";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			result="字典类型修改出现异常,请联系管理员.";
		}
		return result;
	}
	
	public String dictionaryTypeEditPage(HttpServletRequest req){
		String result="dictionaryTypeListPage";
		try{
			Map<String, Object> parMap=getMaps(req);
			if(parMap.containsKey("sdtId")){
			Map<String, Object> data=sysDictionaryTypeDao.getSysDictionaryTypeBySdtId((String) parMap.get("sdtId"));
			getSession().setAttribute("data", data);
			result="dictionaryTypeEdit";
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return result;
	}
	
}
