package com.vsked.test;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.vsked.common.FtpTool;

public class FtpToolTest {
	
	private static final Logger log = LoggerFactory.getLogger(FtpToolTest.class);
	
	FtpTool ftpTool=new FtpTool();
	
//	@Test
	public void connect() throws Exception{
		ftpTool.connect();
		log.debug("connect ok");
		ftpTool.disconnect();
		log.debug("close ok");
	}
	
//	@Test
	public void createFolder() throws Exception{
		String filePath="/";
		String folderName="testa3";
		ftpTool.connect();
		ftpTool.createFolder(folderName);
		List<LsEntry> dataList=ftpTool.listFile(filePath);
		for(LsEntry s:dataList){
			log.debug(s.getFilename()+"|"+s.getLongname()+"|");
		}
		log.debug("connect ok");
		ftpTool.disconnect();
		log.debug("close ok");
	}
	
//	@Test
	public void listFile() throws Exception{
		String filePath="/testa1/";
		ftpTool.connect();
		List<LsEntry> dataList=ftpTool.listFile(filePath);
		for(LsEntry s:dataList){
			log.debug(filePath+s.getFilename()+"|"+s.getLongname()+"|");
		}
		log.debug("connect ok");
		ftpTool.disconnect();
		log.debug("close ok");
	}
	
//	@Test
	public void upload() throws Exception{
		String sourceFile="e:/ocr_id_02.jpg";
		String saveRemotePath="/testa1/ocr_id_02.jpg";
		ftpTool.connect();
		ftpTool.upload(sourceFile, saveRemotePath);
		ftpTool.disconnect();
	}
	
//	@Test
	public void download() throws Exception{
		String sourceFile="/testa1/ocr_id_02.jpg";
		String saveRemotePath="e:/c.jpg";
		ftpTool.connect();
		ftpTool.download(sourceFile, saveRemotePath);
		ftpTool.disconnect();
	}
	
//	@Test
	public void delFile() throws Exception{
		String sourceFile="/testa1/readme.txt";
		ftpTool.connect();
		ftpTool.delFile(sourceFile);
		ftpTool.disconnect();
	}
	
//	@Test
	public void delFolder() throws Exception{
		String folderName="/testa3/";
		ftpTool.connect();
		ftpTool.delFolder(folderName);
		ftpTool.disconnect();
	}
	
//	@Test
	public void connectWithKey(){
		try{
		ftpTool.connectWithKey();
		log.debug("connect ok");
		ftpTool.disconnect();
		log.debug("close ok");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
}
