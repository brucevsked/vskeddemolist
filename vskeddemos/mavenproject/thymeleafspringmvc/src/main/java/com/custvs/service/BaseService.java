package com.custvs.service;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.custvs.common.StringTool;
import com.github.pagehelper.Page;

@Service
@Transactional
public class BaseService {
	
	private static final Logger log=LoggerFactory.getLogger(BaseService.class);
	
	String currentPageName="page";
	String pageSizeName="rows";
	
	/**
	 * 获取分页信息
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
		Page<Object> page=new Page<Object>(pageNum,pageSize);
		return page;
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
	 * 获取服务器所在路径
	 * @param req
	 * @return
	 */
	public String getServerPath(HttpServletRequest req){
		String myPath=req.getServletContext().getRealPath("/").replace("\\", "/");
		myPath=myPath.substring(0,myPath.indexOf("/webapps/")+9);
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
     * 转换输入的值与消息为json格式{"code":"code","msg":"msg"}
     * @param code
     * @param msg
     * @return
     * @throws Exception
     */
    public String getJsonMessage(String code,String msg) throws Exception{
    	
    	Map<String, String> resultMap=new HashMap<String, String>();
    	resultMap.put("msg", msg);
    	resultMap.put("code", code);
    	
    	if(log.isDebugEnabled()){
    		log.debug(code+"|"+msg);
    	}
    	
    	String s=StringTool.jackson.writeValueAsString(resultMap);
    	
    	if(log.isDebugEnabled()){
    		log.debug(s);
    	}
    	
    	return s;
    }
    
	/**
	 * 设置用户的session信息。
	 * @param request
	 */
	public static void setUserSession(HttpServletRequest req, Map<String,Object> um) {
		req.getSession().setAttribute("userSession",um);
	}
	
	/**
	 * 移除用户的session信息。
	 * @param request
	 */
	public static void removeUserSession(HttpServletRequest req) {
		req.getSession().removeAttribute("userSession");
	}
	
	/**
	 * 获取当前用户id
	 * @param req
	 * @return
	 */
	public static String getCurUserId(HttpServletRequest req){
		@SuppressWarnings("unchecked")
		Map<String, Object> um=(Map<String, Object>) req.getSession().getAttribute("userSession");
		return (um!=null && um.containsKey("suId"))?(String) um.get("suId"):null;
	}
}
