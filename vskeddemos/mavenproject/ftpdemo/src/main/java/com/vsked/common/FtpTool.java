package com.vsked.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FtpTool {
	
	private static final Logger log = LoggerFactory.getLogger(FtpTool.class);
	
	private String host="192.168.1.188";
	private String userName="mytest1";
	private String userPass="0y0WcP4S";
	private int port=52822;
	
	private ChannelSftp sftp = null;

	public FtpTool() {
		super();
	}

	/**
	 * 初始化连接信息
	 * @param host
	 * @param userName
	 * @param userPass
	 * @param port
	 */
	public FtpTool(String host, String userName, String userPass, int port) {
		super();
		this.host = host;
		this.userName = userName;
		this.userPass = userPass;
		this.port = port;
	}
	
	/**
	 * 连接ftp服务器使用默认参数
	 */
    public void connect() throws Exception{
    	JSch jsch = new JSch();
        jsch.getSession(userName, host, port);
        Session sshSession = jsch.getSession(userName, host, port);
        sshSession.setPassword(userPass);
        Properties sshConfig = new Properties();
        sshConfig.put("StrictHostKeyChecking", "no");
        sshSession.setConfig(sshConfig);
        sshSession.connect();
        Channel channel = sshSession.openChannel("sftp");
        channel.connect();
        sftp = (ChannelSftp) channel;
    }
    
    /**
     * 连接远程服务器使用参数
     * @param host 主机地址
     * @param userName 用户名
     * @param userPass 密码
     * @param port 端口号
     * @throws Exception
     */
    public void connect(String host, String userName, String userPass, int port) throws Exception{
    	JSch jsch = new JSch();
        jsch.getSession(userName, host, port);
        Session sshSession = jsch.getSession(userName, host, port);
        sshSession.setPassword(userPass);
        Properties sshConfig = new Properties();
        sshConfig.put("StrictHostKeyChecking", "no");
        sshSession.setConfig(sshConfig);
        sshSession.connect();
        Channel channel = sshSession.openChannel("sftp");
        channel.connect();
        sftp = (ChannelSftp) channel;
    }
    
    /**
     * 上传本地文件到远程
     * @param sourceFile 本地文件
     * @param saveRemotePath 远程保存路径
     * @throws Exception
     */
    public void upload(String sourceFile,String saveRemotePath) throws Exception{
    	sftp.put(new FileInputStream(sourceFile), saveRemotePath);
    }
    
    /**
     * 下载指定文件
     * @param sourceFile 远程文件路径
     * @param savePath 本地文件名
     * @throws Exception
     */
    public void download(String sourceFile,String savePath) throws Exception{
    	sftp.get(sourceFile,new FileOutputStream(savePath));
    }
    
    /**
     * 创建文件夹
     * @param folderName
     * @throws Exception
     */
    public void createFolder(String folderName) throws Exception{
    	sftp.mkdir(folderName);
    }
    
    /**
     * 删除指定文件夹
     * @param folderName
     * @throws Exception
     */
    public void delFolder(String folderName) throws Exception{
    	sftp.rmdir(folderName);
    }
    
    /**
     * 删除指定文件
     * @param fileName
     * @throws Exception
     */
    public void delFile(String fileName) throws Exception{
    	sftp.rm(fileName);
    }
    
    
    /**
     * 查看路径下文件列表
     * @param filePath
     * @return
     * @throws Exception
     */
	public List<LsEntry> listFile(String filePath)throws Exception{
		@SuppressWarnings("unchecked")
		Vector<LsEntry> dataVector=sftp.ls(filePath);
		List<LsEntry> dataList=new ArrayList<LsEntry>(dataVector);
    	return dataList;
    }
    
	/**
	 * 断开ftp连接
	 */
    public void disconnect() {
        if(this.sftp != null){
            if(this.sftp.isConnected()){
                this.sftp.disconnect();
            }else if(this.sftp.isClosed()){
                log.debug("sftp is closed already");
            }
        }

    }
	
}
