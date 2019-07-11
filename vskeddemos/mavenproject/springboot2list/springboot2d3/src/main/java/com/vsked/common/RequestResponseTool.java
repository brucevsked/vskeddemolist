package com.vsked.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestResponseTool {
	
	private static String charset="utf-8";
	
    /**
     * 转换输入的值与消息为json格式{"code":"code","msg":"msg"}
     * @param code
     * @param msg
     * @return
     * @throws Exception
     */
    public static String getJsonMessage(String code,String msg){
    	StringBuffer sb=new StringBuffer();
    	sb.append("{");
    	sb.append("\"code\":\""+code+"\",");
    	sb.append("\"msg\":\""+msg+"\",");
    	sb.append("\"servertime\":\""+DateTimeTool.getCurDateTime()+"\"");
    	sb.append("}");
    	String s=sb.toString();
    	return s;
    }
    
    /**
     * 转换输入的值与消息为json格式{"code":"code","msg":"msg","data":{"k1":"v1"}}
     * @param code
     * @param msg
     * @param data
     * @return
     * @throws Exception
     */
    public static String getJsonMessage(String code,String msg,String data){
    	StringBuffer sb=new StringBuffer();
    	sb.append("{");
    	sb.append("\"code\":\""+code+"\",");
    	sb.append("\"msg\":\""+msg+"\",");
    	sb.append("\"servertime\":\""+DateTimeTool.getCurDateTime()+"\",");
    	sb.append("\"data\":"+data+"");
    	sb.append("}");
    	String s=sb.toString();
    	return s;
    }
    
    /**
     * 响应json数据到前端
     * @param jsonStr
     * @param resp
     * @throws Exception
     */
    public static void respJson(String jsonStr, ServletResponse resp) throws Exception{
    	resp.setCharacterEncoding("UTF-8");
    	resp.setContentType("application/json;charset=utf-8");
    	PrintWriter printWriter =resp.getWriter();
    	printWriter.write(jsonStr);
    	printWriter.flush();
    	printWriter.close();
    }

	
	/**
	 * 获取请求头部指定key值
	 * @param req
	 * @param key
	 * @return
	 */
    public static String getHeader(HttpServletRequest req, String key) {
        return req.getHeader(key);
    }
    
    /**
     * 将请求头部信息封装为Map<String,String>
     * @param req
     * @return
     */
    public static Map<String,String> getRequestHeaders(HttpServletRequest req) {
        Map<String,String> headerMap = new HashMap<>();
        Enumeration<String> enums = req.getHeaderNames();
        String name="";
        while (enums.hasMoreElements()) {
            name = enums.nextElement();
            headerMap.put(name,req.getHeader(name));
        }
        return headerMap;
    }
    
    /**
     * 获取请求中参数
     * @param req
     * @param parName
     * @return
     */
    public static String getParameter(HttpServletRequest req,String parName){
    	return req.getParameter(parName);
    }
    
    /**
     * 将请求参数与值封装成Map<String,Object>
     * @param req
     * @return
     */
	public static Map<String,String> getRequestParameters(HttpServletRequest req){
		Map<String,String> m=new HashMap<String, String>();
		Enumeration<String> e=req.getParameterNames();
		String s;
		while(e.hasMoreElements()){
			s=e.nextElement();
			m.put(s, req.getParameter(s));
		}
		return m;
	}
	
	/**
	 * 从请求数据流中读取字符串方式1
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public static String getStringFromStream1(HttpServletRequest req) throws Exception{
		byte[] bytes = new byte[1024 * 1024];  
        InputStream is = req.getInputStream();  
        int nRead = 1;  
        int nTotalRead = 0;  
        while (nRead > 0) {  
            nRead = is.read(bytes, nTotalRead, bytes.length - nTotalRead);  
            if (nRead > 0)  
                nTotalRead = nTotalRead + nRead;  
        }  
        String rs = new String(bytes, 0, nTotalRead, charset);  
        return rs;
	}
	
	/**
	 * 从请求数据流中读取字符串方式2
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public static String getStringFromStream2(HttpServletRequest req) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) req.getInputStream()));  
        String line = null;  
        StringBuilder sb = new StringBuilder();  
        while ((line = br.readLine()) != null) {  
            sb.append(line);  
        }
        String rs=sb.toString();
        return rs;
	}

}
