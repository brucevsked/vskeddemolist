package com.vsked.service;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.vsked.common.StringTool;
import com.vsked.shiro.JwtUtil;
import com.vsked.shiro.WebApplicationUtil;
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
	 * @param m
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
	
	/**
	 * 获取分页信息手机端
	 * @param m
	 * @return
	 */
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
	 * 获取参数
	 * @param req
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
	
	/**
	 * json key 带双引号
	 * @param s
	 * @return
	 */
	public String getKey(String s){
		return "\""+s+"\"";
	}
	
	/**
	 * 获取项目真实目录
	 * @param req
	 * @return
	 */
	public static String getMyAppPath(HttpServletRequest req){
		String myPath=req.getServletContext().getRealPath("/").replace("\\", "/");
		if(log.isDebugEnabled()){
			log.debug(myPath);
		}
		return myPath;
	}
	
	/**
	 * 根据传入的路径创建目录如果存在则不创建
	 * @param destDirName 要创建的目录路径
	 * @return true创建目录成功 false 创建目录失败
	 */
    public static boolean createDir(String destDirName) {
    	
		if(log.isDebugEnabled()){
			log.debug(destDirName);
		}
		
        File dir = new File(destDirName);
        if (dir.exists()) {
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        return dir.mkdirs();
    }
    
    /**
     * 从token中获取当前登录用户uid
     * @param req
     * @return
     */
    public String getUidFromToken(HttpServletRequest req){
    	String uid=null;
		try{
			String token= WebApplicationUtil.getToken(req);
	        Map<String, Object> dataMap=tokenToMap(token);
	        uid=(String) dataMap.get("uid");
	    }catch(Exception e){
	    	log.error("get userinfo exception",e);
	    }
		return uid;
    }
    
    /**
     * token转换为map
     * {code=role_admin, roleid=101, viewvideocountsum=0, userid=1, uid=1, balance=0, consumesum=0, 
     * agentdescription=在线时间8点到9点, onlinestate=0, vipendtime=null, id=1, state=1, email=test@test.com, 
     * rechargesum=0, sex=1, isagent=1, avatar=http://suo.im/4mIdrf, realname=胜哥, phone=18888888888, 
     * addtime=1558041229000, createsource=2, followtimes=0, name=管理员角色, updatetime=1558041229000, 
     * viewvideocount=0, username=appadmin, status=1}
     * @param token
     * @return
     */
    public Map<String, Object> tokenToMap(String token){
    	Map<String, Object> dataMap=new HashMap<String, Object>();
		try{
			String dataMapStr= JwtUtil.parse(token).getSubject();
			dataMap= StringTool.jsonToMap(dataMapStr);
	    }catch(Exception e){
	    	log.info("get userinfo exception");
	    }
    	return dataMap;
    }
    
    /**
     * 异常时事务回滚处理
     */
    public void rollBack(Exception e,Logger log){
		//手工回滚事务防止出现不跳页
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		log.error(e.getMessage(),e);
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
