package com.vsked.nio.lesson1;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;

import com.vsked.util.ServerInfo;

public class NServer1 {
	private ByteBuffer bb=ByteBuffer.allocate(8);
	
	private IntBuffer ib=bb.asIntBuffer();
	
	private SocketChannel csc=null;
	
	private ServerSocketChannel ssc=null;
	
	public void start() throws Exception{
		openChannel();
		waitForConnect();
	}
	
	private void openChannel() throws Exception{
		ssc=ServerSocketChannel.open();
		ssc.configureBlocking(false);
		ssc.socket().bind(new InetSocketAddress(ServerInfo.sport));
		System.out.println("server channel has opened");
	}
	
	private void waitForConnect() throws Exception{
		
		Selector acceptSelector = SelectorProvider.provider().openSelector(); 
		SelectionKey acceptKey = ssc.register(acceptSelector, SelectionKey.OP_ACCEPT);
		int keysAdded = 0;

		while((keysAdded = acceptSelector.select()) > 0){
			Set<SelectionKey> readyKeys = acceptSelector.selectedKeys();
			
			Iterator<SelectionKey> it = readyKeys.iterator();
			
			while(it.hasNext()){
				SelectionKey sk=it.next();
				it.remove();
				ServerSocketChannel nextReady=(ServerSocketChannel) sk.channel();
				csc=nextReady.accept();
				System.out.println("one man is comming ");
				processReq();
				csc.close();
			}

		}//end while
		
	}
	
	private void processReq() throws Exception{
		bb.clear();
		
		csc.read(bb);
		
		int rs=ib.get(0)+ib.get(1);
		
		System.out.println("client send_:"+ib.get(0)+"|"+ib.get(1));
		bb.flip();
		bb.clear();
		
		ib.put(0,rs);
		csc.write(bb);
		
	}
	
	public static void main(String[] args) throws Exception {
		new NServer1().start();
	}	
}
