package com.vsked.nio.lesson1;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SocketChannel;

import com.vsked.util.ServerInfo;

public class NClient1 {
	
	private ByteBuffer bb=ByteBuffer.allocate(8);
	
	private IntBuffer ib=null;
	
	private SocketChannel csc=null;
	
	public NClient1(){
		ib=bb.asIntBuffer();
	}
	
	public int getSum(int a,int b) throws Exception{
		int rs=0;
		csc=connect();
		csc.configureBlocking(false);
		sendReq(a,b);
		rs=getRs();
		csc.close();
		return rs;
	}
	
	private SocketChannel connect() throws Exception{
		InetSocketAddress saddress=new InetSocketAddress(ServerInfo.shost,ServerInfo.sport);
		return SocketChannel.open(saddress);
	}
	
	private void sendReq(int a,int b) throws Exception{
		bb.clear();
		ib.put(0,a);
		ib.put(1,b);
		csc.write(bb);
		System.out.println("client send:"+a+"+"+b);
	}
	
	private int getRs() throws Exception{
		bb.clear();
		csc.read(bb);
		return ib.get(0);
	}

	public static void main(String[] args) throws Exception{
		
		NClient1 nc=new NClient1();
		int a=20;
		int b=20;
		System.out.println("rs:"+nc.getSum(a, b));

	}

}
