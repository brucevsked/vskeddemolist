package com.vsked.flink;

import java.util.Properties;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestFlink3 {
	
	private static final Logger log = LoggerFactory.getLogger(TestFlink3.class);

	public static void main(String[] args) {
		log.debug("start flink3");
		try{
		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		env.enableCheckpointing(5000);//非常关键，一定要设置启动检查点!!
		env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
		
		Properties props = new Properties();
        props.setProperty("bootstrap.servers", "192.168.111.95:9092,192.168.111.96:9092,192.168.111.97:9092");
        props.setProperty("group.id", "flink-group");
        
        String topicName="testFlink";
        FlinkKafkaConsumer<String> consumer =  new FlinkKafkaConsumer<String>(topicName, new SimpleStringSchema(), props);
        consumer.setStartFromEarliest();     // start from the earliest record possible
        //consumer.setStartFromLatest();       // start from the latest record
        //consumer.setStartFromTimestamp(...); // start from specified epoch timestamp (milliseconds)
        //consumer.setStartFromGroupOffsets(); // the default behaviour
        
        
        DataStream<String> stream = env.addSource(consumer);
        
        //计算数据
        DataStream<Tuple2<String, Integer>> windowCount = stream.flatMap(new LineSplitter()).keyBy(0).sum(1);
        //把数据打印到控制台
        windowCount.print();
        //注意：因为flink是懒加载的，所以必须调用execute方法，上面的代码才会执行
        env.execute("streaming word count");
		}catch(Exception e){
			log.error(e.getMessage(),e);
			log.error("error=========================");
		}
		log.debug("end flink3");

	}

}
