package com.vsked.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;


public interface MyService {
	
	@GET("index.jsp")
	Call<ResponseBody> getTest1();
}
