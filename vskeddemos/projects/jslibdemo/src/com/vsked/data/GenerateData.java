package com.vsked.data;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import com.vsked.util.BaseJson;

public class GenerateData {
	
	static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	static String[] columnArray={"\"userId\"","\"userName\"","\"userNick\"","\"userPass\"","\"userAge\"","\"akb45\"","\"akb44\"","\"akb43\"","\"akb42\"","\"akb41\"","\"akb51\"","\"akb52\""};
	
	static String[] sm={"\"text\"","\"dataIndex\"","\"hidden\"","\"align\"","\"menuDisabled\"","\"sortable\"","\"xtype\"","\"renderer\"","\"width\""};
	
	static int columnCount=12;
	
	/**
	 * init the body data for UserServlet
	 * @return List<VskUserT>
	 * @throws Exception
	 */
	public static List<VskUserT> getBodyData() throws Exception{
		List<VskUserT> userList=new LinkedList<VskUserT>();
		for(int i=0;i<8;i++){
			userList.add(new VskUserT(i, "user"+i, "nick"+i, "pass"+i, (18+i), sdf.parse("2014-08-09"), sdf.parse("2014-08-09")));
		}
		return userList;
		
	}
	
	/**
	 * generate grid head column data for SortGridServlet and GenerateServlet
	 * data format
	 * "fieldHeader":[{"a":"b","c":1,...},{...}],"fields":["a","b",...]
	 * @return String
	 */
	public static String getHeadData(){
		
		String rd="function(v){return '<a href=\"javascript:alert(18);\">'+v+'</a>';}";
		
		String s="\"fieldHeader\":";
		s+="[";
		for(int i=0;i<columnCount;i++)
			s+=("{"+getGridHead("\"columnS_"+i+"\"",""+columnArray[i]+"","-1","\"right\"","true","-1","-1",i==1?rd:"-1")+"},");
		s=s.substring(0,s.length()-1);
		s+="],\"fields\":[";
		for(int i=0;i<columnCount;i++){
			s+=(columnArray[i]+",");
		}
		s=s.substring(0,s.length()-1);
		s+="]";
		return s;
	}
	
	public static String getJsonBodyData(){
		
		String s="\"dataStr\":";
		s+="[";
		for(int i=0;i<10;i++)
			s+=("{"+getGridBody("\""+i+"\"","\"nameIs"+i+"\"","\"nick"+i+"\"","\"ps"+i+"d\"","\""+(i+10)+"\"")+"},");
		s=s.substring(0,s.length()-1);
		s+="]";
		return s;
	}
	
    public static String getJsonBodyData(int st,int pageSize,boolean isArray){
    	StringBuilder sb=new StringBuilder("\"dataStr\":");
		sb.append("[");
		for(int i=(st-1)*pageSize;i<st*pageSize;i++)
			sb.append(isArray?("[\""+i+"\",\"nameIs"+i+"\",\"nick"+i+"\",\"ps"+i+"d\",\""+(i+10)+"\"],") :("{"+getGridBody("\""+i+"\"","\"nameIs"+i+"\"","\"nick"+i+"\"","\"ps"+i+"d\"","\""+(i+18)+"\"","\"ttyynjiopc_"+(i+17)+"\"","\"vgy61"+(i+16)+"\"","\"ctgh12303"+(i+15)+"\"","\"888*--+"+(i+14)+"\"","\"ca09_?"+(i+13)+"\"","\"a_8Y$#_"+(i+12)+"\"","\"b_09_"+(i+11)+"\"")+"},"));
		sb.setLength(sb.length()-1);
		sb.append("]");
		return sb.toString();
	}
	
    /**
     * generate pageInfo json Object
     * @param int st
     * @param int pageSize
     * @return
     */
	public static String getPageInfo(int st,int pageSize){
		String s="\"pageInfo\": {";
		s+="\"pageSize\":"+ pageSize +",";
		s+="\"currentPage\":"+ st +",";
		s+="\"columnLines\": false ,";
		s+="\"isMutiSelect\": false,";
		s+="\"gridId\": \"grid1a\",";
		s+="\"isPage\": true ";
		s+="}";
		return s;
	}
	
	public static String getTotal(int maxCount){
		return "\"totalCount\":"+maxCount;
	}
	
	/**
	 * sm={"\"text\"","\"dataIndex\"","\"hidden\"","\"align\"","\"menuDisabled\"","\"sortable\"","\"xtype\"","\"renderer\"","\"width\""};
	 * @param ss
	 * @return
	 */
	public static String getGridHead(String... ss){
		String s="";
		for(int i=0;i<ss.length;i++){
			s+="-1".equals(ss[i])?"":","+sm[i]+":"+ss[i];
		}
		s=s.substring(1);
		return s;
	}
	
	/**
	 * columnArray={"\"userId\"","\"userName\"","\"userNick\"","\"userPass\"","\"userAge\"","\"userId\""};
	 * @param ss
	 * @return
	 */
	public static String getGridBody(String... ss){
		String s="";
		for(int i=0;i<ss.length;i++){
			s+=","+columnArray[i]+":"+ss[i];
		}
		s=s.substring(1);
		return s;
	}
	
	public static String getGridBodyForArray(String... ss){
		String s="";
		for(int i=0;i<ss.length;i++){
			s+=","+columnArray[i]+":"+ss[i];
		}
		s=s.substring(1);
		return s;
	}
	
	public static void main(String[] args) {
		String s="";
		for(int i=0;i<columnCount;i++)
			s+=("{"+getGridBody("\""+i+"\"","\"nameIs"+i+"\"","\"nick"+i+"\"","\"ps"+i+"d\"","\""+(i+10)+"\"")+"},");
		s=s.substring(0,s.length()-1);
		System.out.println(s);
	}

}
