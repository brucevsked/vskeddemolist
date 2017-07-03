package com.vsked.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.apache.log4j.Logger;
import org.junit.Test;

public class MyOkHttpImageGetTest extends BaseTest {

	private static Logger log = Logger.getLogger(MyOkHttpImageGetTest.class);

	@Test
	public void getTest1() {
		String picUrl = "http://www.ipyy.com/Test/ValidCode?id=Mon%20Jul%2003%202017%2015:03:14%20GMT+0800%20(China%20Standard%20Time)";
		try {
			OkHttpClient okHttpClient = new OkHttpClient();
			Request request = new Request.Builder().get().url(picUrl).build();
			Call call = okHttpClient.newCall(request);
			Response response = call.execute();
			// 将响应数据转化为输入流数据
			InputStream inputStream = response.body().byteStream();
			File file = new File("d:/t1e2.jpg");
			writeFile(inputStream, file);
			log.debug("write ok");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	public static void writeFile(InputStream ins, File file) {
		try {
			OutputStream os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			ins.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

}
