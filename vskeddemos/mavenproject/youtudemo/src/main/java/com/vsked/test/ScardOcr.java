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


		public static void main(String[] args) {
//			testFront();
			testBack();
		}
		
		public static void testFront(){
			try {
				Youtu faceYoutu = new Youtu(GlobalSet.APP_ID, GlobalSet.SECRET_ID, GlobalSet.SECRET_KEY,Youtu.API_YOUTU_END_POINT,GlobalSet.USER_ID);
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
				Youtu faceYoutu = new Youtu(GlobalSet.APP_ID, GlobalSet.SECRET_ID, GlobalSet.SECRET_KEY,Youtu.API_YOUTU_END_POINT,GlobalSet.USER_ID);
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
