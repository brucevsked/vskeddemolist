package com.jat.common;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class Request {

    public static Map<String,Object> getMaps(HttpServletRequest req){
        Map<String,Object> m=new HashMap<String, Object>();
        Enumeration<String> e=req.getParameterNames();
        while(e.hasMoreElements()){
            String s=(String) e.nextElement();
            m.put(s, req.getParameter(s));
        }
        return m;
    }
    
	public static String getStringFromStream(HttpServletRequest req,String charset) throws Exception{
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
}
