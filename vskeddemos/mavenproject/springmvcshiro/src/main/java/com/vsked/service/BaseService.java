package com.vsked.service;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vsked.dao.SysUserDao;

@Service
@Transactional
public class BaseService {
	
	public Logger log = Logger.getLogger(this.getClass());
	
	String currentPageName="page";
	String pageSizeName="rows";
	@Autowired
	private SysUserDao sysUserDao;
	
	
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
	
	/**
	 * json key 带双引号
	 * @param s
	 * @return
	 */
	public String getKey(String s){
		return "\""+s+"\"";
	}
	
	/**
	 * 获取session
	 * @return
	 */
	public Session getSession(){
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		return session;
	}
	
	/**
	 * 获取当胶用户信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getUser(){
		Subject currentUser = SecurityUtils.getSubject();
		return (Map<String, Object>) currentUser.getPrincipal();
	}
	

	/**
	 * @功能描述：改变map中key的值并返回("true"、"false"、"0"、"1"相互转换)<br/>
	 * 			1.字符串"true"转换成字符串类型("1");<br/>
	 * 			2."false"转换成字符串类型("0");<br/>
	 * 			3.字符串"1"转换成 boolean类型(true);<br/>
	 * 			4.字符串"0"转换成 boolean类型(false);
	 *
	 * @作者：zhangpj		@创建时间：2016年12月19日
	 * @param map 被改变的map
	 * @param key 被改变的key
	 */
	public static Map<String, Object> convertStatus(Map<String, Object> map,String key){
		Object newObject = null;
		
		// 获取要被转换的key值
		String oldStr = String.valueOf(map.get(key));
		if ("null".equals(oldStr)) {
			newObject = "0";
		}else if("on".equals(oldStr)) {
			newObject = "1";
		}else if ("1".equals(oldStr)) {
			newObject = true;
		}else if ("0".equals(oldStr)) {
			newObject = false;
		}
		
		map.remove(key);
		map.put(key, newObject);
		
		return map;
	}
	//根据当前登录用户查询代理商
	public Map<String,Object> agentGetByUserId(){
		Map<String, Object> user = getUser();
		String usId = (String) user.get("suId");
		Map<String, Object> agent = sysUserDao.agentGetByUserId(usId);
		return agent;
	}
	
	public void getMyLog(Exception e,Logger log){
		//手工回滚事务防止出现不跳页
//		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		log.error(e.getMessage());
		e.printStackTrace();
	}
	
	public String getMyAppPath(HttpServletRequest req){
		return req.getServletContext().getRealPath("/").replace("\\", "/");
	}
	
	/**
	 * 根据传入的路径创建目录如果存在则不创建
	 * @param destDirName 要创建的目录路径
	 * @return true创建目录成功 false 创建目录失败
	 */
    public boolean createDir(String destDirName) {
        File dir = new java.io.File(destDirName);
        if (dir.exists()) {
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        return dir.mkdirs();
    }
    
    public void addMessage(RedirectAttributes redirectAttributes, String messages) {
        redirectAttributes.addFlashAttribute("message", messages);
    }
}
