package com.server.apitest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MyTest1Service {
	
	@FormUrlEncoded
	@POST("api/v1/appmodulelist")
	Call<ResponseBody> appmodulelist(@Field("type") String type);
	
	@FormUrlEncoded
	@POST("api/v1/appnotice")
	Call<ResponseBody> appnotice(@Field("type") String type);

}
