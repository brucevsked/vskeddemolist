package com.vsked.test1;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsked.common.SerialPortTool;

import gnu.io.SerialPort;

public class SerialPortToolTest {
	
	private static final Logger log=LoggerFactory.getLogger(SerialPortToolTest.class);
	SerialPortTool spt=new SerialPortTool();
	
//	@Test
	public void getPortList(){
		try{
			List<String> portList=spt.getPortList();
			log.debug("|"+portList+"|");
			log.debug("|"+portList.size()+"|");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void openPortClosePort(){
		try{
			List<String> portList=spt.getPortList();
			SerialPort myPort=null;
			for(String portName:portList){
				myPort=spt.openPort(portName, 9600);
				if(myPort!=null){
					log.debug("open port ok|"+portName+"|");
					spt.closePort(myPort);
					log.debug("close port ok|"+portName+"|");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	@Test
	public void sendToPort(){
		try{
			String portName="COM3";
			SerialPort myPort=myPort=spt.openPort(portName, 9600);
			//F2
			String hexString="f309f3";
			byte[] sendData=spt.hexToByte(hexString);
			spt.sendToPort(myPort, sendData);
			log.debug("open port ok|"+portName+"|");
			spt.closePort(myPort);
			log.debug("close port ok|"+portName+"|");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

}
