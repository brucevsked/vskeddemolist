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
import com.vsked.dao.SysDictionaryDao;

@Service
@Transactional
public class SysDictionarySer extends BaseService {
	
	private static final Logger log = Logger.getLogger(SysDictionarySer.class);
	
	@Autowired
	SysDictionaryDao sysDictionaryDao;
	
	public int getSysDictionaryCount(Map<String, Object> m) {
		int count = 0;
		try {
			count = sysDictionaryDao.getSysDictionaryCount(m);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return count;
	}
	
	public String sysDictionaryList(HttpServletRequest req){
		StringBuilder sb=new StringBuilder();
		try{
		Map<String, Object> m=getMaps(req); //封装前台参数为map
		Page p=getPage(m);//提取分页参数
		int total=getSysDictionaryCount(m);
		p.setCount(total);
		int pageNum=p.getCurrentPage();
		int pageSize=p.getPageSize();
		
		sb.append("{");
		sb.append(""+getKey("total")+":"+total+",");
		sb.append(""+getKey("rows")+":"+"");
		
		PageHelper.startPage(pageNum, pageSize);//mybatis分页插件
		List<Map<String, Object>> dataList=sysDictionaryDao.getSysDictionaryList(m);
		String dataListJson=BaseJson.listToJson(dataList);
		sb.append(dataListJson);
		sb.append("}");
		}catch(Exception e){
			log.error(e.getMessage());
		}
		
		return sb.toString();
	}
	
	public String dictionaryAddProc(HttpServletRequest req){
		String result="";
		try{
			Map<String, Object> data=getMaps(req);
			int effectLine=sysDictionaryDao.sysDictionaryAdd(data);
			if(effectLine<=0){
				result="字典添加失败。";
			}else{
				result="字典:"+data.get("sdName")+"添加成功.";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			result="字典添加出现异常,请联系管理员.";
		}
		return result;
	}
	
	public String dictionaryEditProc(HttpServletRequest req){
		String result="";
		try{
			Map<String, Object> data=getMaps(req);
			int effectLine=sysDictionaryDao.sysDictionaryEdit(data);
			if(effectLine<=0){
				result="字典修改失败。";
			}else{
				result="字典:"+data.get("sdName")+"修改成功.";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			result="字典修改出现异常,请联系管理员.";
		}
		return result;
	}
	
	public String dictionaryEditPage(HttpServletRequest req){
		String result="dictionaryListPage";
		try{
			Map<String, Object> parMap=getMaps(req);
			if(parMap.containsKey("sdId")){
			Map<String, Object> data=sysDictionaryDao.getSysDictionaryBySdId((String) parMap.get("sdId"));
			getSession().setAttribute("data", data);
			result="dictionaryEdit";
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return result;
	}

}
