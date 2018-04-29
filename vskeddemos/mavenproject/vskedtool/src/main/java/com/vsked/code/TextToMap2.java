package com.vsked.code;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 转换声明为map键值
 * 示例
 * String s1="2";
 * 转换为
 * m.put("s1",s1);
 * @author brucevsked
 *
 */
public class TextToMap2 {
	
	private static final Logger log=LoggerFactory.getLogger(TextToMap2.class);

	public static void main(String[] args) {
		try{
		String sourceFile="d:/source.txt";
		List<String> dataList=FileUtils.readLines(new File(sourceFile),"utf-8");
		
		String col="";
		for(String s:dataList){
			col=s.substring(s.indexOf("String")+6,s.indexOf("="));
			col=col.replace(" ", "");
			System.out.println("m.put(\""+col+"\","+col+");");
		}
		
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
}
