package com.vsked.response;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

public class MyResponse {
	
	public static String postResponse(HttpServletRequest req){
		String result="";
		try{
		System.out.println("request method is|"+req.getMethod());
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(req.getInputStream()));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        result=sb.toString();
        System.out.println(result);
        reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}


}
