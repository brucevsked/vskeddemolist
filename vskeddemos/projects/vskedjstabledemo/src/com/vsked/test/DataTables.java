package com.vsked.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.vsked.common.BaseController;
import com.vsked.common.LogUtil;

public class DataTables {
	
	public static String getData(HttpServletRequest req){
		System.out.println(req.getRequestURI());
		Map<String, String> m=BaseController.getMaps(req);
		System.out.println(m);
		//TODO commont here
//		LogUtil.outPutBasicMap(m);
		
		StringBuilder sb=new StringBuilder();
		
//		System.out.println("-----"+m.get("start"));
//		System.out.println("-----"+m.get("draw"));
//		System.out.println("-----"+m.get("length"));
		
		int startIndex=Integer.parseInt(m.get("start"));
		int endIndex=startIndex+Integer.parseInt(m.get("length"));
		sb.append("{");
		sb.append("\"draw\": "+m.get("draw")+",");
		sb.append("\"recordsTotal\": 257,");
		sb.append("\"recordsFiltered\": 257,");
		sb.append("\"data\":[");
		for(int i=startIndex;i<endIndex;i++)
		sb.append("[\""+i+"\",\"Cedric"+i+"\",\"Kellya\",\"Senior Javascript Developer\",\"Edinburgh\",\"29th Mar 12\",\"$433,060\",\"\"],");
		sb.setLength(sb.length()-1);
		sb.append("]");
		sb.append("}");
//		System.out.println(sb.toString());
		return sb.toString();
	}

}
