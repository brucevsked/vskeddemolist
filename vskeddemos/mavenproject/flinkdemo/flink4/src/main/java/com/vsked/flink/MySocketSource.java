package com.vsked.flink;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.apache.flink.util.IOUtils;

public class MySocketSource extends RichSourceFunction<String>{
	
	private final String hostname="10.0.192.33";
	private final int port=64000;
	Socket socket=null ;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void open(Configuration parameters) throws Exception {
		super.open(parameters);
		System.out.println("==================source open44============");
		socket = new Socket(hostname, port);
		socket.setSoTimeout(9000000);

	}
	
	public void cancel() {
		if (socket != null) {
			IOUtils.closeSocket(socket);
		}
		System.out.println("==================source cancel44============");
	}

	public void run(SourceContext<String> ctx) throws Exception {
		System.out.println("==================source run44------------------");
		try {
			Thread.sleep(5000);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = reader.readLine();
			out.println(msg);
			out.flush();
			ctx.collect(msg);
			System.out.println("--------------------|"+msg);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}



}
