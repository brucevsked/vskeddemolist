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

@Service
@Transactional
public class BaseService {
	
	private static final Logger log=LoggerFactory.getLogger(BaseService.class);
	
	/**
	 * 将请求参数封装成map
	 * @param req
	 * @return
	 */
	public static Map<String,Object> getMaps(HttpServletRequest req){
		Map<String,Object> m=new HashMap<String, Object>();
		Enumeration<String> e=req.getParameterNames();
		
		while(e.hasMoreElements()){
			String s=(String) e.nextElement();
			m.put(s, req.getParameter(s));
		}
		
		if(log.isDebugEnabled()){
			log.debug(m+"");
		}
		
		return m;
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
}
