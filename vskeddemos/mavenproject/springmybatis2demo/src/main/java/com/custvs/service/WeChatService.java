package com.custvs.service;

import java.util.Map;

import okhttp3.ResponseBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import com.custvs.common.GlobalSet;
import com.custvs.common.StringTool;
import com.custvs.http.WeChatI;

@Service
@Transactional
public class WeChatService extends BaseService{
	
	private static final Logger log=LoggerFactory.getLogger(WeChatService.class);
	
	/**
	 * 获取accesstoken
	 * @return
	 * @throws Exception
	 */
	public String getAccessToken() throws Exception{
		String access_token="";
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
		
		Map<String, Object> m=StringTool.jsonToMap(responseBody);
		if(m.containsKey("errcode") && m.get("errcode").toString().equals("0")){
			access_token=m.get("access_token").toString();
		}

		return access_token;
	}

}
