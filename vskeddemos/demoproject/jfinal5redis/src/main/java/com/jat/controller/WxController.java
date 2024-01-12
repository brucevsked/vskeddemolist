package com.jat.controller;

import com.jat.util.WxTool;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.wxaapp.api.WxaAccessTokenApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Path("/wx")
public class WxController extends Controller {

    private static final Logger log = LoggerFactory.getLogger(WxController.class);

    public void accessToken(){
        String accessToken= WxTool.getAccessToken();
        log.info("{}",accessToken);
        renderJson("{\"access_token\":\""+accessToken+"\"}");
    }

    public void createQRCode(){
        String accessToken= WxaAccessTokenApi.getAccessTokenStr();
        String scene="a=99";
        String ktvId=getPara("ktvid");
        String roomId=getPara("roomid");
        //圆形太阳码
        String params="{\"scene\":\"myscene=1\",\"page\":\"pages/index/index\",\"auto_color\":true,\"env_version\":\"trial\"}";

        log.info("{}",params);
        String imageBase64=WxTool.getImageBase64Circle(accessToken,params);

        renderHtml("<img src=\""+imageBase64+"\"></img>");
    }

    public void createQRCode1(){
        String accessToken= WxaAccessTokenApi.getAccessTokenStr();
        String scene="a=99";
        String ktvId=getPara("ktvid");
        String roomId=getPara("roomid");
        //方形码
        String params="{\"path\":\"pages/index/index\"}";
        log.info("{}",params);
        String imageBase64=WxTool.getImageBase64Rect(accessToken,params);
        renderJson("{\"access_token\":\""+imageBase64+"\"}");
    }

}
