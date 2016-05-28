package com.vsked.myuploadframe;

import java.io.File;
import java.io.FileInputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.vsked.util.ToolHttp;

public class TestOcrA1 {

	public static void main(String[] args) {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
		CloseableHttpClient httpClient = httpClientBuilder.build();  
		System.out.println(analysisPic(httpClient, ""));

	}
	
public static String analysisPic(CloseableHttpClient httpClient,String picData){
		
		String   content="" ;
		String url="http://www.netocr.com/srvc/recognize.srvc?fileapi14644057682896";
		HttpPost httpPost = new HttpPost(url);
		ContentType myContentType = ContentType.create("text/plain", "UTF-8");
		StringBody catalogId = new StringBody("1", myContentType);
		StringBody typeId = new StringBody("2", myContentType);
		StringBody Filename = new StringBody("1.jpg", myContentType);
		try {
		//FileBody files = new FileBody(new File(IDCardUrl));
		InputStreamBody files = new InputStreamBody(new FileInputStream(new File("e:/IDCard.jpg")), "1.jpg");
		
        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addPart("catalogId", catalogId)
                .addPart("typeId", typeId)
                .addPart("_files", Filename)
                .addPart("files", files)
                .build();
        httpPost.setEntity(reqEntity);
        CloseableHttpResponse response;
		
			response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            content  = EntityUtils.toString(entity,"utf-8"); 
            
            System.out.println("内容:\n"+content);
            response.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return content;
	}

}
