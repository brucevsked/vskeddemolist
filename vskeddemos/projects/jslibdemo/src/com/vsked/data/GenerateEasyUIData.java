package com.vsked.data;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import com.vsked.util.BaseJson;

public class GenerateEasyUIData {
	
	private static GenerateEasyUIData geud=null;
	private String[] columnProperties={"field","title","width","formatter"};
	private String[] columnArray={"userId","userName","userNick","userPass"};
	
	private GenerateEasyUIData(){
	}

	public static GenerateEasyUIData getInstance(){
		return geud==null?new GenerateEasyUIData():geud;
	}
	
	public void proc(HttpServletRequest req,HttpServletResponse res,JspWriter out) throws Exception{
		out.write("{\"total\":2000,\"rows\":"+getBodyData()+",\"columns\":"+getHeadData()+","+getPageInfo(true,1, 15)+"}");
	}
	
	public String getBodyData(){
		List<VskUserT> userList=new LinkedList<VskUserT>();
		for(int i=0;i<20;i++){
			userList.add(new VskUserT(i, "user"+i, "nick"+i));
		}
		String s=BaseJson.listToJson(userList);
		return s; 
	}
	
	public String getGridHead(String... ss){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<ss.length;i++){
			sb.append("-1".equals(ss[i])?"":BaseJson.objectToJson( columnProperties[i])+":"+(BaseJson.objectToJson(ss[i]))+",");
		}
		sb.setLength(sb.length()-1);
		return sb.toString();
	}
	
	public String getHeadData(){
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for(int i=0;i<columnArray.length;i++){
			sb.append("{"+getGridHead(columnArray[i],"CK"+columnArray[i]+"")+"},");
		}
		sb.setLength(sb.length()-1);
		sb.append("]");
		return sb.toString();
	}
	
	public static String getPageInfo(boolean isPage,int st,int pageSize){
		String s="\"pageInfo\": {";
		s+="\"pageSize\":"+ pageSize +",";
		s+="\"currentPage\":"+ st +",";
		s+="\"isMutiSelect\": false,";
		s+="\"gridId\": \"grid1a\",";
		s+="\"isPage\": "+isPage;
		s+="}";
		return s;
	}

}
