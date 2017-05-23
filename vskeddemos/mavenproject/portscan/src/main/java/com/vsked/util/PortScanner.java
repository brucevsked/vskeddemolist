package com.vsked.util;

import java.net.Socket;

import org.apache.log4j.Logger;

public class PortScanner {
	
	private static Logger log = Logger.getLogger(PortScanner.class);
	
	public boolean isOpen(String ipAddr,int port){
		boolean flag=false;
		try{
			Socket socket=new Socket(ipAddr, port);
			socket.close();
			flag=true;
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return flag;
	}

}
