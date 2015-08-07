package com.vsked.test;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class TestCommonsIO {

	public static void main(String[] args) throws Exception {
		String filePath="e:/logs/catalina.out";
		String writeFilePath="e:/test.txt";
		String encoding="utf-8";
		String s1=FileUtils.readFileToString(new File(filePath));
//		System.out.println(s1);
		String s2=FileUtils.readFileToString(new File(filePath), encoding);
//		System.out.println(s2);
		File f=FileUtils.getFile(filePath);
		String s3=FileUtils.readFileToString(f);
//		System.out.println(s3);
		
		String data1="aaaaaaa\r\n";
		String data2="bbbbbbbbb\r\n";
		String data3="1234567890\r\n";
		String data4="abcdefg\r\n";
		//overwrite file content
//		FileUtils.writeStringToFile(new File(writeFilePath), data2);
		
		//append model add new content to end
//		FileUtils.writeStringToFile(new File(writeFilePath), data1, true);
		
		//overwrite file content use encoding
//		FileUtils.writeStringToFile(new File(writeFilePath), data1, encoding);
		
		//append model add new content to end and use encoding
		FileUtils.writeStringToFile(new File(writeFilePath), data1,encoding, true);
		
		
	}

}
