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
import com.vsked.dao.CarrierDao;

@Service
@Transactional
public class CarrierSer extends BaseService {
	
	private static final Logger log = Logger.getLogger(CarrierSer.class);
	
	@Autowired
	CarrierDao carrierDao;
	
	public int getCarrierCount(Map<String, Object> m) {
		int count = 0;
		try {
			count = carrierDao.getCarrierCount(m);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return count;
	}
	
	public String carrierList(HttpServletRequest req){
		StringBuilder sb=new StringBuilder();
		try{
		Map<String, Object> m=getMaps(req); //封装前台参数为map
		Page p=getPage(m);//提取分页参数
		int total=getCarrierCount(m);
		p.setCount(total);
		int pageNum=p.getCurrentPage();
		int pageSize=p.getPageSize();
		
		sb.append("{");
		sb.append(""+getKey("total")+":"+total+",");
		sb.append(""+getKey("rows")+":"+"");
		
		PageHelper.startPage(pageNum, pageSize);//mybatis分页插件
		List<Map<String, Object>> dataList=carrierDao.getCarrierList(m);
		String dataListJson=BaseJson.listToJson(dataList);
		sb.append(dataListJson);
		sb.append("}");
		}catch(Exception e){
			log.error(e.getMessage());
		}
		
		return sb.toString();
	}
	
	public String carrierAddProc(HttpServletRequest req){
		String result="";
		try{
			Map<String, Object> data=getMaps(req);
			int effectLine=carrierDao.carrierAdd(data);
			if(effectLine<=0){
				result="运营商添加失败。";
			}else{
				result="运营商:"+data.get("carrierName")+"添加成功.";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			result="运营商添加出现异常,请联系管理员.";
		}
		return result;
	}
	
	public String carrierEditProc(HttpServletRequest req){
		String result="";
		try{
			Map<String, Object> data=getMaps(req);
			int effectLine=carrierDao.carrierEdit(data);
			if(effectLine<=0){
				result="运营商修改失败。";
			}else{
				result="运营商:"+data.get("carrierName")+"修改成功.";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			result="运营商修改出现异常,请联系管理员.";
		}
		return result;
	}
	
	public String carrierEditPage(HttpServletRequest req){
		String result="carrierListPage";
		try{
			Map<String, Object> parMap=getMaps(req);
			if(parMap.containsKey("carrierId")){
			Map<String, Object> data=carrierDao.getCarrierByCarrierId((String) parMap.get("carrierId"));
			getSession().setAttribute("data", data);
			result="carrierEdit";
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return result;
	}
}
