package com.vsked.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;

import com.vsked.test.GlobalSet;
import com.youtu.Youtu;

public class PhonePicMove {

	public static void main(String[] args) {
		letsGo();
	}
	
	public static void letsGo(){
		String sourceFolder="D:/tempMission/2";
		String targetFolder="d:/tempMission/out";
		
		createDir(targetFolder);//创建目标目录
		
		File fileTemp=new File(sourceFolder);
		File[] fileArray=fileTemp.listFiles();
		String fPath="";
		for (File file : fileArray) {
			fPath=file.getAbsolutePath();
			fPath=fPath.replace("\\", "/");
			System.out.println(file.getAbsolutePath());
			isExistPhone(fPath, targetFolder);
		}
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
    
    public static void copyFile(String  oldPath,  String  newPath){    
        try  {    
            int  byteread  =  0;    
            File  oldfile  =  new  File(oldPath);    
            if  (oldfile.exists())  {  //文件存在时    
                InputStream  inStream  =  new  FileInputStream(oldPath);  //读入原文件   
                FileOutputStream  fs  =  new  FileOutputStream(newPath);    
                byte[]  buffer  =  new  byte[1444];    
                while  (  (byteread  =  inStream.read(buffer))  !=  -1)  {    
                    fs.write(buffer,  0,  byteread);    
                }    
                inStream.close();    
            }    
        }    
        catch  (Exception  e)  {    
            System.out.println("复制单个文件操作出错");    
            e.printStackTrace();    
        }    
    
    }
    
    
	public static boolean isExistPhone(String fpath,String ouputPath){
		try {
			Youtu faceYoutu = new Youtu(GlobalSet.APP_ID, GlobalSet.SECRET_ID, GlobalSet.SECRET_KEY,Youtu.API_YOUTU_END_POINT,GlobalSet.USER_ID);
			JSONObject respose;
			respose=faceYoutu.GeneralOcr(fpath);
//			System.out.println(respose.toString());
			JSONArray items=respose.getJSONArray("items");
			
			JSONObject infoStr;
			String itemStr="";
			for (Object item : items) {
				infoStr=(JSONObject) item;
				itemStr=infoStr.getString("itemstring");
				itemStr=itemStr.replace(" ", "");
//				System.out.println("|"+itemStr+"|");
				if(isPhone(itemStr)){
					createDir(ouputPath+"/"+itemStr);
					copyFile(fpath, ouputPath+"/"+itemStr+"/"+new File(fpath).getName());
					return true;
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean isPhone(String str){
			Pattern pattern = Pattern.compile("(13\\d|14\\d|15\\d|17\\d|18\\d)\\d{8}");
			return pattern.matcher(str).matches();    
	}
	
	
}
