package com.jat.util;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;

public class WxTool {

    private static final Logger log = LoggerFactory.getLogger(WxTool.class);

    public static String getAccessTokenNative(){
        try {
            String grant_type = "client_credential";
            HttpRequest requestion = new HttpRequest();
            String params = "grant_type=" + grant_type + "&secret=" + ProjectConst.APPSECRET + "&appid=" + ProjectConst.APP_ID;
            String sendGet = requestion.sendGet("https://api.weixin.qq.com/cgi-bin/token", params);

            log.info("{}",sendGet);

            Map<String, String> m = JSON.parseObject(sendGet, Map.class);
            if(m.get("errcode")==null){
                //accesstoken即为申请得到的access_token（这个值两小时就会失效  2022）
                return m.get("access_token");
            }

        }catch (Exception e){
            log.error("get native access error:",e);
        }
        return null;
    }

    public static String getBase64Data(byte[] dt){
    	return CryptoTool.base64Encode(dt);
    }

    public static String getImageBinary(InputStream inputStream){
        byte[] b = null;
        ByteArrayOutputStream os=new ByteArrayOutputStream();//新建流。
        try {
            BufferedImage bi= ImageIO.read(inputStream);
            ImageIO.write(bi, "jpg", os);
            b=os.toByteArray();
        } catch (IOException e) {
            log.error("image write error:",e);
        }
        return "data:image/jpg;base64,"+getBase64Data(b);
    }

    public static String getImageBase64Circle(String accessToken,String params){
        //圆形太阳码
        String url="https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+accessToken;

        BufferedInputStream myInputStream=HttpRequest.sendWXPost(url,params);
//        try {
//            OutputStream os = new FileOutputStream(new File("d:/test1.txt"));
//            int len;
//            byte[] arr = new byte[1024];
//            while ((len = myInputStream.read(arr)) != -1) {
//                os.write(arr, 0, len);
//                os.flush();
//            }
//            os.close();
//        }catch (Exception e){
//            log.error("just test:",e);
//        }
//        return null;
        return getImageBinary(myInputStream);
    }

    public static String getImageBase64Rect(String accessToken,String params){
        //方形码
        String url="https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token="+accessToken;

        BufferedInputStream myInputStream=HttpRequest.sendWXPost(url,params);
        try {
            OutputStream os = new FileOutputStream(new File("d:/test2.jpg"));
            int len;
            byte[] arr = new byte[1024];
            while ((len = myInputStream.read(arr)) != -1) {
                os.write(arr, 0, len);
                os.flush();
            }
            os.close();
        }catch (Exception e){
            log.error("just test:",e);
        }
        return null;
        //return getImageBinary(myInputStream);
    }

    public static void inputStream2File (InputStream is, File file) throws IOException {
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int len = 0;
            byte[] buffer = new byte[8192];

            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } finally {
            os.close();
            is.close();
        }
    }


}
