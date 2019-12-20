package com.vsked.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsked.flink.HttpToolImpl;


public class HttpToolImplTest {
	
	private final Logger log = LoggerFactory.getLogger(HttpToolImplTest.class);
	
//	@Test
	public void get1(){
		try{
			String myUrl="http://localhost:8080/retrofitdemo/proc/test1proc1.jsp";
			String result=HttpToolImpl.get1(myUrl);
			log.debug("|"+result+"|");
		}catch(Exception e){
			log.error(e.getMessage(),e);
		}
	}
	
//	@Test
	public void get2(){
		try{
			Map<String, Object> parMap=new HashMap<String, Object>();
			parMap.put("参数1", "a1");
			parMap.put("b", "b1");
			parMap.put("c", "c1");
			String myUrl="http://localhost:8080/retrofitdemo/proc/test1proc1.jsp";
			String result=HttpToolImpl.get2(myUrl,parMap);
			log.debug("|"+result+"|");
		}catch(Exception e){
			log.error(e.getMessage(),e);
		}
	}
	
//	@Test
	public void post1(){
		try{
			Map<String, Object> parMap=new HashMap<String, Object>();
			parMap.put("post参数1", "a1");
			parMap.put("postb", "参数值b1");
			parMap.put("postc", "c1");
			String myUrl="http://localhost:8080/retrofitdemo/proc/test1proc1.jsp";
			String result=HttpToolImpl.post1(myUrl,parMap);
			log.debug("|"+result+"|");
		}catch(Exception e){
			log.error(e.getMessage(),e);
		}
	}
	
//	@Test
	public void post2(){
		try{
			String myContent="{\"测试key\":\"valkue小二上菜\",\"来啊key\":\"来了\",\"去吧key\":\"听说valkue\"}";
			String myUrl="http://localhost:8080/retrofitdemo/proc/test1proc1.jsp";
			String result=HttpToolImpl.post2(myUrl,myContent);
			log.debug("|"+result+"|");
		}catch(Exception e){
			log.error(e.getMessage(),e);
		}
	}
	
	@Test
	public void post3(){
		try{
			//传文件时需要的参数
			Map<String, Object> parMap=new HashMap<String, Object>();
			parMap.put("test1", "中文测试");
			parMap.put("b", "b1");
			parMap.put("c", "c1");
			
			//文件列表
			List<String> filePathList=new LinkedList<String>();
			filePathList.add("e:/1.jpg");
			filePathList.add("e:/2.jpg");
			filePathList.add("e:/3.jpg");
			filePathList.add("e:/ocr_id_02.jpg");
			String myUrl="http://localhost:8080/retrofitdemo/proc/test1proc1.jsp";
			String result=HttpToolImpl.post3(myUrl,parMap,filePathList);
			log.debug("|"+result+"|");
		}catch(Exception e){
			log.error(e.getMessage(),e);
		}
	}

}
