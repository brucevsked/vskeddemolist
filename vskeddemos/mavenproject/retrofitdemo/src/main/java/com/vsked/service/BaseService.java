package com.vsked.service;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseService {
	
	private static final Logger log = LoggerFactory.getLogger(BaseService.class);
	
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
			log.debug(m.toString());
		}

		return m;
	}
	
	/**
	 * 获取项目真实目录
	 * @param req
	 * @return
	 */
	public static String getMyAppPath(HttpServletRequest req){
		return req.getServletContext().getRealPath("/").replace("\\", "/");
	}
	
	/**
	 * 根据传入的路径创建目录如果存在则不创建
	 * @param destDirName 要创建的目录路径
	 * @return true创建目录成功 false 创建目录失败
	 */
    public static boolean createDir(String destDirName) {
        File dir = new java.io.File(destDirName);
        if (dir.exists()) {
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        return dir.mkdirs();
    }
}
