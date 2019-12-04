package com.vsked.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

public class TestFlink1 {

	 public static void main(String[] args) throws Exception {
	        //定义socket的端口号
	        int port;
	        try{
	            ParameterTool parameterTool = ParameterTool.fromArgs(args);
	            port = parameterTool.getInt("port");
	        }catch (Exception e){
	            System.err.println("没有指定port参数，使用默认值9000");
	            port = 9000;
	        }

	        //获取运行环境
	        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

	        //连接socket获取输入的数据
	        DataStreamSource<String> text = env.socketTextStream("10.0.192.31", port, "\n");

	        //计算数据
	        DataStream<WordWithCount> windowCount = text.flatMap(new FlatMapFunction<String, WordWithCount>() {
	            public void flatMap(String value, Collector<WordWithCount> out) throws Exception {
	                String[] splits = value.split("\\s");
	                for (String word:splits) {
	                    out.collect(new WordWithCount(word,1L));
	                }
	            }
	        })//打平操作，把每行的单词转为<word,count>类型的数据
	                .keyBy("word")//针对相同的word数据进行分组
	                .timeWindow(Time.seconds(2),Time.seconds(1))//指定计算数据的窗口大小和滑动窗口大小
	                .sum("count");
	               
	        //把数据打印到控制台
	        windowCount.print()
	                .setParallelism(1);//使用一个并行度
	        //注意：因为flink是懒加载的，所以必须调用execute方法，上面的代码才会执行
	        env.execute("streaming word count");

	    }

	    /**
	     * 主要为了存储单词以及单词出现的次数
	     */
	    public static class WordWithCount{
	        public String word;
	        public long count;
	        public WordWithCount(){}
	        public WordWithCount(String word, long count) {
	            this.word = word;
	            this.count = count;
	        }

	        @Override
	        public String toString() {
	            return "WordWithCount{" +
	                    "word='" + word + '\'' +
	                    ", count=" + count +
	                    '}';
	        }
	    }


}
