package com.vsked.text;

import java.io.File;

public class SystemPathTest {

	public static void main(String[] args) {
		
		File f = new File(SystemPathTest.class.getClass().getResource("/").getPath()); //建议使用这种方案
		System.out.println("type1a:"+f.toString());//type1a:L:\git\vskeddemolist\vskeddemos\mavenproject\vskedtool\target\classes
		System.out.println("type1b:"+f.getAbsolutePath());//type1b:L:\git\vskeddemolist\vskeddemos\mavenproject\vskedtool\target\classes
		try {
			File f1=new File("");
			System.out.println("type2a:"+f1.getCanonicalPath());//type2a:L:\git\vskeddemolist\vskeddemos\mavenproject\vskedtool
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(System.getProperty("user.dir"));//L:\git\vskeddemolist\vskeddemos\mavenproject\vskedtool
		System.out.println( System.getProperty("java.class.path"));
		
	}
	
	/**
	 * 在linux或windows运行java文件先建立java文件对应的包目录
	 *  mkdir -p /tmp/vskedtest/com/vsked/text
	 *  cd /tmp/vskedtest/
	 *  java com.vsked.text.SystemPathTest
	 */

}
