package com.vsked.http;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TestHttp {
	
	@FormUrlEncoded
	@POST("lotteryman1/MachineI/getDataV1.html")
	Call<ResponseBody> t1(@FieldMap Map<String, Object> parMap);
}
