package com.custvs.http;

import com.custvs.common.GlobalSet;

import retrofit2.http.GET;
import retrofit2.http.Query;
import okhttp3.ResponseBody;
import retrofit2.Call;

public interface WeChatI {
	
	@GET(GlobalSet.getTokenUrl) //这里的mykey相当于test1proc1.jsp?mykey=xxx
	Call<ResponseBody> getToken(@Query("corpid") String corpid,@Query("corpsecret") String corpsecret);

}
