package com.vsked.lesson2;

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
		
		
		while(true){
	    final Socket ck=sk.accept();
		if(ck!=null){
			new Thread(new Runnable() {
				
				public void run() {
					try {
						System.out.println("one man comming......");
						readClientMsg(ck);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	    }
	}

}
