package com.vsked.service;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test1Service extends BaseService{
	
	private static final Logger log=LogManager.getLogger(Test1Service.class);
	
	public static  String proc1(HttpServletRequest req){
		String result="";
		Map<String, Object> m=getMaps(req);
		
		String contentType=req.getContentType();
		result=req.getMethod()+"|"+contentType+"|test1 back|"+m;
//		System.out.println(contentType.indexOf("multipart"));
		//是文件上传
		if(contentType!=null && contentType.indexOf("multipart")>-1){
			result=req.getMethod()+"|"+contentType+"|test1 back|";
			String savePath=getMyAppPath(req)+"upload/";
			createDir(savePath);
			try {
				List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
				Iterator<FileItem> itr = items.iterator();
				String mapValue="";
				while(itr.hasNext()){
					FileItem item = itr.next();
					if(!item.isFormField()){
						mapValue=savePath+item.getName();
						item.write(new File(mapValue));
					}else{
						mapValue=item.getString("utf-8");
					}
					result+="|"+item.getFieldName()+"|"+mapValue;
				}
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			System.out.println(getMyAppPath(req));
		}
		log.debug(result);
		return result;
	}

}
