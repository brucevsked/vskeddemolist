package com.vsked.file;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Calendar;

/**
 * centos 文件被占用可以用lsof 文件名命令
 * @author vsked
 *
 */
public class FileLastModifyTime {

	public static void main(String[] args) {
		
     testDelFile();

	}
	
	public static void testLastTime() {
		File f=new File("d:/cca1.txt");
		long lastModify=f.lastModified();//文件最后修改时间
		System.out.println(lastModify);
		
		Calendar nowTime = Calendar.getInstance();//得到当前时间
		System.out.println(nowTime.getTimeInMillis());//当前时间
		nowTime.add(Calendar.MINUTE, -3);
		System.out.println(nowTime.getTimeInMillis());//三分钟后
	}
	
	public static void testDelFile() {
		try {
			File f=new File("d:/cca1.txt");
			RandomAccessFile raf=new RandomAccessFile(f, "rws");
			System.out.println(f.canWrite());
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
