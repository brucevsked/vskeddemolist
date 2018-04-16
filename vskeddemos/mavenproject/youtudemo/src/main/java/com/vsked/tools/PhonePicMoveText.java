package com.vsked.tools;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.vsked.test.GlobalSet;
import com.youtu.Youtu;

public class PhonePicMoveText {
	
	public static String failList="";
	public static String lineFlag="\r\n";

	public static void main(String[] args) {
		String filePath="d:/rs.txt";
		String targetFolder="d:/tempMission/out";
		File f=new File(filePath);
		try {
			List<String> dataList=FileUtils.readLines(f, "utf-8");
			int count=1;
			String fPath="";
			for(String s:dataList){
				System.out.println(count+"|"+s);
				if(!isExistPhone(s, targetFolder)){
					try {
						failList=fPath+lineFlag;
						FileUtils.write(new File(targetFolder+"/rs.txt"), failList, "utf-8",true);
					} catch (IOException e1) {
					}
				}
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static boolean isExistPhone(String fpath,String ouputPath){
		try {
			Youtu faceYoutu = new Youtu(GlobalSet.APP_ID, GlobalSet.SECRET_ID, GlobalSet.SECRET_KEY,Youtu.API_YOUTU_END_POINT,GlobalSet.USER_ID);
			JSONObject respose;
			respose=faceYoutu.GeneralOcr(fpath);
//			System.out.println(respose.toString());
			JSONArray items=respose.getJSONArray("items");
			
			JSONObject infoStr;
			String itemStr="";
			for (Object item : items) {
				infoStr=(JSONObject) item;
				itemStr=infoStr.getString("itemstring");
				itemStr=itemStr.replace(" ", "");
				System.out.println("|"+itemStr+"|");
				//跳过iccid检查
				if(itemStr.indexOf("9860")>0 && itemStr.length()>14){
					continue;
				}
				if(itemStr.length()<=8) continue;
				//不足11位补1
				if(itemStr.length()==10){
					itemStr="1"+itemStr;
				}
				//不足11位补17
				if(itemStr.length()==9){
					itemStr="17"+itemStr;
				}
				
				//是手机号
				if(isPhone(itemStr)){
					itemStr=itemStr.substring(itemStr.indexOf("17"),itemStr.indexOf("17")+11);
					PhonePicMove.createDir(ouputPath+"/"+itemStr);
					PhonePicMove.copyFile(fpath, ouputPath+"/"+itemStr+"/"+new File(fpath).getName());
					return true;
				}
				
			}
			
			
		} catch (Exception e) {
			failList=fpath+lineFlag;
			try {
				FileUtils.write(new File(ouputPath+"/rs.txt"), failList, "utf-8",true);
			} catch (IOException e1) {
			}
		}
		return false;
	}
	
	public static boolean isPhone(String str){
			Pattern pattern = Pattern.compile(".*(17[0|1])\\d{8}.*");
			return pattern.matcher(str).matches();    
	}
	
	public static boolean isNumber(String s){
		Pattern pattern = Pattern.compile("^0|[0-9]\\d*(\\.\\d+)?$");
		return (s!=null) && (!"".equals(s)) && (pattern.matcher(s).matches());    
	}
	

}
