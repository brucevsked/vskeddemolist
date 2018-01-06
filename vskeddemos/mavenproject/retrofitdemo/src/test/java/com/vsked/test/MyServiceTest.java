package com.vsked.test;

import java.io.IOException;
import okhttp3.ResponseBody;
import com.vsked.service.MyService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyServiceTest {
	
	public static void main(String[] args) {
		getTest();
	}
	
	public static void getTest(){
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
	
}
