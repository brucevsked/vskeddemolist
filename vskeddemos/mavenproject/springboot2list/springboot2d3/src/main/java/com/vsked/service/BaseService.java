package com.vsked.service;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.github.pagehelper.Page;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class BaseService {
	
	String currentPageName="start";
	String pageSizeName="length";
	
	
	/**
	 * 获取分页信息网页端
	 * @param request
	 * @return Page
	 */
	public Page<Object> getPage(Map<String, Object> m){
		int pageNum=1;
		int pageSize=10;
		if(m.containsKey(currentPageName) && !"".equals(m.get(currentPageName))){
			pageNum=Integer.parseInt(m.get(currentPageName).toString());
		}
		if(m.containsKey(pageSizeName) && !"".equals(m.get(pageSizeName))){
			pageSize=Integer.parseInt(m.get(pageSizeName).toString());
		}
		
		pageNum=(pageNum/pageSize)+1;
		Page<Object> page=new Page<Object>(pageNum,pageSize);
		return page;
	}
	
	public Page<Object> getPageForApp(Map<String, Object> m){
		int pageNum=1;
		int pageSize=10;
		if(m.containsKey(currentPageName) && !"".equals(m.get(currentPageName))){
			pageNum=Integer.parseInt(m.get(currentPageName).toString());
		}
		if(m.containsKey(pageSizeName) && !"".equals(m.get(pageSizeName))){
			pageSize=Integer.parseInt(m.get(pageSizeName).toString());
		}
		Page<Object> page=new Page<Object>(pageNum,pageSize);
		return page;
	}
	
	/**
	 * json key 带双引号
	 * @param s
	 * @return
	 */
	public String getKey(String s){
		return "\""+s+"\"";
	}
	
	/**
	 * 获取参数
	 * @param r
	 * @return
	 */
	public Map<String,Object> getMaps(HttpServletRequest req){
		Map<String,Object> m=new HashMap<String, Object>();
		Enumeration<String> e=req.getParameterNames();
		while(e.hasMoreElements()){
			String s=(String) e.nextElement();
			m.put(s, req.getParameter(s));
		}
		return m;
	}
	
    public void rollBack(Exception e,Logger logx){
		//手工回滚事务防止出现不跳页
    	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		logx.error(e.getMessage(),e);
		e.printStackTrace();
    }
    
    /**
     * 添加,更新,删除数据失败时调用此方法回滚事务
     * @param log
     */
    public void updateFail(Logger log){
    	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    	log.info("operate fail for database please check again");
    }
    
}
