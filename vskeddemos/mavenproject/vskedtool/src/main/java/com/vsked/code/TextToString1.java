package com.vsked.code;

import java.io.File;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 转换名称为字符串声明
 * 示例
 * ha1
 * 输出String ha1="";
 * @author brucevsked
 *
 */
public class TextToString1 {
	
	private static final Logger log=LoggerFactory.getLogger(TextToString1.class);

	/**
	 * mysql中可用desc opencardInfoT;查看表结构
	 * oracle中可用 select * from cols where table_name='VSKEDTMPA'; 查看表结构
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		String sourceFile="d:/source.txt";
		List<String> dataList=FileUtils.readLines(new File(sourceFile),"utf-8");
		int i=0;
		for(String s:dataList){
			System.out.println("String "+s.replace(" ", "")+"=\""+i+"\";");
		}
		
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}

	}

}
