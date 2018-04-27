package com.vsked.test;

import org.apache.commons.net.ftp.FTPFile;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsked.common.FtpToolCommon;

public class FtpToolCommonTest {
	
	private static final Logger log = LoggerFactory.getLogger(FtpToolCommonTest.class);
	
	FtpToolCommon ftpToolCommon=new FtpToolCommon();

//	@Test
	public void connect() {
		try{
		ftpToolCommon.connect();
		log.debug("connect ok");
		ftpToolCommon.disconnect();
		log.debug("disconnect ok");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void upload() {
		try{
			String sourceFile="e:/readme.txt";
			String saveRemotePath="/readme.txt";
		ftpToolCommon.connect();
		log.debug("connect ok");
		ftpToolCommon.upload(sourceFile, saveRemotePath);
		log.debug("upload ok");
		ftpToolCommon.disconnect();
		log.debug("disconnect ok");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void download() {
		try{
			String sourceFile="/readme.txt";
			String saveRemotePath="e:/re.txt";
		ftpToolCommon.connect();
		log.debug("connect ok");
		ftpToolCommon.download(sourceFile, saveRemotePath);
		log.debug("download ok");
		ftpToolCommon.disconnect();
		log.debug("disconnect ok");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void createFolder() {
		try{
			String sourceFile="/testa3";
		ftpToolCommon.connect();
		log.debug("connect ok");
		ftpToolCommon.createFolder(sourceFile);
		log.debug("createFolder ok");
		ftpToolCommon.disconnect();
		log.debug("disconnect ok");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void delFolder() {
		try{
			String sourceFile="/testa3";
		ftpToolCommon.connect();
		log.debug("connect ok");
		ftpToolCommon.delFolder(sourceFile);
		log.debug("createFolder ok");
		ftpToolCommon.disconnect();
		log.debug("disconnect ok");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void delFile() {
		try{
			String sourceFile="/readme.txt";
		ftpToolCommon.connect();
		log.debug("connect ok");
		ftpToolCommon.delFile(sourceFile);
		log.debug("deletefile ok");
		ftpToolCommon.disconnect();
		log.debug("disconnect ok");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void listFile() {
		try{
			String sourceFile="/testa1/";
		ftpToolCommon.connect();
		log.debug("connect ok");
		FTPFile[] fileNames=ftpToolCommon.listFile(sourceFile);
		for(FTPFile s:fileNames){
			log.debug(sourceFile+s.getName());
		}
		ftpToolCommon.disconnect();
		log.debug("disconnect ok");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	
}
