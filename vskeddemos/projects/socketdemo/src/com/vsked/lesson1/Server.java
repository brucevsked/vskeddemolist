package com.vsked.lesson1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.vsked.util.ServerInfo;

public class Server {
	
	public static void sendMsg(Socket ck) throws Exception {
		DataOutputStream dout=new DataOutputStream(ck.getOutputStream());
		dout.writeUTF("server send to client I am fine");
	}
	
	public static void readClientMsg(Socket ck) throws Exception {
		DataInputStream din = new DataInputStream(ck.getInputStream());
			String inString;
			while(!(inString=din.readUTF()).equals("") && !inString.equals("exit")){
				System.out.println("client send:"+inString);
			}
			System.out.println("program has exit..............");
	}
	
	public static void main(String[] args) throws Exception {
		
		int port=ServerInfo.sport;
		
		System.out.println("server has start....");
		ServerSocket sk=new ServerSocket(port);
		
		Socket ck=null;
		
		ck=sk.accept();
		System.out.println(ck);
		if(ck!=null){
			System.out.println("one man comming......");
			sendMsg(ck);
			readClientMsg(ck);
		}
		
	}

}
