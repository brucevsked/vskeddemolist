package com.vsked.common;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface HttpToolInterface {
	
	@GET
	Call<ResponseBody> get1(@Url String myUrl);
	
	@GET
	Call<ResponseBody> get2(@Url String myUrl,@QueryMap Map<String, Object> parMap);
	
	@POST
	@FormUrlEncoded
	@Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8") //修正请求乱码
	Call<ResponseBody> post1(@Url String myUrl,@FieldMap Map<String, Object> parMap);
	
	@POST
	@Headers ({"Content-Type: application/json; charset=utf-8","Accept: application/json"}) //修正请求乱码
	Call<ResponseBody> post2(@Url String myUrl,@Body RequestBody info);

	@POST
	@Multipart
	Call<ResponseBody> post3(@Url String myUrl,@PartMap() Map<String, RequestBody>  parMap, @Part List<MultipartBody.Part> myFileList);
	
	
}
