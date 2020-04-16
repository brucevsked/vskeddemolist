package com.vsked.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class BashTool {
	
	private static final Logger log = LoggerFactory.getLogger(BashTool.class);
	
	String command = "ls /opt/";
	String host = "192.168.111.77";
	String userName = "root";
	String userPass = "root";
	int port = 22;
	int CONNECT_TIMEOUT = 50000;
	
	ChannelExec channel = null;
	
	public BashTool(String host, String userName, String userPass, int port) {
		super();
		this.host = host;
		this.userName = userName;
		this.userPass = userPass;
		this.port = port;
	}
	
    public void connect() throws Exception{
		JSch jsch = new JSch();
		Session sshSession = jsch.getSession(userName, host, port);
		sshSession.setPassword(userPass);
		Properties sshConfig = new Properties();
		sshConfig.put("StrictHostKeyChecking", "no");
		sshSession.setConfig(sshConfig);
		sshSession.connect();
		
		log.info("==>|"+sshSession.isConnected());
		channel = (ChannelExec) sshSession.openChannel("exec");
    }
    
    public String exeBash(String command) throws Exception {
    	String result="";
		channel.setCommand(command);
		InputStream input = channel.getInputStream();
		channel.connect(CONNECT_TIMEOUT);
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(input));
		String inputLine = null;
        while((inputLine = inputReader.readLine()) != null) {
//            log.debug("   {}", inputLine);
            result+=inputLine+System.getProperty("line.separator");
        }
        
		inputReader.close();
		input.close();
		return result;
    }
    
    public void disconnect() {
        if(this.channel != null){
            if(this.channel.isConnected()){
                this.channel.disconnect();
            }else if(this.channel.isClosed()){
                log.debug("bashtool is closed already");
            }
        }

    }
	
	

}
