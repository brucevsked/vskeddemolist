package com.vsked.common;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompressToolTest {
	
	private static final Logger log=LoggerFactory.getLogger(CompressToolTest.class);
	
//	@Test
	public void tarCompress(){
		try{
			String sourceFile="d:/source.txt";
			String targetFile="d:/testv1.tar";
			CompressTool.tarCompressFile(sourceFile, targetFile);
			
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void tarUnCompressFile(){
		try{
			String sourceFile="d:/testv1.tar";
			String targetFile="d:/ssta1.txt";
			CompressTool.tarUnCompressFile(sourceFile, targetFile);
			
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void tarCompressFolder(){
		try{
			String sourceFile="D:/logs/zhongyousj/";
			String targetFile="d:/logs/testv1.tar";
			CompressTool.tarCompressFolder(sourceFile, targetFile);
			
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	@Test
	public void tarUnCompressFolder(){
		try{
			String sourceFile="d:/logs/testv1.tar";
			String targetFolder="d:/logs/t1/";
			CompressTool.tarUnCompressFolder(sourceFile, targetFolder);
			
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void t(){
		String s="D:/logs/zhongyousj/";
		s=s.substring(0,s.length()-1);
		log.debug("a:"+s);
		s=s.substring(s.lastIndexOf("/")+1)+"/";
		log.debug(s);
	}
	
}
