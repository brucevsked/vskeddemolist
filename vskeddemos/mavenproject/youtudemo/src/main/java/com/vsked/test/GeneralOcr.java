package com.vsked.test;

import org.json.JSONArray;
import org.json.JSONObject;

import com.youtu.Youtu;

public class GeneralOcr {

	public static void main(String[] args) {
		testGeneral();
	}
	
	public static void testGeneral(){
		try {
			Youtu faceYoutu = new Youtu(GlobalSet.APP_ID, GlobalSet.SECRET_ID, GlobalSet.SECRET_KEY,Youtu.API_YOUTU_END_POINT,GlobalSet.USER_ID);
			JSONObject respose;
			respose=faceYoutu.GeneralOcr("e:/cc1.jpg");
//			System.out.println(respose.toString());
			JSONArray items=respose.getJSONArray("items");
			
			JSONObject infoStr;
			String itemStr="";
			for (Object item : items) {
				infoStr=(JSONObject) item;
				itemStr=infoStr.getString("itemstring");
				//带空格
//				itemStr=itemStr.replace(" ", "");
				System.out.println("|"+itemStr+"|");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
