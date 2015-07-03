package com.vsked.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import com.vsked.util.BaseJson;
import com.vsked.util.BasicServlet;

public class GenerateDataGridData {
	
	private static GenerateDataGridData gdgd=null;
	
	private String[] columnProperties={"field","name","width","id"};
	private String[] columnArray={"userId","userName","userNick","userPass","userAge"};
	
	private GenerateDataGridData(){
	}
	
	public static GenerateDataGridData getInstance(){
		return gdgd==null?new GenerateDataGridData():gdgd;
	}
	
	public void proc(HttpServletRequest req,HttpServletResponse res,JspWriter out) throws Exception{
		Map<String,String> m=BasicServlet.getMapInParameter(req);
		int st=Integer.parseInt(m.get("start")==null?"0":m.get("start"));
		int ct=Integer.parseInt(m.get("count")==null?"10":m.get("count"));
		//res.setHeader("Content-Range", "items="+st+"-"+(st+ct)+"/500");
		out.write("{\"numRows\":260,\"items\":"+getBodyData(st,ct)+",\"columns\":"+getHeadData()+","+getPageInfo(true,st, ct,200)+"}");
	}
	
	public String getBodyData(int st,int ct){
		List<VskUserT> userList=new LinkedList<VskUserT>();
		for(int i=st;i<(st+ct)*2;i++){
			userList.add(new VskUserT(i, "user"+i, "nick"+i,"pass"+i+"sk",(10+i)));
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
			sb.append("{"+getGridHead(columnArray[i],"CK"+columnArray[i]+"","100px")+"},");
		}
		sb.setLength(sb.length()-1);
		sb.append("]");
		return sb.toString();
	}
	
	public static String getPageInfo(boolean isPage,int st,int pageSize,int total){
		String s="\"pageInfo\": {";
		s+="\"pageSize\":"+ pageSize +",";
		s+="\"total\":"+ total +",";
		s+="\"currentPage\":"+ st +",";
		s+="\"isMutiSelect\": false,";
		s+="\"gridId\": \"grid1a\",";
		s+="\"isPage\": "+isPage;
		s+="}";
		return s;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(GenerateDataGridData.getInstance().getHeadData());
		
	}

}
