package com.custvs.http;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.custvs.common.GlobalSet;
import com.custvs.http.WeChatI;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WeChatITest {
	
	private static final Logger log=LoggerFactory.getLogger(WeChatITest.class);

	@Test
	public void getTokenTest() throws Exception{
		String baseUrl=GlobalSet.weChatBasePath;
		String corpid=GlobalSet.corpId;
		String corpSecret=GlobalSet.corpSecret;
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).build();
		WeChatI service=retrofit.create(WeChatI.class);
		Call<ResponseBody> call=service.getToken(corpid,corpSecret);
		Response<ResponseBody> response=call.execute();
		String responseBody=response.body().string();
		if(log.isDebugEnabled()){
			log.debug(response.isSuccessful()+"");
			log.debug(response.toString());
			log.debug(responseBody);
		}
		
	}

}
