package com.vsked.service;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


public interface MyService {
	
	@GET("index.jsp")
	Call<ResponseBody> getTest1();
	
	@GET("proc/test1proc1.jsp") //这里的mykey相当于test1proc1.jsp?mykey=xxx
	Call<ResponseBody> getTest2(@Query("mykey1") String mykey1,@Query("mykey2") String mykey2);
	
	@GET("proc/test1proc1.jsp") //这里的parMap相当于test1proc1.jsp?多个动态参数个数不固定
	Call<ResponseBody> getTest3(@QueryMap Map<String, Object> parMap);
	
	@FormUrlEncoded
	@POST("proc/test1proc1.jsp")
	Call<ResponseBody> postTest1(@Field("userName") String userName,@Field("userPass") String userPass);
	
	@FormUrlEncoded
	@POST("proc/test1proc1.jsp")
	Call<ResponseBody> postTest2(@FieldMap Map<String, Object> parMap);
	
	@FormUrlEncoded
	@POST("proc/{tvid}")
	Call<ResponseBody> postTest21(@Path("tvid") String tvid, @FieldMap Map<String, Object> parMap);
	
	@Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
	@POST("proc/test1proc1.jsp")
	Call<ResponseBody> postTest22(@Body RequestBody info);
	
	@Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
	@POST("proc/{tvid}")
	Call<ResponseBody> postTest23(@Path("tvid") String tvid,@Body RequestBody info);
	
	@Multipart
	@POST("proc/test1proc1.jsp")
	Call<ResponseBody> postTest3(@Part("userName") RequestBody userName,@Part MultipartBody.Part myFile);
	
	@Multipart
	@POST("proc/test1proc1.jsp")
	Call<ResponseBody> postTest4(@PartMap() Map<String, RequestBody>  parmap, @Part List<MultipartBody.Part> myFileList);

}
