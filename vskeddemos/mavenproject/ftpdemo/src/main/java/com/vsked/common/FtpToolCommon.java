package com.vsked.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FtpToolCommon {
	
	private String host="192.168.1.188";
	private String userName="mytest1";
	private String userPass="0y0WcP4S";
	private int port=52821;
	
	private static FTPClient ftpClient = null; // FTP 客户端代理

	public FtpToolCommon() {
		super();
	}

	public FtpToolCommon(String host, String userName, String userPass, int port) {
		super();
		this.host = host;
		this.userName = userName;
		this.userPass = userPass;
		this.port = port;
	}
	
	/**
	 * 连接ftp
	 * @throws Exception
	 */
    public void connect() throws Exception{
    	ftpClient = new FTPClient();
        ftpClient.setControlEncoding("utf-8");
        ftpClient.connect(host, port); //连接ftp服务器
        ftpClient.setDefaultPort(port);
        ftpClient.login(userName, userPass); //登录ftp服务器
//				ftpClient.enterLocalActiveMode();	// 主动模式,创建文件但是一直为0KB的时候换被动模式试试,一般本地环境时使用
				ftpClient.enterLocalPassiveMode();	// 被动模式,创建文件但是一直为0KB的时候换被主模式试试,一般远程时使用
        int replyCode = ftpClient.getReplyCode(); //是否成功登录服务器
        if(!FTPReply.isPositiveCompletion(replyCode)){
        	System.out.println("login fail");
        }
    }
    
    /**
     * 文件上传
     * @param sourceFile 本地文件
     * @param saveRemotePath 远程文件
     * @return
     * @throws Exception
     */
    public boolean upload(String sourceFile,String saveRemotePath) throws Exception{
    	boolean flag=false;
//    	ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
//    	ftpClient.setFileType(ftpClient.ASCII_FILE_TYPE);
    	flag=ftpClient.storeFile(saveRemotePath, new FileInputStream(sourceFile));
    	return flag;
    }
    
    /**
     * 文件下载
     * @param sourceFile 远程文件
     * @param savePath 本地路径
     * @throws Exception
     */
    public void download(String sourceFile,String savePath) throws Exception{
    	ftpClient.retrieveFile(sourceFile, new FileOutputStream(savePath));
    }
    
    /**
     * 创建文件夹
     * @param folderName
     * @return
     * @throws Exception
     */
    public boolean createFolder(String folderName) throws Exception{
    	boolean flag=ftpClient.makeDirectory(folderName);
    	return flag;
    }
    
    /**
     * 删除文件夹
     * @param folderName
     * @return
     * @throws Exception
     */
    public boolean delFolder(String folderName) throws Exception{
    	boolean flag=ftpClient.removeDirectory(folderName);
    	return flag;
    }
    
    /**
     * 删除文件
     * @param fileName
     * @return
     * @throws Exception
     */
    public boolean delFile(String fileName) throws Exception{
    	boolean flag=ftpClient.deleteFile(fileName);
    	return flag;
    }
    
    /**
     * 文件列表
     * @param path
     * @return
     * @throws Exception
     */
    public FTPFile[] listFile(String path) throws Exception{
    	FTPFile[] fileNames=ftpClient.listFiles(path);
    	return fileNames;
    	
    }
    
    /**
     * 退出并关闭连接
     * @throws Exception
     */
    public void disconnect() throws Exception{
    	ftpClient.logout();
    	ftpClient.disconnect();
    }
}
