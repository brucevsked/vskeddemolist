package com.jat.controller;

import com.jat.util.WxTool;
import com.jfinal.aop.Duang;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.wxaapp.api.WxaAccessTokenApi;
import com.jfinal.wxaapp.api.WxaQrcodeApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


@Path("/mywx")
public class MyWxController extends Controller {

    private static final Logger log = LoggerFactory.getLogger(MyWxController.class);
    
    public void accessToken(){
        String accessToken= WxaAccessTokenApi.getAccessTokenStr();
        log.info("{}",accessToken);
        renderJson("{\"access_token\":\""+accessToken+"\"}");
    }

    public void createQRCode(){
        String accessToken= WxaAccessTokenApi.getAccessTokenStr();
        String scene="a=99";
        String ktvId=getPara("ktvid");
        String roomId=getPara("roomid");

        String path="pages/index/index";
        //太阳码
        WxaQrcodeApi wxaQrcodeApi = Duang.duang(WxaQrcodeApi.class);
        InputStream inputStream = wxaQrcodeApi.get(path);
        /*
        //特别注意，写文件与向前台输出base64只能选一种！
        try {
            OutputStream os = new FileOutputStream(new File("d:/test1r.jpg"));
            int len;
            byte[] arr = new byte[1024];
            while ((len = inputStream.read(arr)) != -1) {
                os.write(arr, 0, len);
                os.flush();
            }
            os.close();
        }catch (Exception e){
            log.error("just test:",e);
        }
                String imageBase64="";
         */

        String imageBase64=WxTool.getImageBinary(inputStream);
        renderHtml("<img src=\""+imageBase64+"\"></img>");
    }

    public void createQRCode1(){
        String accessToken= WxaAccessTokenApi.getAccessTokenStr();

        String ktvId=getPara("ktvid");
        String roomId=getPara("roomid");

        String scene="a=99";
        String path="pages/index/index";
        //方形码
        WxaQrcodeApi wxaQrcodeApi = Duang.duang(WxaQrcodeApi.class);
        InputStream inputStream = wxaQrcodeApi.getUnLimit(scene,path);
        /*
        特别注意，写文件与向前台输出base64只能选一种！
        try {
            OutputStream os = new FileOutputStream(new File("d:/test1r.jpg"));
            int len;
            byte[] arr = new byte[1024];
            while ((len = inputStream.read(arr)) != -1) {
                os.write(arr, 0, len);
                os.flush();
            }
            os.close();
        }catch (Exception e){
            log.error("just test:",e);
        }
                String imageBase64="";
         */

        String imageBase64=WxTool.getImageBinary(inputStream);
        renderHtml("<img src=\""+imageBase64+"\"></img>");
    }

}
