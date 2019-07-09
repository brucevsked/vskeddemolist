package com.server.apitest;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyTest1ServiceImpl {

	private final Logger log = LoggerFactory.getLogger(MyTest1ServiceImpl.class);

	private static final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(180, TimeUnit.SECONDS)
			.readTimeout(180, TimeUnit.SECONDS).writeTimeout(180, TimeUnit.SECONDS).build();

	public String appmodulelist() {
		String result = "";
		try {
			String baseUrl = "http://localhost:9010";
			String type = "1";
			Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(client).build();
			MyTest1Service service = retrofit.create(MyTest1Service.class);
			Call<ResponseBody> call = service.appmodulelist(type);
			Response<ResponseBody> response = call.execute();

			ResponseBody responseBody = response.body();

			if (responseBody != null) {
				result = responseBody.string();
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		//log.info("|"+result+"|");
		return result;
	}
	
	public String appnotice() {
		String result = "";
		try {
			String baseUrl = "http://localhost:9010";
			Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(client).build();
			MyTest1Service service = retrofit.create(MyTest1Service.class);
			Call<ResponseBody> call = service.appnotice("1");
			Response<ResponseBody> response = call.execute();

			ResponseBody responseBody = response.body();

			if (responseBody != null) {
				result = responseBody.string();
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		//log.info("|"+result+"|");
		return result;
	}

}
