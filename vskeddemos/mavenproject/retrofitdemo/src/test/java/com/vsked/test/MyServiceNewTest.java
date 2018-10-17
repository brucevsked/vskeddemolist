package com.vsked.test;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import com.vsked.service.MyService;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

public class MyServiceNewTest {
	
	private final Logger log = LoggerFactory.getLogger(MyServiceNewTest.class);
	
	private static final OkHttpClient client = new OkHttpClient.Builder().
        connectTimeout(180, TimeUnit.SECONDS).
        readTimeout(180, TimeUnit.SECONDS).
        writeTimeout(180, TimeUnit.SECONDS).build();

	
	/**
	 * 无参数get测试
	 */
//	@Test
	public void getTest1() throws Exception{
		String baseUrl="http://localhost:8080/retrofitdemo/";
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(client).build();
		MyService service=retrofit.create(MyService.class);
		Call<ResponseBody> call=service.getTest1();
		Response<ResponseBody> response=call.execute();
		String result="";
		ResponseBody responseBody=response.body();
		if(log.isDebugEnabled()){
			log.debug("|"+response.isSuccessful()+"|");
			log.debug("|"+response.toString()+"|");
		}
		
		if(responseBody!=null){
			result=responseBody.string();
			if(log.isDebugEnabled()){
				log.debug("|"+result+"|");
			}
		}
		log.debug("|"+result+"|");
		
	}
	
	/**
	 * 固定参数get测试
	 */
//	@Test
	public void getTest2()  throws Exception{
		String baseUrl="http://localhost:8080/retrofitdemo/";
		String mykey1="thisisfirest";
		String mykey2="hallow2par";
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(client).build();
		MyService service=retrofit.create(MyService.class);
		Call<ResponseBody> call=service.getTest2(mykey1,mykey2);
		Response<ResponseBody> response=call.execute();
		String result="";
		ResponseBody responseBody=response.body();
		if(log.isDebugEnabled()){
			log.debug("|"+response.isSuccessful()+"|");
			log.debug("|"+response.toString()+"|");
		}
		
		if(responseBody!=null){
			result=responseBody.string();
			if(log.isDebugEnabled()){
				log.debug("|"+result+"|");
			}
		}
		log.debug("|"+result+"|");
		
	}
	
    /**
     *不固定参数个数get测试 
     */
//	@Test
	public void getTest3()  throws Exception{
		String baseUrl="http://localhost:8080/retrofitdemo/";
        Map<String, Object> myParMap=new HashMap<String, Object>();
        myParMap.put("a1", "hello");
        myParMap.put("b2", "young");
        myParMap.put("c3", "girl");
        myParMap.put("d4", "youlove");
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(client).build();
		MyService service=retrofit.create(MyService.class);
		Call<ResponseBody> call=service.getTest3(myParMap);
		Response<ResponseBody> response=call.execute();
		String result="";
		ResponseBody responseBody=response.body();
		if(log.isDebugEnabled()){
			log.debug("|"+response.isSuccessful()+"|");
			log.debug("|"+response.toString()+"|");
		}
		
		if(responseBody!=null){
			result=responseBody.string();
			if(log.isDebugEnabled()){
				log.debug("|"+result+"|");
			}
		}
		log.debug("|"+result+"|");
		
	}

    /**
     * 固定参数post测试
     */
//	@Test
	public void postTest1()  throws Exception{
		String baseUrl="http://localhost:8080/retrofitdemo/";
		String userName="admin";
		String userPass="123456";
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(client).build();
		MyService service=retrofit.create(MyService.class);
		Call<ResponseBody> call=service.postTest1(userName,userPass);
		Response<ResponseBody> response=call.execute();
		String result="";
		ResponseBody responseBody=response.body();
		if(log.isDebugEnabled()){
			log.debug("|"+response.isSuccessful()+"|");
			log.debug("|"+response.toString()+"|");
		}
		
		if(responseBody!=null){
			result=responseBody.string();
			if(log.isDebugEnabled()){
				log.debug("|"+result+"|");
			}
		}
		log.debug("|"+result+"|");
		
	}
    
	/**
	 * 不固定参数个数post测试
	 */
//	@Test
	public void postTest2()  throws Exception{
		String baseUrl="http://localhost:8080/retrofitdemo/";
        Map<String, Object> myParMap=new HashMap<String, Object>();
        myParMap.put("a1", "hello");
        myParMap.put("b2", "young");
        myParMap.put("c3", "girl");
        myParMap.put("d4", "youlove");
        myParMap.put("youcan", "seepost");
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(client).build();
		MyService service=retrofit.create(MyService.class);
		Call<ResponseBody> call=service.postTest2(myParMap);
		Response<ResponseBody> response=call.execute();
		String result="";
		ResponseBody responseBody=response.body();
		if(log.isDebugEnabled()){
			log.debug("|"+response.isSuccessful()+"|");
			log.debug("|"+response.toString()+"|");
		}
		
		if(responseBody!=null){
			result=responseBody.string();
			if(log.isDebugEnabled()){
				log.debug("|"+result+"|");
			}
		}
		log.debug("|"+result+"|");
		
	}
	
	/**
	 * 不固定参数个数post测试
	 */
//	@Test
	public void postTest21()  throws Exception{
		String baseUrl="http://localhost:8080/retrofitdemo/";
        Map<String, Object> myParMap=new HashMap<String, Object>();
        myParMap.put("a1", "6666");
        myParMap.put("b2", "young666");
        myParMap.put("c3", "girl666");
        myParMap.put("d4", "youlove666");
        myParMap.put("youcan", "seepost66");
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(client).build();
		MyService service=retrofit.create(MyService.class);
		String tvid="test1proc1.jsp";
		Call<ResponseBody> call=service.postTest21(tvid,myParMap);
		Response<ResponseBody> response=call.execute();
		String result="";
		ResponseBody responseBody=response.body();
		if(log.isDebugEnabled()){
			log.debug("|"+response.isSuccessful()+"|");
			log.debug("|"+response.toString()+"|");
		}
		
		if(responseBody!=null){
			result=responseBody.string();
			if(log.isDebugEnabled()){
				log.debug("|"+result+"|");
			}
		}
		log.debug("|"+result+"|");
		
	}
	
	/**
	 * 不固定参数个数post测试
	 */
//	@Test
	public void postTest22()  throws Exception{
		String baseUrl="http://localhost:8080/retrofitdemo/";
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(client).build();
		MyService service=retrofit.create(MyService.class);
		String myContent="{\"key\":\"valkue\"}";
		RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),myContent);
		Call<ResponseBody> call=service.postTest22(body);
		Response<ResponseBody> response=call.execute();
		String result="";
		ResponseBody responseBody=response.body();
		if(log.isDebugEnabled()){
			log.debug("|"+response.isSuccessful()+"|");
			log.debug("|"+response.toString()+"|");
		}
		
		if(responseBody!=null){
			result=responseBody.string();
			if(log.isDebugEnabled()){
				log.debug("|"+result+"|");
			}
		}
		log.debug("|"+result+"|");
		
	}
	
	/**
	 * 不固定参数个数post测试
	 */
	@Test
	public void postTest23()  throws Exception{
		String baseUrl="http://localhost:8080/retrofitdemo/";
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(client).build();
		MyService service=retrofit.create(MyService.class);
		String myContent="{\"key\":\"valkue\",\"name\":\"vsked\",\"id\":\"3701\"}";
		String tvid="test1proc1.jsp";
		RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),myContent);
		Call<ResponseBody> call=service.postTest23(tvid,body);
		Response<ResponseBody> response=call.execute();
		String result="";
		ResponseBody responseBody=response.body();
		if(log.isDebugEnabled()){
			log.debug("|"+response.isSuccessful()+"|");
			log.debug("|"+response.toString()+"|");
		}
		
		if(responseBody!=null){
			result=responseBody.string();
			if(log.isDebugEnabled()){
				log.debug("|"+result+"|");
			}
		}
		log.debug("|"+result+"|");
		
	}
	
	/**
	 * 单参数，单文件post测试
	 */
//	@Test
	public void postTest3()  throws Exception{
		String baseUrl="http://localhost:8080/retrofitdemo/";
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(client).build();
		
		String userNameStr="mynameislost";
		RequestBody userNameReqBody=RequestBody.create(MediaType.parse("multipart/form-data"), userNameStr);
		
		String fpath="e:/2.jpg";
		File f=new File(fpath);
		
		String fileName="myFile";
		RequestBody myFileReqBody=RequestBody.create(MediaType.parse("application/otcet-stream"), f);
		MultipartBody.Part myFileMultiBody=MultipartBody.Part.createFormData(fileName, f.getName(), myFileReqBody);
		
		MyService service=retrofit.create(MyService.class);
		Call<ResponseBody> call=service.postTest3(userNameReqBody,myFileMultiBody);
		Response<ResponseBody> response=call.execute();
		String result="";
		ResponseBody responseBody=response.body();
		if(log.isDebugEnabled()){
			log.debug("|"+response.isSuccessful()+"|");
			log.debug("|"+response.toString()+"|");
		}
		
		if(responseBody!=null){
			result=responseBody.string();
			if(log.isDebugEnabled()){
				log.debug("|"+result+"|");
			}
		}
		log.debug("|"+result+"|");
		
	}
	
	/**
	 * 不固定参数个数，不固定文件个数post测试
	 */
//	@Test
	public void postTest4()  throws Exception{
		String baseUrl="http://localhost:8080/retrofitdemo/";
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(client).build();
		
        Map<String, RequestBody> myParMap=new HashMap<String, RequestBody>();
        
		String userNameStr="mynameislost";
		RequestBody userNameReqBody=RequestBody.create(MediaType.parse("multipart/form-data"), userNameStr);
		
        myParMap.put("a1", userNameReqBody);
        
		String userPassStr="mypassisbed";
		RequestBody userPassReqBody=RequestBody.create(MediaType.parse("multipart/form-data"), userPassStr);
        myParMap.put("b2", userPassReqBody);
        
		List<MultipartBody.Part> partList = new LinkedList<MultipartBody.Part>();
		
		String fpath1="e:/ocr_id_01.jpg";
		File f1=new File(fpath1);
		
		String fileName1="myFile1";
		RequestBody myFileReqBody1=RequestBody.create(MediaType.parse("application/otcet-stream"), f1);
		MultipartBody.Part part1=MultipartBody.Part.createFormData(fileName1, f1.getName(), myFileReqBody1);
		partList.add(part1);
		
		String fpath2="e:/ocr_id_02.jpg";
		File f2=new File(fpath2);
		
		String fileName2="myFile2";
		RequestBody myFileReqBody2=RequestBody.create(MediaType.parse("application/otcet-stream"), f2);
		MultipartBody.Part part2=MultipartBody.Part.createFormData(fileName2, f2.getName(), myFileReqBody2);
		partList.add(part2);
		
		MyService service=retrofit.create(MyService.class);
		Call<ResponseBody> call=service.postTest4(myParMap,partList);
		Response<ResponseBody> response=call.execute();
		String result="";
		ResponseBody responseBody=response.body();
		if(log.isDebugEnabled()){
			log.debug("|"+response.isSuccessful()+"|");
			log.debug("|"+response.toString()+"|");
		}
		
		if(responseBody!=null){
			result=responseBody.string();
			if(log.isDebugEnabled()){
				log.debug("|"+result+"|");
			}
		}
		log.debug("|"+result+"|");
		
	}
}
