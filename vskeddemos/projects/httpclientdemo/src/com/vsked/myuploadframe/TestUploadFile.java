package com.vsked.myuploadframe;

import java.io.File;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestUploadFile {
	
	public static void main(String[] args) throws Exception {
		String receveUrl="http://localhost:8080/commonfileuploaddemo/recevedemo1.jsp";
		String fPath="c:/2.jpg";
		String targetURL = receveUrl ;
		HttpPost  request = new HttpPost(targetURL);
		HttpClient httpClient=HttpClients.createDefault();
		MultipartEntityBuilder meb=MultipartEntityBuilder.create();
		meb.addTextBody("uname", "admin");
		meb.addBinaryBody("f1", new File(fPath));
		request.setEntity(meb.build());
		HttpResponse response = httpClient.execute(request);
		HttpEntity entity = response.getEntity();
		// 打印响应信息
		System.out.println(response.getStatusLine());
		System.out.println(EntityUtils.toString(entity));
	}
	

	

}
