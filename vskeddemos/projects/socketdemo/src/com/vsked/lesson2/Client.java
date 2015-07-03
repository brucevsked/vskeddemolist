package com.vsked.lesson2;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.vsked.util.ServerInfo;

public class Client {

	public static void main(String[] args) throws Exception {
		String host=ServerInfo.shost;
		int port=ServerInfo.sport;
		
		Socket c=new Socket(host,port);
		
		DataOutputStream dout=new DataOutputStream(c.getOutputStream());
		
		String info="";
		Scanner sc=new Scanner(System.in);
		
		while(true){
			info=sc.nextLine();
			dout.writeUTF(info);
		}
		
	}

}
