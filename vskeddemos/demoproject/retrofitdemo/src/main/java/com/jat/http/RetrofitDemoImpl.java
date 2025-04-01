package com.jat.http;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitDemoImpl {

    static final OkHttpClient client = new OkHttpClient.Builder().
            connectTimeout(180, TimeUnit.SECONDS).
            readTimeout(180, TimeUnit.SECONDS).
            writeTimeout(180, TimeUnit.SECONDS).build();
    /**
     * get请求不带参数
     * @param myUrl
     * @return
     * @throws Exception
     */
    public static String get1(String myUrl) throws Exception{
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.baidu.com/").client(client).build();
        RetrofitDemo service=retrofit.create(RetrofitDemo.class);
        Call<ResponseBody> call=service.get1(myUrl);
        Response<ResponseBody> response=call.execute();
        String result="";
        ResponseBody responseBody=response.body();
        if(responseBody!=null){
            result=responseBody.string();
        }
        return result;
    }

    /**
     * get请求带参数
     * @param myUrl
     * @param myParMap
     * @return
     * @throws Exception
     */
    public static String get2(String myUrl,Map<String, Object> myParMap) throws Exception{
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.baidu.com/").client(client).build();
        RetrofitDemo service=retrofit.create(RetrofitDemo.class);
        Call<ResponseBody> call=service.get2(myUrl,myParMap);
        Response<ResponseBody> response=call.execute();
        String result="";
        ResponseBody responseBody=response.body();
        if(responseBody!=null){
            result=responseBody.string();
        }
        return result;
    }

    /**
     * post请求带参数__表单版本
     * @param myUrl
     * @param myParMap
     * @return
     * @throws Exception
     */
    public static String post1(String myUrl,Map<String, Object> myParMap) throws Exception{
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.baidu.com/").client(client).build();
        RetrofitDemo service=retrofit.create(RetrofitDemo.class);
        Call<ResponseBody> call=service.post1(myUrl,myParMap);
        Response<ResponseBody> response=call.execute();
        String result="";
        ResponseBody responseBody=response.body();
        if(responseBody!=null){
            result=responseBody.string();
        }
        return result;
    }

    public static String post1Ex(String myUrl,Map<String, Object> myParMap) throws Exception{

        OkHttpClient client = new OkHttpClient.Builder().
                connectTimeout(180, TimeUnit.SECONDS).
                readTimeout(180, TimeUnit.SECONDS).
                writeTimeout(180, TimeUnit.SECONDS).addInterceptor(new ResponseInterceptor("GBK")).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.baidu.com/").client(client).build();
        RetrofitDemo service=retrofit.create(RetrofitDemo.class);
        Call<ResponseBody> call=service.post1Ex(myUrl,myParMap);
        Response<ResponseBody> response=call.execute();
        String result="";


        ResponseBody responseBody=response.body();
        if(responseBody!=null){
            result=responseBody.string();
        }
        return result;
    }

    /**
     * post请求带参数__json版本
     * @param myUrl
     * @param parString
     * @return
     * @throws Exception
     */
    public static String post2(String myUrl,String parString) throws Exception{
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.baidu.com/").client(client).build();
        RetrofitDemo service=retrofit.create(RetrofitDemo.class);
        byte[] contentByteArray=parString.getBytes("utf-8");
        RequestBody body=RequestBody.create(contentByteArray, MediaType.parse("application/json; charset=utf-8"), 0, contentByteArray.length);
        Call<ResponseBody> call=service.post2(myUrl,body);
        Response<ResponseBody> response=call.execute();
        String result="";
        ResponseBody responseBody=response.body();
        if(responseBody!=null){
            result=responseBody.string();
        }
        return result;
    }

    /**
     * post请求带参数__文件上传版本
     * @param myUrl
     * @param parMap
     * @param filePathList
     * @return
     * @throws Exception
     */
    public static String post3(String myUrl,Map<String,Object> parMap,List<String> filePathList) throws Exception{
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.baidu.com/").client(client).build();

        Map<String, RequestBody>  myParMap=new HashMap<String, RequestBody>();
        List<MultipartBody.Part> myFilePathList=new LinkedList<MultipartBody.Part>();

        Iterator<Entry<String, Object>> entries=parMap.entrySet().iterator();
        while(entries.hasNext()){
            Entry<String, Object> entry = entries.next();
            String key=entry.getKey();
            String value=(String) entry.getValue();
            byte[] contentByteArray=value.getBytes("utf-8");
            RequestBody body=RequestBody.create(contentByteArray, MediaType.parse("multipart/form-data"), 0, contentByteArray.length);
            myParMap.put(key, body);
        }


        for(int i=0;i<filePathList.size();i++){
            String fpath1=filePathList.get(i);
            File tmpFile=new File(fpath1);
            byte[] contentByteArray=fileToByte(fpath1);
            RequestBody myFileReqBody1=RequestBody.create(contentByteArray, MediaType.parse("application/otcet-stream"), 0, contentByteArray.length);
            MultipartBody.Part part1=MultipartBody.Part.createFormData(tmpFile.getAbsolutePath(), tmpFile.getName(), myFileReqBody1);
            myFilePathList.add(part1);
        }

        RetrofitDemo service=retrofit.create(RetrofitDemo.class);
        Call<ResponseBody> call=service.post3(myUrl,myParMap,myFilePathList);
        Response<ResponseBody> response=call.execute();
        String result="";
        ResponseBody responseBody=response.body();
        if(responseBody!=null){
            result=responseBody.string();
        }
        return result;
    }

    public static String post4(String myUrl,String token,String param1) throws Exception{

        OkHttpClient client = new OkHttpClient.Builder().
                connectTimeout(180, TimeUnit.SECONDS).
                readTimeout(180, TimeUnit.SECONDS).
                writeTimeout(180, TimeUnit.SECONDS).addInterceptor(new ResponseInterceptor("GBK")).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.baidu.com/").client(client).build();
        RetrofitDemo service=retrofit.create(RetrofitDemo.class);
        Call<ResponseBody> call=service.post4(myUrl,token,param1);
        Response<ResponseBody> response=call.execute();
        String result="";
        ResponseBody responseBody=response.body();
        if(responseBody!=null){
            result=responseBody.string();
        }
        return result;
    }


    public static byte[] fileToByte(String filename) throws Exception{
        FileChannel fc = null;
        RandomAccessFile rf=new RandomAccessFile(filename, "r");
        try {
            fc = rf.getChannel();
            MappedByteBuffer mappedByteBuffer = fc.map(MapMode.READ_ONLY, 0, fc.size()).load();
            byte[] result = new byte[(int) fc.size()];
            if (mappedByteBuffer.remaining() > 0) {
                mappedByteBuffer.get(result, 0, mappedByteBuffer.remaining());
            }
            return result;
        }  catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                rf.close();
                fc.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
