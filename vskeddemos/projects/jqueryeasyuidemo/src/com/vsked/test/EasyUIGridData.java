package com.vsked.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.vsked.common.BaseController;
import com.vsked.common.LogUtil;

public class EasyUIGridData {

	public static void main(String[] args) {

	}
	
	public static String getData(HttpServletRequest req){
		String tbData="";
		LogUtil.outPutObject(BaseController.getMaps(req));
		int curPage=req.getParameter("page")==null?1:Integer.parseInt(req.getParameter("page"));
		int rows=req.getParameter("rows")==null?1:Integer.parseInt(req.getParameter("rows"));
		StringBuilder sb=new StringBuilder();
		int total=500;
		
		sb.append("{"+getKey("total")+":"+total+",");
		sb.append(""+getKey("rows")+":"+"[");
		for(int i=(curPage-1)*rows;i<curPage*rows;i++){
		sb.append("{"+getKey("a1")+":"+getKey("ssa"+i)+","+getKey("a2")+":"+getKey("ssv"+i)+","+getKey("a3")+":"+getKey("ssc"+i)+","+getKey("a4")+":"+getKey("ssx"+i)+"},");
		}
		sb.setLength(sb.length()-1);
		sb.append("]");
		sb.append("}");
		
		tbData=sb.toString();
		return tbData;
	}
	
	
	public static String getKey(String s){
		return "\""+s+"\"";
	}

}
