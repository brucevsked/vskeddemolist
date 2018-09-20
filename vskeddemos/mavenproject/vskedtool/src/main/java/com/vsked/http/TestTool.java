package com.vsked.http;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TestTool {
	private static final OkHttpClient client = new OkHttpClient.Builder().
	        connectTimeout(180, TimeUnit.SECONDS).
	        readTimeout(180, TimeUnit.SECONDS).
	        writeTimeout(180, TimeUnit.SECONDS).build();
	
	public static String t1(String reqUrl,Map<String, Object> parMap) throws Exception{
		Retrofit retrofit = new Retrofit.Builder().baseUrl(reqUrl).client(client).build();
		TestHttp service=retrofit.create(TestHttp.class);
		Call<ResponseBody> call=service.t1(parMap);
		Response<ResponseBody> response=call.execute();
		String result="";
		ResponseBody responseBody=response.body();
		if(responseBody!=null){
			result=responseBody.string();
		}
		return result;
	}
}
