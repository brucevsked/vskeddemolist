package com.vsked.common;

import javax.servlet.http.HttpServletRequest;
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
}
