package com.vsked.code;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextToStringAndMap3 {
	
	private static final Logger log=LoggerFactory.getLogger(TextToStringAndMap3.class);

	public static void main(String[] args) {
		try{
		String sourceFile="d:/source.txt";
		List<String> dataList=FileUtils.readLines(new File(sourceFile),"utf-8");
		
		for(String s:dataList){
			System.out.println("String "+s.replace(" ", "")+"=\"\";");
		}
		
		System.out.println("Map<String,Object> m=new HashMap<String, Object>();");
		
		for(String s:dataList){
			System.out.println("m.put(\""+s+"\","+s+");");
		}
		
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

}
