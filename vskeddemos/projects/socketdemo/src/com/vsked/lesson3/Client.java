package com.vsked.lesson3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

import com.vsked.util.ServerInfo;

public class Client {

	public static void main(String[] args) throws Exception {
		String host=ServerInfo.shost;
		int port=ServerInfo.sport;
		
		Socket c=new Socket(host,port);
		
		DataOutputStream dout=new DataOutputStream(c.getOutputStream());
		
		BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
		
		String info="";
		Scanner sc=new Scanner(System.in);
		
		while(true){
			info=sc.nextLine();
			dout.writeUTF(info);
			System.out.println(in.readLine());
		}
		
	}

}
