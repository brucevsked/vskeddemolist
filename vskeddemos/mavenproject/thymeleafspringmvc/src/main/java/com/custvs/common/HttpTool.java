package com.custvs.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpTool {
	
	private static final Logger log=LoggerFactory.getLogger(HttpTool.class);
	
	/**
	 * 从request数据流中获取内容并返回字符串
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public static String getStrFromReqStream(HttpServletRequest req) throws Exception{
		InputStream is = req.getInputStream();  
        InputStreamReader isr = new InputStreamReader(is);  
        BufferedReader br = new BufferedReader(isr);  
        StringBuffer sb=new StringBuffer();
        String s="";
        while ((s = br.readLine()) != null) {  
            sb.append(s);  
        }  
       s= sb.toString();
       if(log.isDebugEnabled()){
    	   log.debug(s);
       }
       return s;
	}
	
	/**
	 * url解码
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public String urlDecode(String s) throws Exception{
		String result=URLDecoder.decode(s,"utf-8");
		if(log.isDebugEnabled()){
			log.debug(s);
	    	log.debug(result);
	    }
		return result;
	}
	
	/**
	 * url编码
	 * @param par
	 * @return
	 * @throws Exception
	 */
	public String urlEncode(String par) throws Exception{
		String result=URLEncoder.encode(par, "utf-8");
		if(log.isDebugEnabled()){
			log.debug(par);
	    	log.debug(result);
	    }
		return result;
	}

}
