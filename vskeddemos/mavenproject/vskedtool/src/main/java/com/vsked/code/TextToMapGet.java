package com.vsked.code;

import java.io.File;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextToMapGet {
	
	private static final Logger log=LoggerFactory.getLogger(TextToMapGet.class);

	public static void main(String[] args) {
		try{
		String sourceFile="d:/source.txt";
		List<String> dataList=FileUtils.readLines(new File(sourceFile),"utf-8");
		
		System.out.println("StringBuffer sb=new StringBuffer();");
		
		for(String s:dataList){
			System.out.println("sb.append(\""+s+"\"+parMap.get(\""+s+"\"));");
		}
		
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

}
