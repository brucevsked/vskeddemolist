package com.vsked.flink;

import java.util.HashMap;
import java.util.Map;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;

import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

public class HttpSink extends RichSinkFunction<Tuple2<String, Integer>>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void open(Configuration parameters) throws Exception {
		System.out.println("==================open11============");
	}
	public void close() throws Exception {
		System.out.println("==================close============");
	}
	
	public void invoke(Tuple2<String, Integer> value) throws Exception {
		System.out.println("result:"+value);
		Map<String, Object> parMap=new HashMap<String, Object>();
		parMap.put("result", value);
		String myUrl="http://10.0.192.1:8080/retrofitdemo/proc/test1proc1.jsp";
		String result=HttpToolImpl.post1(myUrl,parMap);
		System.out.println(result);
		//在这里通过http接口发送给服务端
		//服务端收到数据以后把消息送到websocket
	}

}
