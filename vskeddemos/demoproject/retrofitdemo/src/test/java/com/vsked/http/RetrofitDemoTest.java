package com.vsked.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Callback;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RetrofitDemoTest {

    private static final Logger log = LoggerFactory.getLogger(RetrofitDemoTest.class);
    ObjectMapper jackson = new ObjectMapper();

    public static void main(String[] args) {
        RetrofitDemoTest test=new RetrofitDemoTest();
        //异步调用测试 仅参数
        test.post2Async();
        //异步调用测试 参数+文件方式
        //test.post5Async();
    }

   @Test
    public void get1(){
        try{
            String myUrl="http://www.baidu.com";
            String result=RetrofitDemoImpl.get1(myUrl);
            log.debug("|"+result+"|");
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }

    @Test
    public void get2(){
        try{
            Map<String, Object> parMap=new HashMap<String, Object>();
            parMap.put("rsv_bp", "1");
            parMap.put("wd", "vsked");
            parMap.put("ie", "utf-8");
            String myUrl="http://www.baidu.com/s";
            String result=RetrofitDemoImpl.get2(myUrl,parMap);
            log.debug("|"+result+"|");
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }

    @Test
    public void post1(){
        try{
            Map<String, Object> parMap=new HashMap<String, Object>();
            parMap.put("post参数1", "a1");
            parMap.put("postb", "参数值b1");
            parMap.put("postc", "c1");
            String myUrl="http://localhost:8181/test/proc";
            String result=RetrofitDemoImpl.post1(myUrl,parMap);
            log.debug("|"+result+"|");
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }

    @Test
    public void post2(){
        try{
            String myContent="{\"测试key\":\"valkue小二上菜\",\"来啊key\":\"来了\",\"去吧key\":\"听说valkue\"}";
            String myUrl="http://localhost:8181/test/procJson";
            String result=RetrofitDemoImpl.post2(myUrl,myContent);
            log.debug("|"+result+"|");
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }


    public void post2Async(){
        try{
            Map<String, Object> parMap=new HashMap<String, Object>();
            parMap.put("username", "MyNameIsVsked");
            parMap.put("password", "参数值b1");

            String data=jackson.writeValueAsString(parMap);

            String myUrl="http://localhost:80/test2";


            //异步回调函数，用于处理响应回来的信息
            Callback<ResponseBody> callback=new Callback<ResponseBody>() {
                @Override
                public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                    try{
                        ResponseBody responseBody=response.body();
                        String result="";
                        if(responseBody!=null){
                            result=responseBody.string();
                        }
                        //我方服务器响应
                        log.info("{}",result);

                    }catch(Exception e){
                        log.error(e.getMessage(),e);
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                    log.error("upload location to our server exception:",throwable);
                }
            };
            RetrofitDemoImpl.post2Async(myUrl,data,callback);

        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }

    @Test
    public void post3(){
        try{
            //传文件时需要的参数
            Map<String, Object> parMap=new HashMap<String, Object>();
            parMap.put("test1", "中文测试");
            parMap.put("b", "b1");
            parMap.put("c", "c1");

            //文件列表
            List<String> filePathList=new LinkedList<String>();
            filePathList.add("e:/1.jpg");
            filePathList.add("e:/2.jpg");
            filePathList.add("e:/3.jpg");
            filePathList.add("e:/ocr_id_02.jpg");
            String myUrl="http://localhost:8080/retrofitdemo/proc/test1proc1.jsp";
            String result=RetrofitDemoImpl.post3(myUrl,parMap,filePathList);
            log.debug("|"+result+"|");
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }

    @Test
    public void post4(){
        try{
            String myUrl="http://localhost:8181/test/procHeader1";
            String token="---------------------token789110--------------";
            String param1="$$$$$$$$$$$$$$$$$$param88888$$$$$$$$$$$$$$$$$$";
            String result=RetrofitDemoImpl.post4(myUrl,token,param1);
            log.debug("|"+result+"|");
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }

    @Test
    public void post5(){
        try{
            Map<String,Object> externalAPIData=new HashMap<>();
            externalAPIData.put("name", "thisIsVsked");
            externalAPIData.put("url", "http://www.vsked.cn");

            //传文件时需要的参数
            Map<String, Object> parMap=new HashMap<String, Object>();
            parMap.put("externalApi", externalAPIData);

            String fileName="d:/03_00_6702_00_20260414102316131000000000000001.bin";

            String myUrl="http://localhost:80/test/uploadFile";
            String result=RetrofitDemoImpl.post5(myUrl,parMap,fileName);
            log.debug("|"+result+"|");
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }

    public void post5Async(){
       //异步调用测试
        try{
            Map<String,Object> externalAPIData=new HashMap<>();
            externalAPIData.put("name", "thisIsVsked");
            externalAPIData.put("url", "http://www.vsked.cn");

            //传文件时需要的参数
            Map<String, Object> parMap=new HashMap<String, Object>();
            parMap.put("externalApi", externalAPIData);

            String fileName="d:/03_00_6702_00_20260414102316131000000000000001.bin";

            String myUrl="http://localhost:80/test/uploadFile";

            //异步回调函数，用于处理响应回来的信息
            Callback<ResponseBody> callback=new Callback<ResponseBody>() {
                @Override
                public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                    try{
                        ResponseBody responseBody=response.body();
                        String result="";
                        if(responseBody!=null){
                            result=responseBody.string();
                        }
                        //我方服务器响应
                        log.info("{}",result);

                    }catch(Exception e){
                        log.error(e.getMessage(),e);
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                    log.error("upload location to our server exception:",throwable);
                }
            };

            //异步调用
            RetrofitDemoImpl.post5Async(myUrl,parMap,fileName,callback);

        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }


    @Test
    public void postSMS(){
        try{
            Map<String, Object> parMap=new HashMap<String, Object>();
            parMap.put("SpCode", "s1");
            parMap.put("dz_rx", "s2");
            parMap.put("Password", "s3");
            parMap.put("MessageContent", "ff3");
            parMap.put("UserNumber", "13280009366");
            parMap.put("SerialNumber", "1000202204090001");
            String myUrl="https://api.test.com:9600/sms/Api/Send.do";
            String result=RetrofitDemoImpl.post1Ex(myUrl,parMap);
            log.debug("|"+result+"|");
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }

}
