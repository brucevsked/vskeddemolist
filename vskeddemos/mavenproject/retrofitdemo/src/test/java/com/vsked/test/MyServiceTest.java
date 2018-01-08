package com.vsked.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import com.vsked.service.MyService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyServiceTest {
	
	public static void main(String[] args) {
		getTest1();
//		getTest2();
//		getTest3();
//		postTest1();
//		postTest2();
//		postTest3();
//		postTest4();
	}
	
	/**
	 * 无参数get测试
	 */
	public static void getTest1(){
		String baseUrl="http://localhost:8080/retrofitdemo/";
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).build();
		MyService service=retrofit.create(MyService.class);
		Call<ResponseBody> call=service.getTest1();
		call.enqueue(new Callback<ResponseBody>() {
			
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				System.out.println(response.isSuccessful());
				System.out.println(response.toString());
				try {
					System.out.println(response.body().string());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {
				System.out.println(t.getMessage());
			}
		});
		
	}
	
	/**
	 * 固定参数get测试
	 */
	public static void getTest2(){
		String baseUrl="http://localhost:8080/retrofitdemo/";
		String mykey1="thisisfirest";
		String mykey2="hallow2par";
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).build();
		MyService service=retrofit.create(MyService.class);
		Call<ResponseBody> call=service.getTest2(mykey1,mykey2);
		call.enqueue(new Callback<ResponseBody>() {
			
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				System.out.println(response.isSuccessful());
				System.out.println(response.toString());
				try {
					System.out.println(response.body().string());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {
				System.out.println(t.getMessage());
			}
		});
		
	}
	
    /**
     *不固定参数个数get测试 
     */
	public static void getTest3(){
		String baseUrl="http://localhost:8080/retrofitdemo/";
        Map<String, Object> myParMap=new HashMap<String, Object>();
        myParMap.put("a1", "hello");
        myParMap.put("b2", "young");
        myParMap.put("c3", "girl");
        myParMap.put("d4", "youlove");
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).build();
		MyService service=retrofit.create(MyService.class);
		Call<ResponseBody> call=service.getTest3(myParMap);
		call.enqueue(new Callback<ResponseBody>() {
			
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				System.out.println(response.isSuccessful());
				System.out.println(response.toString());
				try {
					System.out.println(response.body().string());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {
				System.out.println(t.getMessage());
			}
		});
		
	}

    /**
     * 固定参数post测试
     */
	public static void postTest1(){
		String baseUrl="http://localhost:8080/retrofitdemo/";
		String userName="admin";
		String userPass="123456";
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).build();
		MyService service=retrofit.create(MyService.class);
		Call<ResponseBody> call=service.postTest1(userName,userPass);
		call.enqueue(new Callback<ResponseBody>() {
			
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				System.out.println(response.isSuccessful());
				System.out.println(response.toString());
				try {
					System.out.println(response.body().string());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {
				System.out.println(t.getMessage());
			}
		});
		
	}
    
	/**
	 * 不固定参数个数post测试
	 */
	public static void postTest2(){
		String baseUrl="http://localhost:8080/retrofitdemo/";
        Map<String, Object> myParMap=new HashMap<String, Object>();
        myParMap.put("a1", "hello");
        myParMap.put("b2", "young");
        myParMap.put("c3", "girl");
        myParMap.put("d4", "youlove");
        myParMap.put("youcan", "seepost");
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).build();
		MyService service=retrofit.create(MyService.class);
		Call<ResponseBody> call=service.postTest2(myParMap);
		call.enqueue(new Callback<ResponseBody>() {
			
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				System.out.println(response.isSuccessful());
				System.out.println(response.toString());
				try {
					System.out.println(response.body().string());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {
				System.out.println(t.getMessage());
			}
		});
		
	}
	
	/**
	 * 单参数，单文件post测试
	 */
	public static void postTest3(){
		String baseUrl="http://localhost:8080/retrofitdemo/";
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).build();
		
		String userNameStr="mynameislost";
		RequestBody userNameReqBody=RequestBody.create(MediaType.parse("multipart/form-data"), userNameStr);
		
		String fpath="e:/2.jpg";
		File f=new File(fpath);
		
		String fileName="myFile";
		RequestBody myFileReqBody=RequestBody.create(MediaType.parse("application/otcet-stream"), f);
		MultipartBody.Part myFileMultiBody=MultipartBody.Part.createFormData(fileName, f.getName(), myFileReqBody);
		
		MyService service=retrofit.create(MyService.class);
		Call<ResponseBody> call=service.postTest3(userNameReqBody,myFileMultiBody);
		call.enqueue(new Callback<ResponseBody>() {
			
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				System.out.println(response.isSuccessful());
				System.out.println(response.toString());
				try {
					System.out.println(response.body().string());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {
				System.out.println(t.getMessage());
			}
		});
		
	}
	
	/**
	 * 不固定参数个数，不固定文件个数post测试
	 */
	public static void postTest4(){
		String baseUrl="http://localhost:8080/retrofitdemo/";
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).build();
		
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
		call.enqueue(new Callback<ResponseBody>() {
			
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				System.out.println(response.isSuccessful());
				System.out.println(response.toString());
				try {
					System.out.println(response.body().string());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {
				System.out.println(t.getMessage());
			}
		});
		
	}
}
