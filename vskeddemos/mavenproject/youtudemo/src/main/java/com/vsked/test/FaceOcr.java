package com.vsked.test;

import org.json.JSONObject;

import com.youtu.Youtu;

public class FaceOcr {

	public static void main(String[] args) {
		testFaceCompare();
	}
	
    public static void testFaceCompare(){
		try {
			Youtu faceYoutu = new Youtu(GlobalSet.APP_ID, GlobalSet.SECRET_ID, GlobalSet.SECRET_KEY,Youtu.API_YOUTU_END_POINT,GlobalSet.USER_ID);
			JSONObject respose;
			respose= faceYoutu.FaceCompareUrl("D:/tempMission/1/238.jpg","D:/tempMission/1/239.jpg");
			System.out.println(respose.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
