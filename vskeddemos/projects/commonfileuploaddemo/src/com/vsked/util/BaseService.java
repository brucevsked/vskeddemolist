package com.vsked.util;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class BaseService {
	
	public Map<String, Object> uploadFile(HttpServletRequest req,String savePath){
		Map<String, Object> m=new HashMap<String, Object>();
		try{
		if(ServletFileUpload.isMultipartContent(req)){
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
			String mapValue="";
			Iterator<FileItem> itr = items.iterator();
			while(itr.hasNext()){
				FileItem item = itr.next();
				if(!item.isFormField()){
					mapValue=savePath+item.getName();
					item.write(new File(getMyAppPath(req)+mapValue));
				}else{
					mapValue=item.getString("utf-8");
				}
				m.put(item.getFieldName(), mapValue);
			}
		}
		}catch(Exception e){ e.printStackTrace(); }
		System.out.println(m);
		return m;		
	}
	
	public String getMyAppPath(HttpServletRequest req){
		return req.getServletContext().getRealPath("/").replace("\\", "/");
	}
	
	public Map<String,Object> getMaps(HttpServletRequest req){
		Map<String,Object> m=new HashMap<String, Object>();
		Enumeration<?> e=req.getParameterNames();
		while(e.hasMoreElements()){
			String s=(String) e.nextElement();
			m.put(s, req.getParameter(s));
		}
		return m;
	}

}
