package com.jat.http.jdk;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

/**
 * JDK自带HTTP请求发送类封装
 * @author vsked
 *
 */
public class JDKHttpTool {
	
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
    
    /**
     * 连接超时设置 默认15000
     */
    private static final int connectTimeout=15000;
    
    private static final int readTimeout=15000;
    
    
    
    public static void main(String[] args) throws Exception {
    	testGet();
    	testPost();
	}
    
    public static void testGet() throws Exception {
    	String getUrl="http://127.0.0.1:8181/testurl";
    	JDKHttpTool httpTool=new JDKHttpTool();
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
    	JDKHttpTool httpTool=new JDKHttpTool();
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
    
	
    public String getRequestContentCharset() {
		return requestContentCharset;
	}

	public void setRequestContentCharset(String requestContentCharset) {
		this.requestContentCharset = requestContentCharset;
	}



	public String getResponseContentCharset() {
		return responseContentCharset;
	}



	public void setResponseContentCharset(String responseContentCharset) {
		this.responseContentCharset = responseContentCharset;
	}



	public static int getConnecttimeout() {
		return connectTimeout;
	}


	public static int getReadtimeout() {
		return readTimeout;
	}


	public String getRequestContentTypeForm() {
		return requestContentTypeForm;
	}


	public void setRequestContentTypeForm(String requestContentTypeForm) {
		this.requestContentTypeForm = requestContentTypeForm;
	}


	public String getRequestContentTypeJson() {
		return requestContentTypeJson;
	}


	public void setRequestContentTypeJson(String requestContentTypeJson) {
		this.requestContentTypeJson = requestContentTypeJson;
	}


	public String get(String url) throws Exception {
    	return sendRequest("GET", url, "", getConnecttimeout(), getReadtimeout(), getRequestContentTypeForm(), null);
    }
	
	public String get(String url,Map<String, String> requestParamterMap) throws Exception {
    	return sendRequest("GET", url+buildQuery(requestParamterMap,true), "", getConnecttimeout(), getReadtimeout(), getRequestContentTypeForm(), null);
    }
	
	public String post(String url) throws Exception {
    	return sendRequest("POST", url, "", getConnecttimeout(), getReadtimeout(), getRequestContentTypeForm(), null);
    }
	
	public String post(String url,Map<String, String> requestParamterMap) throws Exception {
    	return sendRequest("POST", url, buildQuery(requestParamterMap,false), getConnecttimeout(), getReadtimeout(), getRequestContentTypeForm(), null);
    }
	
	public String post(String url,String requestJsonContent) throws Exception {
    	return sendRequest("POST", url, requestJsonContent, getConnecttimeout(), getReadtimeout(), getRequestContentTypeJson(), null);
    }

	private String sendRequest(String method, String url, String requestContent,
			int connectTimeout, int readTimeout, String requestContentType,Map<String, String> headerMap) 
					throws Exception {
		System.out.println(url);
        HttpURLConnection conn = null;
        OutputStream out = null;
        String rsp = null;
        try {
            conn = getConnection(new URL(url), method, requestContentType, headerMap);
            conn.setConnectTimeout(connectTimeout);
            conn.setReadTimeout(readTimeout);

            if(requestContent != null && requestContent.trim().length() >0){
                out = conn.getOutputStream();
                out.write(requestContent.getBytes(getRequestContentCharset()));
            }

            rsp = getResponseAsString(conn);
        } finally {
            if (out != null) {
                out.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
            conn = null;
        }
        return rsp;
    }
    
    private HttpURLConnection getConnection(URL requestUrl, String method,String contentType, Map<String, String> headerMap) throws Exception {
        HttpURLConnection conn;
        if ("https".equals(requestUrl.getProtocol())) {
            SSLContext ctx;
            try {
                ctx = SSLContext.getInstance("TLS");
                ctx.init(new KeyManager[0],
                        new TrustManager[] { new DefaultTrustManager() },
                        new SecureRandom());
            } catch (Exception e) {
                throw new Exception(e);
            }
            HttpsURLConnection connHttps = (HttpsURLConnection) requestUrl.openConnection();
            connHttps.setSSLSocketFactory(ctx.getSocketFactory());
            connHttps.setHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            conn = connHttps;
        } else {
            conn = (HttpURLConnection) requestUrl.openConnection();
        }
        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Accept","text/xml,text/javascript,text/html,application/json");
        conn.setRequestProperty("Content-Type", contentType);
        if (headerMap != null) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            	conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        return conn;
    }
	
    private String getResponseAsString(HttpURLConnection conn) throws Exception {
        InputStream errorStream = conn.getErrorStream();
        if (errorStream == null) {
            return getStreamAsString(conn.getInputStream(), getResponseContentCharset(), conn);
        } else {
            String responseResult = getStreamAsString(errorStream, getResponseContentCharset(), conn);
            if (responseResult != null && responseResult.trim().length() >0) {
                throw new Exception(conn.getResponseCode() + ":" + conn.getResponseMessage());
            } else {
                return responseResult;
            }
        }
    }

    private String getStreamAsString(InputStream stream, String responseContentCharset,HttpURLConnection conn) throws Exception {
        try {
            Reader reader = new InputStreamReader(stream, responseContentCharset);

            StringBuilder response = new StringBuilder();
            final char[] buff = new char[1024];
            int read = 0;
            while ((read = reader.read(buff)) > 0) {
                response.append(buff, 0, read);
            }

            return response.toString();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
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
