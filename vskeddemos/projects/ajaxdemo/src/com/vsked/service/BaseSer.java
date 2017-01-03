package com.vsked.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

public class BaseSer {
	
	public static String getMyAppPath(HttpServletRequest req){
		return req.getServletContext().getRealPath("/").replace("\\", "/");
	}
	
	  /**
     * 创建目录
     * @param destDirName 目录名称
     * @return boolean
     */
    public static boolean createDir(String destDirName) {
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
     * map中为字段名与字段内容外加一个u属性 u为上传路径
     * @param req
     * @param res
     * @return Map 
     */
    public static Map<String,Object> uploadFile(HttpServletRequest req){
    	Map<String,Object> m=new HashMap<String,Object>();
    	try {
    		String dataBaseValue="uploads/";
        	String tempPath = getMyAppPath(req);
        	createDir((tempPath+dataBaseValue));
        	char[] hchl={13,10}; 
        	String boundary=req.getContentType().substring(30); 
        	String field_boundary="--"+boundary+new String(hchl); 
        	String last_boundary="--"+boundary+"--"+new String(hchl); 
        	ServletInputStream getdata=req.getInputStream(); 
        	ByteArrayOutputStream temp=new ByteArrayOutputStream(); 
        	byte[] data_line=new byte[8192]; 
        	int line_byte_count=0; 
        	boolean found_boundary=false; 
        	while((line_byte_count=getdata.readLine(data_line,0,data_line.length))!=-1){ 
        	    if(!found_boundary){ 
        	        line_byte_count=getdata.readLine(data_line,0,data_line.length); 
        	    } 
        	    String temp_str=new String(data_line,0,line_byte_count,"utf-8"); 
        	    if(temp_str.indexOf("filename")!=-1){ 
        	        if(temp_str.substring(temp_str.indexOf("filename=")+9,temp_str.lastIndexOf("\"")+1).length()>2){ 
        	        	String fileName=Calendar.getInstance().getTimeInMillis()+"";
        	        	String fileExt=temp_str.substring(temp_str.lastIndexOf("\\")+1,temp_str.lastIndexOf("\""));
        	        	fileExt=fileExt.substring(fileExt.lastIndexOf("."));
        	        	dataBaseValue+=fileName+fileExt;
        	            line_byte_count=getdata.readLine(data_line,0,data_line.length); 
        	            line_byte_count=getdata.readLine(data_line,0,data_line.length); 
        	            FileOutputStream myfile=new FileOutputStream(tempPath+dataBaseValue,false); //文件存放目录
        	            boolean test=true; 
        	            while(test) { 
        	                line_byte_count=getdata.readLine(data_line,0,data_line.length); 
        	                if(line_byte_count==-1){ 
        	                    test=false; 
        	                    break; 
        	                } 
        	                if(temp.size()==0){ 
        	                    temp.write(data_line,0,line_byte_count); 
        	                }else{ 
        	                    if(new String(data_line,0,line_byte_count,"utf-8").equals(field_boundary) || new String(data_line,0,line_byte_count,"utf-8").equals(last_boundary)){ 
        	                        myfile.write(temp.toByteArray(),0,temp.toByteArray().length-2); 
        	                        temp.reset(); 
        	                        myfile.close(); 
        	                        test=false; 
        	                        found_boundary=true; 
        	                    }else{ 
        	                        temp.writeTo(myfile); 
        	                        temp.reset(); 
        	                        temp.write(data_line,0,line_byte_count); 
        	                    } 
        	                } 
        	            } 
        	        }
        	    } else{ 
        	    	String field_name=temp_str.substring(temp_str.indexOf("name")+6,temp_str.lastIndexOf("\"")); 
        	    	line_byte_count=getdata.readLine(data_line,0,data_line.length); 
        	        temp.reset(); 
        	        boolean test=true; 
        	        while(test) { 
        	            line_byte_count=getdata.readLine(data_line,0,data_line.length); 
        	            if(line_byte_count==-1){ 
        	                test=false; 
        	                break; 
        	            } 
        	            if(new String(data_line,0,line_byte_count,"utf-8").equals(field_boundary) || new String(data_line,0,line_byte_count,"utf-8").equals(last_boundary)){ 
        	                test=false; 
        	                found_boundary=true; 
        	                if(temp.size()>2){
        	                   // System.out.println(field_name+":"+new String(temp.toByteArray(),"UTF-8")+" <br>"); 取出流中字段与值
        	                	String t=new String(temp.toByteArray(),"UTF-8"); 
        	                	t=t.substring(0,t.length()-2);
        	                    m.put(field_name, t);
        	                }
        	                temp.reset(); 
        	            }else{ 
        	                temp.write(data_line,0,line_byte_count); 
        	            } 
        	        } 
        	    } 
        	    
        	} 
        	getdata.close(); 
        	m.put("u", dataBaseValue);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    	return m;
    }
}
