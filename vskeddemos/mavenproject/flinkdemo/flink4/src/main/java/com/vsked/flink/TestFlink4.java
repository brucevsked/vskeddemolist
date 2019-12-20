package com.vsked.flink;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestFlink4 {
	private static final Logger log = LoggerFactory.getLogger(TestFlink4.class);
	public static void main(String[] args) {
		log.debug("start flink4");
		try{
		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		env.enableCheckpointing(5000);//非常关键，一定要设置启动检查点!!
		env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
		
		MySocketSource mySocketSource=new MySocketSource();//自定义source数据源
        
        
        DataStream<String> stream = env.addSource(mySocketSource);
        
        //计算数据
        DataStream<Tuple2<String, Integer>> windowCount = stream.flatMap(new LineSplitter()).keyBy(0).sum(1);
        windowCount.addSink(new HttpSink());//自定义sink计算结果转发
        //注意：因为flink是懒加载的，所以必须调用execute方法，上面的代码才会执行
        env.execute("streaming word count");
		}catch(Exception e){
			log.error(e.getMessage(),e);
			log.error("error=========================");
		}
		log.debug("end flink3");

	}

}
