package com.vsked.common;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompressToolTest {
	
	private static final Logger log=LoggerFactory.getLogger(CompressToolTest.class);
	
	@Test
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
	
}
