package com.vsked.data;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import com.vsked.util.BaseJson;
import com.vsked.util.BasicServlet;
import com.vsked.util.LogUtil;

public class GenerateGridXData {
	
	private static GenerateGridXData geud=null;
	private String[] columnProperties={"id","field","name","width","isHidden","url","sortable"};
	private String[] columnArray={"id","userId","userName","userNick"};
	
	private GenerateGridXData(){
	}

	public static GenerateGridXData getInstance(){
		return geud==null?new GenerateGridXData():geud;
	}
	
	public void proc(HttpServletRequest req,HttpServletResponse res,JspWriter out) throws Exception{
		BasicServlet.getMapInParameter(req);
		if(req.getParameter("sort")!=null){
			LogUtil.outPutObject(req.getParameter("sort"));
		}
		out.write("{\"numRows\":2386,\"items\":"+getBodyData()+",\"columns\":"+getHeadData()+","+getPageInfo(true,1, 15)+"}");
	}
	
	public String getBodyData(){
		List<VskUserT> userList=new LinkedList<VskUserT>();
		for(int i=0;i<20;i++){
			userList.add(new VskUserT(i+100,i-500, "user"+i, "nick"+i));
		}
		String s=BaseJson.listToJson(userList);
		return s; 
	}
	
	public String getGridHead(String... ss){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<ss.length;i++){
			sb.append("-1".equals(ss[i])?"":BaseJson.objectToJson( columnProperties[i])+":"+(getValue(ss[i]))+",");
		}
		sb.setLength(sb.length()-1);
		return sb.toString();
	}
	
	public String getHeadData(){
		String url="javascript:void(0);";
		
		StringBuilder sb=new StringBuilder();
		
		sb.append("[");
		for(int i=0;i<columnArray.length;i++){
			sb.append("{"+getGridHead(i+"",columnArray[i],"CK"+columnArray[i]+"","190px",i==0?"true":"false",i==2?url:"-1",i==2?"false":"-1")+"},");
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
	
	public String getValue(String s){
		//String f=s.toLowerCase();
		//if("true".equals(f)||"false".equals(f)) return f;		
		//if(isNumber(s)) return s;
		return BaseJson.objectToJson(s);
	}
	
	public boolean isNumber(String s){
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(s).matches();    
	}

}
