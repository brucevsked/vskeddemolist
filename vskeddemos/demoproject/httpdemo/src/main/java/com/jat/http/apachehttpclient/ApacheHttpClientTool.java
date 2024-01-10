package com.jat.http.apachehttpclient;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicNameValuePair;


public class ApacheHttpClientTool {
	
	
	/**
	 * 请求ContentType为表单形式值
	 */
	private String requestContentTypeForm="application/x-www-form-urlencoded;charset=utf-8";
	
	/**
	 * 请求ContentType为JSON形式值
	 */
	private String requestContentTypeJson="application/json; charset=utf-8";
	
	/**
	 * 默认请求内容编码  默认utf-8编码
	 */
    private String requestContentCharset = "utf-8";
    
    /**
     * 默认响应内容编码 默认utf-8编码
     */
    private String responseContentCharset="utf-8";
	
	public static void main(String[] args) throws Exception {
		testGet();
		testPost();
	}
	
	public static void testGet() throws Exception {
		String getUrl="http://127.0.0.1:8181/testurl";
		ApacheHttpClientTool httpTool=new ApacheHttpClientTool();
		String result="";
		result=httpTool.get(getUrl);
		System.out.println(result);
    	Map<String, String> requestParamterMap=new HashMap<String, String>();
    	requestParamterMap.put("wd", "vsked");
    	requestParamterMap.put("param2", "666");
    	result=httpTool.get(getUrl,requestParamterMap);
    	System.out.println(result);
	}
	
    public static void testPost() throws Exception {
    	String postUrl="http://127.0.0.1:8181/testurl";
		ApacheHttpClientTool httpTool=new ApacheHttpClientTool();
		String result="";
		result=httpTool.post(postUrl);
		System.out.println(result);
    	Map<String, String> requestParamterMap=new HashMap<String, String>();
    	requestParamterMap.put("wd", "vsked");
    	requestParamterMap.put("param2", "666");
    	result=httpTool.post(postUrl,requestParamterMap);
    	System.out.println(result);
    	String testJson="{\"accountname\":\"admin\",\"password\":\"123456\"}";
    	result=httpTool.post(postUrl,testJson);
    	System.out.println(result);
    }
	
	public String getRequestContentTypeForm() {
		return requestContentTypeForm;
	}


	public void setRequestContentTypeForm(String requestContentTypeForm) {
		this.requestContentTypeForm = requestContentTypeForm;
	}
	
    public String getRequestContentCharset() {
		return requestContentCharset;
	}

	public void setRequestContentCharset(String requestContentCharset) {
		this.requestContentCharset = requestContentCharset;
	}
	
	public String getRequestContentTypeJson() {
		return requestContentTypeJson;
	}


	public void setRequestContentTypeJson(String requestContentTypeJson) {
		this.requestContentTypeJson = requestContentTypeJson;
	}
	
	public String get(String requestUrl) throws Exception {
		String responseResult="";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(requestUrl);
		httpGet.setHeader("Content-Type",getRequestContentTypeForm());
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		HttpEntity entity1 = response1.getEntity();
		responseResult=EntityUtils.toString(entity1);
		return responseResult;
	}
	
	public String get(String requestUrl,Map<String, String> requestParamterMap) throws Exception {
		String responseResult="";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		requestUrl=requestUrl+buildQuery(requestParamterMap, true);
		HttpGet httpGet = new HttpGet(requestUrl);
		httpGet.setHeader("Content-Type",getRequestContentTypeForm());
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		HttpEntity entity1 = response1.getEntity();
		responseResult=EntityUtils.toString(entity1);
		return responseResult;
	}
	
	public String post(String requestUrl) throws Exception {
		String responseResult="";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(requestUrl);
		httpPost.setHeader("Content-Type",getRequestContentTypeForm());
		CloseableHttpResponse response1 = httpclient.execute(httpPost);
		HttpEntity entity1 = response1.getEntity();
		responseResult=EntityUtils.toString(entity1);
		return responseResult;
	}
	
	public String post(String requestUrl,Map<String, String> requestParamterMap) throws Exception {
		String responseResult="";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(requestUrl);
		httpPost.setHeader("Content-Type",getRequestContentTypeForm());
		List<NameValuePair> parameterList=parameterMapToList(requestParamterMap);
		httpPost.setEntity(new UrlEncodedFormEntity(parameterList));
		CloseableHttpResponse response1 = httpclient.execute(httpPost);
		HttpEntity entity1 = response1.getEntity();
		responseResult=EntityUtils.toString(entity1);
		return responseResult;
	}
	
	public String post(String requestUrl,String requestJsonContent) throws Exception {
		String responseResult="";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(requestUrl);
		httpPost.setHeader("Content-Type",getRequestContentTypeJson());
		httpPost.setEntity(new StringEntity(requestJsonContent));
		CloseableHttpResponse response1 = httpclient.execute(httpPost);
		HttpEntity entity1 = response1.getEntity();
		responseResult=EntityUtils.toString(entity1);
		return responseResult;
	}
	
	public List<NameValuePair> parameterMapToList(Map<String, String> requestParamterMap){
		List<NameValuePair> parameterList = new ArrayList<NameValuePair>();
		for(Map.Entry<String, String> entry : requestParamterMap.entrySet()){
		    String mapKey = entry.getKey();
		    String mapValue = entry.getValue();
		    parameterList.add(new BasicNameValuePair(mapKey, mapValue));
		}
		return parameterList;
	}
	
    /**
     * 构造请求参数    
     * @param params 参数Map格式为Map<参数名,参数值>
     * @param isGet 是否为get请求，当是get时会在第一个参数前加?
     * @return
     * @throws IOException
     */
    private String buildQuery(Map<String, String> params,boolean isGet) throws Exception {
        if (params == null || params.isEmpty()) {
            return "";
        }

        StringBuilder query = new StringBuilder(isGet?"?":"");
        Set<Map.Entry<String, String>> entries = params.entrySet();
        boolean hasParam = false;

        for (Map.Entry<String, String> entry : entries) {
            String name = entry.getKey();
            String value = entry.getValue();
            if (hasParam) {
                query.append("&");
            } else {
                hasParam = true;
            }
            query.append(name).append("=").append(URLEncoder.encode(value, getRequestContentCharset()));
        }
        return query.toString();
    }

}
