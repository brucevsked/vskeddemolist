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
public class TextToJson1 {
	
	private static final Logger log=LoggerFactory.getLogger(TextToJson1.class);

	public static void main(String[] args) {
		try{
		String sourceFile="d:/source.txt";
		List<String> dataList=FileUtils.readLines(new File(sourceFile),"utf-8");
		
		String col="";
		for(String s:dataList){
			col=s.split("=")[0];
			col=col.substring(col.lastIndexOf(" "));
			System.out.println(col+":"+col+",");
		}
		
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
}
