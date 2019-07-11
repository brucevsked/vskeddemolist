package com.vsked.service;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vsked.common.StringTool;
import com.vsked.dao.WebUserDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class WebUserService extends BaseService{
	
	@Autowired
	WebUserDao webUserDao;
	
	@Autowired
    RedisTemplate<String, Object> redisTemplate;
	
	public String webUserList(HttpServletRequest req){
		String result="";
		try{
			 Map<String, Object> m = getMaps(req); // 封装前台参数为map
			 log.info("|"+m+"|");
	         Page<?> p = getPage(m);// 提取分页参数
	         int total=webUserDao.getWebUserCount(m);
	         StringBuffer sb=new StringBuffer();
	         
	         sb.append("{");
	         sb.append(""+getKey("draw")+":"+m.get("draw")+",");
	         sb.append(""+getKey("recordsTotal")+":"+total+",");
	         sb.append(""+getKey("recordsFiltered")+":"+total+",");
	         
	         PageHelper.startPage(p.getPageNum(), p.getPageSize());
	         List<Map<String, Object>> dataList = webUserDao.getWebUserList(m);
	         String dataListStr=StringTool.listToJson(dataList) ;
	         sb.append(""+getKey("data")+":"+dataListStr);
	         sb.append("}");
	         result=sb.toString();
	         log.info("|"+result+"|");
		}catch(Exception e){
			rollBack(e, log);
		}
		return result;
	}
	
}
