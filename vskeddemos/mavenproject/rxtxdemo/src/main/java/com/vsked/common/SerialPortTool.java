package com.vsked.common;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class SerialPortTool {
	
	/**
	 * 打开串口超时
	 */
	int openTimeout=5000;//5s
	
	/**
	 * 获取串口列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public  List<String> getPortList(){
		List<String> portList=new LinkedList<String>();
		Enumeration<CommPortIdentifier> ports = CommPortIdentifier.getPortIdentifiers();
		String portName="";
		while (ports.hasMoreElements()) {
            portName = ports.nextElement().getName();
            portList.add(portName);
        }
		return portList;
	}
	
	/**
	 * 打开串口
	 * @param portName
	 * @param baudRate
	 * @return
	 * @throws Exception
	 */
	public SerialPort openPort(String portName,int baudRate) throws Exception{
		//通过端口名识别端口
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        //打开端口，并给端口名字和一个timeout（打开操作的超时时间）
        CommPort commPort = portIdentifier.open(portName, openTimeout);
        
        if (!(commPort instanceof SerialPort)) {
        	//不是串口返回null
        	return null;
        }
        
        SerialPort serialPort = (SerialPort) commPort;
        //设置串口波特率
        serialPort.setSerialPortParams(baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        return serialPort;
	}
	
	/**
	 * 关闭串口
	 * @param serialPort
	 */
	public void closePort(SerialPort serialPort){
		if(serialPort!=null){
			serialPort.close();
			serialPort=null;
		}
	}
	
	/**
	 * 发送数据给串口
	 * @param serialPort
	 * @param sendData
	 * @throws Exception
	 */
	public void sendToPort(SerialPort serialPort,byte[] sendData) throws Exception{
		OutputStream out =serialPort.getOutputStream();
		out.write(sendData);
        out.flush();
	}
	
	/**
	 * 读取串口数据
	 * @param serialPort
	 * @return
	 * @throws Exception
	 */
	public byte[] readFromPort(SerialPort serialPort) throws Exception{
		InputStream in= serialPort.getInputStream();
		 byte[] bytes = null;
		int buffLenth = in.available();        //获取buffer里的数据长度
        while (buffLenth != 0) {
        	bytes = new byte[buffLenth];    //初始化byte数组为buffer中数据的长度
            in.read(bytes);
            buffLenth = in.available();
        }
        return bytes;
	}
	
	/**
	 * 16进制字符串转byte数组
	 * @param hexString
	 * @return
	 */
	public byte[] hexToByte(String hexString){
		hexString = hexString.replaceAll(" ", "");
		int len = hexString.length();
		int index = 0;
		byte[] bytes = new byte[len / 2];
		while (index < len) {
			String sub = hexString.substring(index, index + 2);
			bytes[index/2] = (byte)Integer.parseInt(sub,16);
			index += 2;
		}
		return bytes;
		
	}

}
