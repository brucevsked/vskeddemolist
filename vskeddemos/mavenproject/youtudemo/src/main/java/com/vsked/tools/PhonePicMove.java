package com.vsked.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class PhonePicMove {

	public static void main(String[] args) {
		letsGo();
	}
	
	public static void letsGo(){
		String sourceFolder="D:/tempMission/1";
		String targetFolder="d:/tempMission/out";
		
		createDir(targetFolder);//创建目标目录
		
		File fileTemp=new File(sourceFolder);
		File[] fileArray=fileTemp.listFiles();
		String fPath="";
		for (File file : fileArray) {
			fPath=file.getAbsolutePath();
			fPath=fPath.replace("\\", "/");
			System.out.println(file.getAbsolutePath());
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
    
    public  void  copyFile(String  oldPath,  String  newPath)  {    
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
}
