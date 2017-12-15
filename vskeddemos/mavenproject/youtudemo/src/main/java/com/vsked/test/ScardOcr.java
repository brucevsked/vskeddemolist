package com.vsked.test;

import org.json.JSONObject;
import com.youtu.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ocr get scard info
 * @author brucevsked
 *
 */
public class ScardOcr {
	
	private static final Logger log=LogManager.getLogger(ScardOcr.class);
	//http://api.youtu.qq.com/youtu/ocrapi/idcardocr
		// appid, secretid secretkey请到http://open.youtu.qq.com/获取
		// 请正确填写把下面的APP_ID、SECRET_ID和SECRET_KEY
		public static final String APP_ID = "10008975";
		public static final String SECRET_ID = "AKID1vdBXigT3ThmfMn8DYjiW8YpurDPqCnC";
		public static final String SECRET_KEY = "KSRIxSmxwjKiy2tZ5RbZKyVt782kFYfZ";
		public static final String USER_ID = "hyfdcompany";

		public static void main(String[] args) {
//			testFront();
//			testBack();
		}
		
		public static void testFront(){
			try {
				Youtu faceYoutu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY,Youtu.API_YOUTU_END_POINT,USER_ID);
				JSONObject respose;
				//respose= faceYoutu.FaceCompareUrl("http://open.youtu.qq.com/content/img/slide-1.jpg","http://open.youtu.qq.com/content/img/slide-1.jpg");
				//respose = faceYoutu.DetectFace("e:/ocr_id_02.jpg",1);
				respose = faceYoutu.IdCardOcr("d:/tz.jpg", 0);//0代表正面 1反面
				System.out.println(respose.toString());
				//get respose
				int errorcode=respose.getInt("errorcode");
				String errormsg=respose.getString("errormsg");
				//System.out.println(respose);
				String uName=respose.getString("name");
				String uSex=respose.getString("sex");
				String uAddress=respose.getString("address");
				String uScardId=respose.getString("id");
				String uHeadBase64=respose.getString("frontimage");
				
				System.out.println(errorcode);
				System.out.println(errormsg);
				System.out.println(uName);
				System.out.println(uSex);
				System.out.println(uAddress);
				System.out.println(uScardId);
				//System.out.println(uHeadBase64);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void testBack(){
			try {
				Youtu faceYoutu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY,Youtu.API_YOUTU_END_POINT,USER_ID);
				JSONObject respose;
				//respose= faceYoutu.FaceCompareUrl("http://open.youtu.qq.com/content/img/slide-1.jpg","http://open.youtu.qq.com/content/img/slide-1.jpg");
				//respose = faceYoutu.DetectFace("e:/ocr_id_02.jpg",1);
				respose = faceYoutu.IdCardOcr("d:/bg1.jpg", 1);//0代表正面 1反面
				System.out.println(respose.toString());
				
				String authority=respose.getString("authority");
				String valid_date=respose.getString("valid_date");
				
				System.out.println(authority);
				System.out.println(valid_date);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
