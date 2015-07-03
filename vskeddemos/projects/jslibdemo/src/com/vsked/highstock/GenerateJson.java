package com.vsked.highstock;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

public class GenerateJson {
	private static GenerateJson gj=null;
	
	private GenerateJson(JspWriter out,HttpServletRequest req) throws Exception{
		System.out.print("fft");
		out.write("{\"name\":11}");
	}
	
	public String getSinglePointData(String x,String y){
		return "";		
	}
	
	public static GenerateJson getInstance(JspWriter jw,HttpServletRequest req) throws Exception{
		return gj==null?new GenerateJson(jw,req):gj;
	}

}
