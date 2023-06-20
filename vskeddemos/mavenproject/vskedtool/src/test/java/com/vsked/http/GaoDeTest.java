package com.vsked.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class GaoDeTest {
    private static final Logger log = LoggerFactory.getLogger(GaoDeTest.class);

    String key="你的高德key 服务api的";//高德”Web服务API”密钥（key）

    @Test
    public void serviceAdd(){
        try{
            Map<String, Object> parMap=new HashMap<>();
            parMap.put("key", key);
            parMap.put("name", "myService2");
            String myUrl="https://tsapi.amap.com/v1/track/service/add";
            String result=RetrofitDemoImpl.post1(myUrl,parMap);
            log.debug("{}",result);
            //{"data":{"name":"myService2","sid":959038},"errcode":10000,"errdetail":null,"errmsg":"OK"}
        }catch(Exception e){
            log.error("add service error:",e);
        }
    }

    @Test
    public void serviceUpdate(){
        try{
            Map<String, Object> parMap=new HashMap<>();
            parMap.put("key", key);
            parMap.put("sid", "959038");
            parMap.put("name", "myService2a");
            String myUrl="https://tsapi.amap.com/v1/track/service/update";
            String result=RetrofitDemoImpl.post1(myUrl,parMap);
            log.debug("{}",result);
            //{"data":{"name":"myService2a","sid":"959038"},"errcode":10000,"errdetail":null,"errmsg":"OK"}
        }catch(Exception e){
            log.error("update service error:",e);
        }
    }

    @Test
    public void serviceDel(){
        try{
            Map<String, Object> parMap=new HashMap<>();
            parMap.put("key", key);
            parMap.put("sid", "959038");
            String myUrl="https://tsapi.amap.com/v1/track/service/delete";
            String result=RetrofitDemoImpl.post1(myUrl,parMap);
            log.debug("{}",result);
            //{"data":null,"errcode":10000,"errdetail":null,"errmsg":"OK"}
        }catch(Exception e){
            log.error("delete service error:",e);
        }
    }

    @Test
    public void serviceList(){
        try{
            String myUrl="https://tsapi.amap.com/v1/track/service/list?key="+key;
            String result=RetrofitDemoImpl.get1(myUrl);
            log.debug("{}",result);
            //{"data":{"results":[{"name":"zhihuijiaotong","sid":956951},{"name":"myService2a","sid":959038}]},"errcode":10000,"errdetail":null,"errmsg":"OK"}
        }catch(Exception e){
            log.error("get service list error:",e);
        }
    }

    @Test
    public void terminalAdd(){
        try{
            Map<String, Object> parMap=new HashMap<>();
            parMap.put("key", key);
            parMap.put("sid", "956951");
            parMap.put("name", "车辆2号");
            parMap.put("props", "{\"id\":\"c002\"}");
            String myUrl="https://tsapi.amap.com/v1/track/terminal/add";
            String result=RetrofitDemoImpl.post1(myUrl,parMap);
            log.debug("{}",result);
            //{"data":{"name":"车辆2号","tid":709305612,"sid":956951},"errcode":10000,"errdetail":null,"errmsg":"OK"}
        }catch(Exception e){
            log.error("add terminal error:",e);
        }
    }

    @Test
    public void terminalUpdate(){
        try{
            Map<String, Object> parMap=new HashMap<>();
            parMap.put("key", key);
            parMap.put("sid", "956951");
            parMap.put("tid", "709276836");
            parMap.put("name", "车辆2号aa");
            String myUrl="https://tsapi.amap.com/v1/track/terminal/update";
            String result=RetrofitDemoImpl.post1(myUrl,parMap);
            log.debug("{}",result);
            //{"data":null,"errcode":10000,"errdetail":null,"errmsg":"OK"}
        }catch(Exception e){
            log.error("update terminal error:",e);
        }
    }

    @Test
    public void terminalDel(){
        try{
            Map<String, Object> parMap=new HashMap<>();
            parMap.put("key", key);
            parMap.put("sid", "956951");
            parMap.put("tid", "709301754");
            String myUrl="https://tsapi.amap.com/v1/track/terminal/delete";
            String result=RetrofitDemoImpl.post1(myUrl,parMap);
            log.debug("{}",result);
            //{"data":null,"errcode":10000,"errdetail":null,"errmsg":"OK"}
        }catch(Exception e){
            log.error("delete terminal error:",e);
        }
    }

    @Test
    public void terminalList(){
        try{
            String myUrl="https://tsapi.amap.com/v1/track/terminal/list?key="+key+"&sid=956951";
            String result=RetrofitDemoImpl.get1(myUrl);
            log.debug("{}",result);
            //{"data":{"count":2,"results":[{"createtime":1686809904843,"locatetime":0,"name":"车辆2号","tid":709276836},{"createtime":1686638479432,"locatetime":1686823313000,"name":"车辆1号","tid":708063761}]},"errcode":10000,"errdetail":null,"errmsg":"OK"}
            //{"data":{"count":2,"results":[{"createtime":1686813130190,"locatetime":0,"name":"车辆2号","tid":709305612},{"createtime":1686638479432,"locatetime":1686823313000,"name":"车辆1号","tid":708063761}]},"errcode":10000,"errdetail":null,"errmsg":"OK"}
        }catch(Exception e){
            log.error("get terminal list error:",e);
        }
    }

    @Test
    public void traceAdd(){
        try{
            Map<String, Object> parMap=new HashMap<>();
            parMap.put("key", key);
            parMap.put("sid", "956951");
            parMap.put("tid", "709305612");
            parMap.put("trname", "车辆2轨迹4");
            String myUrl="https://tsapi.amap.com/v1/track/trace/add";
            String result=RetrofitDemoImpl.post1(myUrl,parMap);
            log.debug("{}",result);
            //{"data":{"trname":"车辆2轨迹1","trid":40},"errcode":10000,"errdetail":null,"errmsg":"OK"}
            //{"data":{"trname":"车辆2轨迹2","trid":60},"errcode":10000,"errdetail":null,"errmsg":"OK"}
            //{"data":{"trname":"车辆2轨迹1","trid":80},"errcode":10000,"errdetail":null,"errmsg":"OK"}
            //{"data":{"trname":"车辆2轨迹2","trid":100},"errcode":10000,"errdetail":null,"errmsg":"OK"}
            //{"data":{"trname":"车辆2轨迹3","trid":120},"errcode":10000,"errdetail":null,"errmsg":"OK"}
            //{"data":{"trname":"车辆2轨迹4","trid":140},"errcode":10000,"errdetail":null,"errmsg":"OK"}
        }catch(Exception e){
            log.error("add terminal error:",e);
        }
    }

    public static void tracePointUpload(String points){
        try{
            Map<String, Object> parMap=new HashMap<>();
            parMap.put("key", "你的高德key 服务api的");
            parMap.put("sid", "956951");
            parMap.put("tid", "709305612");
            parMap.put("trid", "140");
           parMap.put("points", points);
            String myUrl="https://tsapi.amap.com/v1/track/point/upload";
            String result=RetrofitDemoImpl.post1(myUrl,parMap);
            log.debug("{}",result);
            //{"data":{"errorpoints":[]},"errcode":10000,"errdetail":null,"errmsg":"OK"}
        }catch(Exception e){
            log.error("trace point upload error:",e);
        }
    }

    @Test
    public void tracePointUpload(){
        try{
            Map<String, Object> parMap=new HashMap<>();
            parMap.put("key", key);
            parMap.put("sid", "956951");
            parMap.put("tid", "709305612");
            parMap.put("trid", "100");
            //parMap.put("points", "[{\"location\":\"116.397428,39.90923\",\"locatetime\":1544176895000,\"speed\":40,\"direction\":120,\"height\":39,\"accuracy\":20}, {\"location\":\"116.397435,39.90935\",\"locatetime\":1544176913000,\"speed\":40,\"direction\":110,\"height\":39,\"accuracy\":20}  ]");
            //parMap.put("points", "[{\"location\":\"116.397428,39.90923\",\"locatetime\":1544176895000,\"speed\":40}, {\"location\":\"116.397435,39.90935\",\"locatetime\":1544176913000,\"speed\":40}  ]");
//            parMap.put("points", "[{\"location\":\"116.964068,36.672903\",\"locatetime\":1686526501000,\"speed\":2},{\"location\":\"116.964016,36.672908\",\"locatetime\":1686526504000,\"speed\":3},{\"location\":\"116.964052,36.672905\",\"locatetime\":1686526507000,\"speed\":0},{\"location\":\"116.964033,36.672913\",\"locatetime\":1686526510000,\"speed\":1},{\"location\":\"116.964022,36.672907\",\"locatetime\":1686526513000,\"speed\":2},{\"location\":\"116.964014,36.672914\",\"locatetime\":1686526516000,\"speed\":2},{\"location\":\"116.964026,36.672917\",\"locatetime\":1686526519000,\"speed\":1},{\"location\":\"116.964024,36.672928\",\"locatetime\":1686526522000,\"speed\":1},{\"location\":\"116.964001,36.672924\",\"locatetime\":1686526525000,\"speed\":3},{\"location\":\"116.964006,36.672906\",\"locatetime\":1686526528000,\"speed\":1},{\"location\":\"116.964028,36.672902\",\"locatetime\":1686526531000,\"speed\":2},{\"location\":\"116.964047,36.6729\",\"locatetime\":1686526534000,\"speed\":0},{\"location\":\"116.964048,36.672915\",\"locatetime\":1686526537000,\"speed\":2},{\"location\":\"116.96407,36.672923\",\"locatetime\":1686526540000,\"speed\":2},{\"location\":\"116.964104,36.672915\",\"locatetime\":1686526543000,\"speed\":2},{\"location\":\"116.964164,36.672914\",\"locatetime\":1686526546000,\"speed\":3},{\"location\":\"116.964203,36.672918\",\"locatetime\":1686526549000,\"speed\":1},{\"location\":\"116.964243,36.672925\",\"locatetime\":1686526552000,\"speed\":1},{\"location\":\"116.964257,36.672916\",\"locatetime\":1686526555000,\"speed\":1},{\"location\":\"116.964276,36.672916\",\"locatetime\":1686526558000,\"speed\":1},{\"location\":\"116.964274,36.672921\",\"locatetime\":1686526561000,\"speed\":0},{\"location\":\"116.964269,36.672921\",\"locatetime\":1686526564000,\"speed\":0},{\"location\":\"116.964274,36.672922\",\"locatetime\":1686526567000,\"speed\":0},{\"location\":\"116.964281,36.672922\",\"locatetime\":1686526570000,\"speed\":1},{\"location\":\"116.96427,36.672932\",\"locatetime\":1686526573000,\"speed\":0},{\"location\":\"116.964268,36.672927\",\"locatetime\":1686526576000,\"speed\":1},{\"location\":\"116.964271,36.672924\",\"locatetime\":1686526579000,\"speed\":1},{\"location\":\"116.96427,36.672918\",\"locatetime\":1686526582000,\"speed\":1},{\"location\":\"116.964272,36.672915\",\"locatetime\":1686526585000,\"speed\":0},{\"location\":\"116.964275,36.67291\",\"locatetime\":1686526588000,\"speed\":0},{\"location\":\"116.964275,36.672905\",\"locatetime\":1686526591000,\"speed\":0},{\"location\":\"116.964271,36.672903\",\"locatetime\":1686526594000,\"speed\":0},{\"location\":\"116.964273,36.672897\",\"locatetime\":1686526597000,\"speed\":0},{\"location\":\"116.96427,36.672898\",\"locatetime\":1686526600000,\"speed\":1},{\"location\":\"116.964271,36.672895\",\"locatetime\":1686526603000,\"speed\":0},{\"location\":\"116.96427,36.672892\",\"locatetime\":1686526606000,\"speed\":0},{\"location\":\"116.964272,36.672891\",\"locatetime\":1686526609000,\"speed\":0},{\"location\":\"116.964272,36.67289\",\"locatetime\":1686526612000,\"speed\":1},{\"location\":\"116.964276,36.672891\",\"locatetime\":1686526615000,\"speed\":0},{\"location\":\"116.964277,36.672891\",\"locatetime\":1686526618000,\"speed\":0},{\"location\":\"116.964277,36.672891\",\"locatetime\":1686526621000,\"speed\":0},{\"location\":\"116.964276,36.672891\",\"locatetime\":1686526624000,\"speed\":1},{\"location\":\"116.964282,36.672888\",\"locatetime\":1686526627000,\"speed\":1},{\"location\":\"116.964285,36.672883\",\"locatetime\":1686526630000,\"speed\":0},{\"location\":\"116.964286,36.672882\",\"locatetime\":1686526633000,\"speed\":0},{\"location\":\"116.964291,36.672881\",\"locatetime\":1686526636000,\"speed\":0},{\"location\":\"116.964284,36.672874\",\"locatetime\":1686526639000,\"speed\":3},{\"location\":\"116.964292,36.672881\",\"locatetime\":1686526642000,\"speed\":1},{\"location\":\"116.964311,36.672882\",\"locatetime\":1686526645000,\"speed\":2},{\"location\":\"116.964315,36.672882\",\"locatetime\":1686526648000,\"speed\":0},{\"location\":\"116.964353,36.672843\",\"locatetime\":1686526651000,\"speed\":10},{\"location\":\"116.964447,36.672794\",\"locatetime\":1686526655000,\"speed\":7},{\"location\":\"116.964541,36.672804\",\"locatetime\":1686526658000,\"speed\":12},{\"location\":\"116.96468,36.672835\",\"locatetime\":1686526661000,\"speed\":16},{\"location\":\"116.964872,36.67289\",\"locatetime\":1686526664000,\"speed\":25},{\"location\":\"116.965108,36.672987\",\"locatetime\":1686526667000,\"speed\":31},{\"location\":\"116.96536,36.673076\",\"locatetime\":1686526670000,\"speed\":26},{\"location\":\"116.965513,36.673075\",\"locatetime\":1686526673000,\"speed\":16},{\"location\":\"116.965622,36.672944\",\"locatetime\":1686526676000,\"speed\":25},{\"location\":\"116.965697,36.672759\",\"locatetime\":1686526679000,\"speed\":26},{\"location\":\"116.965782,36.672521\",\"locatetime\":1686526682000,\"speed\":34},{\"location\":\"116.965887,36.672274\",\"locatetime\":1686526685000,\"speed\":33},{\"location\":\"116.965966,36.672058\",\"locatetime\":1686526688000,\"speed\":26},{\"location\":\"116.965992,36.671976\",\"locatetime\":1686526691000,\"speed\":7},{\"location\":\"116.965901,36.671931\",\"locatetime\":1686526694000,\"speed\":19},{\"location\":\"116.965652,36.671849\",\"locatetime\":1686526697000,\"speed\":33},{\"location\":\"116.965379,36.671757\",\"locatetime\":1686526700000,\"speed\":31},{\"location\":\"116.965033,36.671657\",\"locatetime\":1686526703000,\"speed\":39},{\"location\":\"116.964702,36.671575\",\"locatetime\":1686526706000,\"speed\":35},{\"location\":\"116.964376,36.67149\",\"locatetime\":1686526709000,\"speed\":35},{\"location\":\"116.964154,36.671419\",\"locatetime\":1686526712000,\"speed\":19},{\"location\":\"116.964096,36.671403\",\"locatetime\":1686526715000,\"speed\":2},{\"location\":\"116.964083,36.671389\",\"locatetime\":1686526718000,\"speed\":1},{\"location\":\"116.964063,36.671365\",\"locatetime\":1686526721000,\"speed\":1},{\"location\":\"116.964049,36.671341\",\"locatetime\":1686526724000,\"speed\":1},{\"location\":\"116.964046,36.671324\",\"locatetime\":1686526727000,\"speed\":1},{\"location\":\"116.964046,36.671306\",\"locatetime\":1686526730000,\"speed\":1},{\"location\":\"116.964043,36.671286\",\"locatetime\":1686526733000,\"speed\":0},{\"location\":\"116.964038,36.671268\",\"locatetime\":1686526736000,\"speed\":0},{\"location\":\"116.964029,36.671253\",\"locatetime\":1686526739000,\"speed\":1},{\"location\":\"116.964019,36.671258\",\"locatetime\":1686526742000,\"speed\":0},{\"location\":\"116.964009,36.671262\",\"locatetime\":1686526745000,\"speed\":0},{\"location\":\"116.963997,36.671258\",\"locatetime\":1686526748000,\"speed\":0},{\"location\":\"116.963991,36.671255\",\"locatetime\":1686526751000,\"speed\":0},{\"location\":\"116.963979,36.671253\",\"locatetime\":1686526754000,\"speed\":0},{\"location\":\"116.963964,36.671248\",\"locatetime\":1686526757000,\"speed\":0},{\"location\":\"116.96395,36.671245\",\"locatetime\":1686526760000,\"speed\":0},{\"location\":\"116.963936,36.671241\",\"locatetime\":1686526763000,\"speed\":0},{\"location\":\"116.963867,36.671253\",\"locatetime\":1686526766000,\"speed\":12},{\"location\":\"116.963669,36.671221\",\"locatetime\":1686526769000,\"speed\":25},{\"location\":\"116.963443,36.671147\",\"locatetime\":1686526772000,\"speed\":25},{\"location\":\"116.963258,36.671053\",\"locatetime\":1686526775000,\"speed\":21},{\"location\":\"116.963072,36.670949\",\"locatetime\":1686526778000,\"speed\":26},{\"location\":\"116.962826,36.670812\",\"locatetime\":1686526781000,\"speed\":34},{\"location\":\"116.962531,36.670647\",\"locatetime\":1686526784000,\"speed\":39},{\"location\":\"116.9622,36.670465\",\"locatetime\":1686526787000,\"speed\":44},{\"location\":\"116.961832,36.670279\",\"locatetime\":1686526790000,\"speed\":46},{\"location\":\"116.961497,36.670111\",\"locatetime\":1686526793000,\"speed\":41},{\"location\":\"116.961152,36.669927\",\"locatetime\":1686526796000,\"speed\":46},{\"location\":\"116.960772,36.669718\",\"locatetime\":1686526799000,\"speed\":50}]");
//            parMap.put("points", "[{\"location\":\"116.964091,36.672899\",\"locatetime\":1686526499000,\"speed\":2},{\"location\":\"116.964076,36.672902\",\"locatetime\":1686526500000,\"speed\":2},{\"location\":\"116.964068,36.672903\",\"locatetime\":1686526501000,\"speed\":2},{\"location\":\"116.964052,36.672909\",\"locatetime\":1686526502000,\"speed\":2},{\"location\":\"116.964021,36.672913\",\"locatetime\":1686526503000,\"speed\":4},{\"location\":\"116.964016,36.672908\",\"locatetime\":1686526504000,\"speed\":3},{\"location\":\"116.964038,36.672911\",\"locatetime\":1686526505000,\"speed\":1},{\"location\":\"116.964035,36.672907\",\"locatetime\":1686526506000,\"speed\":1},{\"location\":\"116.964052,36.672905\",\"locatetime\":1686526507000,\"speed\":0},{\"location\":\"116.964036,36.67291\",\"locatetime\":1686526508000,\"speed\":0},{\"location\":\"116.964039,36.672913\",\"locatetime\":1686526509000,\"speed\":1},{\"location\":\"116.964033,36.672913\",\"locatetime\":1686526510000,\"speed\":1},{\"location\":\"116.964029,36.672902\",\"locatetime\":1686526511000,\"speed\":1},{\"location\":\"116.964031,36.672903\",\"locatetime\":1686526512000,\"speed\":1},{\"location\":\"116.964022,36.672907\",\"locatetime\":1686526513000,\"speed\":2},{\"location\":\"116.964004,36.672907\",\"locatetime\":1686526514000,\"speed\":3},{\"location\":\"116.964005,36.67291\",\"locatetime\":1686526515000,\"speed\":2},{\"location\":\"116.964014,36.672914\",\"locatetime\":1686526516000,\"speed\":2},{\"location\":\"116.964017,36.672916\",\"locatetime\":1686526517000,\"speed\":2},{\"location\":\"116.964021,36.672917\",\"locatetime\":1686526518000,\"speed\":2},{\"location\":\"116.964026,36.672917\",\"locatetime\":1686526519000,\"speed\":1},{\"location\":\"116.96401,36.672924\",\"locatetime\":1686526520000,\"speed\":2},{\"location\":\"116.964023,36.672922\",\"locatetime\":1686526521000,\"speed\":1},{\"location\":\"116.964024,36.672928\",\"locatetime\":1686526522000,\"speed\":1},{\"location\":\"116.964023,36.672931\",\"locatetime\":1686526523000,\"speed\":1},{\"location\":\"116.96402,36.672922\",\"locatetime\":1686526524000,\"speed\":1},{\"location\":\"116.964001,36.672924\",\"locatetime\":1686526525000,\"speed\":3},{\"location\":\"116.963995,36.672916\",\"locatetime\":1686526526000,\"speed\":3},{\"location\":\"116.964002,36.672911\",\"locatetime\":1686526527000,\"speed\":1},{\"location\":\"116.964006,36.672906\",\"locatetime\":1686526528000,\"speed\":1},{\"location\":\"116.96402,36.672901\",\"locatetime\":1686526529000,\"speed\":0},{\"location\":\"116.964019,36.672902\",\"locatetime\":1686526530000,\"speed\":1},{\"location\":\"116.964028,36.672902\",\"locatetime\":1686526531000,\"speed\":2},{\"location\":\"116.964039,36.6729\",\"locatetime\":1686526532000,\"speed\":1},{\"location\":\"116.964043,36.672898\",\"locatetime\":1686526533000,\"speed\":0},{\"location\":\"116.964047,36.6729\",\"locatetime\":1686526534000,\"speed\":0},{\"location\":\"116.964044,36.672902\",\"locatetime\":1686526535000,\"speed\":1},{\"location\":\"116.964039,36.672911\",\"locatetime\":1686526536000,\"speed\":2},{\"location\":\"116.964048,36.672915\",\"locatetime\":1686526537000,\"speed\":2},{\"location\":\"116.964055,36.672922\",\"locatetime\":1686526538000,\"speed\":2},{\"location\":\"116.964062,36.672924\",\"locatetime\":1686526539000,\"speed\":2},{\"location\":\"116.96407,36.672923\",\"locatetime\":1686526540000,\"speed\":2},{\"location\":\"116.964075,36.672922\",\"locatetime\":1686526541000,\"speed\":2},{\"location\":\"116.964087,36.672921\",\"locatetime\":1686526542000,\"speed\":3},{\"location\":\"116.964104,36.672915\",\"locatetime\":1686526543000,\"speed\":2},{\"location\":\"116.96412,36.672914\",\"locatetime\":1686526544000,\"speed\":4},{\"location\":\"116.96415,36.672912\",\"locatetime\":1686526545000,\"speed\":3},{\"location\":\"116.964164,36.672914\",\"locatetime\":1686526546000,\"speed\":3},{\"location\":\"116.964172,36.672915\",\"locatetime\":1686526547000,\"speed\":1},{\"location\":\"116.964193,36.672917\",\"locatetime\":1686526548000,\"speed\":0},{\"location\":\"116.964203,36.672918\",\"locatetime\":1686526549000,\"speed\":1},{\"location\":\"116.964223,36.672921\",\"locatetime\":1686526550000,\"speed\":1},{\"location\":\"116.964237,36.672926\",\"locatetime\":1686526551000,\"speed\":1},{\"location\":\"116.964243,36.672925\",\"locatetime\":1686526552000,\"speed\":1},{\"location\":\"116.964249,36.672921\",\"locatetime\":1686526553000,\"speed\":1},{\"location\":\"116.964252,36.672919\",\"locatetime\":1686526554000,\"speed\":1},{\"location\":\"116.964257,36.672916\",\"locatetime\":1686526555000,\"speed\":1},{\"location\":\"116.96426,36.672915\",\"locatetime\":1686526556000,\"speed\":1},{\"location\":\"116.964264,36.672915\",\"locatetime\":1686526557000,\"speed\":1},{\"location\":\"116.964276,36.672916\",\"locatetime\":1686526558000,\"speed\":1},{\"location\":\"116.96428,36.67292\",\"locatetime\":1686526559000,\"speed\":1},{\"location\":\"116.964275,36.67292\",\"locatetime\":1686526560000,\"speed\":0},{\"location\":\"116.964274,36.672921\",\"locatetime\":1686526561000,\"speed\":0},{\"location\":\"116.964273,36.672922\",\"locatetime\":1686526562000,\"speed\":0},{\"location\":\"116.96427,36.672922\",\"locatetime\":1686526563000,\"speed\":0},{\"location\":\"116.964269,36.672921\",\"locatetime\":1686526564000,\"speed\":0},{\"location\":\"116.964267,36.672921\",\"locatetime\":1686526565000,\"speed\":0},{\"location\":\"116.964267,36.672921\",\"locatetime\":1686526566000,\"speed\":0},{\"location\":\"116.964274,36.672922\",\"locatetime\":1686526567000,\"speed\":0},{\"location\":\"116.964281,36.672924\",\"locatetime\":1686526568000,\"speed\":0},{\"location\":\"116.964284,36.672924\",\"locatetime\":1686526569000,\"speed\":1},{\"location\":\"116.964281,36.672922\",\"locatetime\":1686526570000,\"speed\":1},{\"location\":\"116.964273,36.672927\",\"locatetime\":1686526571000,\"speed\":5},{\"location\":\"116.96427,36.672932\",\"locatetime\":1686526572000,\"speed\":2},{\"location\":\"116.96427,36.672932\",\"locatetime\":1686526573000,\"speed\":0},{\"location\":\"116.964264,36.67293\",\"locatetime\":1686526574000,\"speed\":1},{\"location\":\"116.964265,36.672929\",\"locatetime\":1686526575000,\"speed\":0},{\"location\":\"116.964268,36.672927\",\"locatetime\":1686526576000,\"speed\":1},{\"location\":\"116.964271,36.672927\",\"locatetime\":1686526577000,\"speed\":1},{\"location\":\"116.96427,36.672927\",\"locatetime\":1686526578000,\"speed\":1},{\"location\":\"116.964271,36.672924\",\"locatetime\":1686526579000,\"speed\":1},{\"location\":\"116.964271,36.672921\",\"locatetime\":1686526580000,\"speed\":0},{\"location\":\"116.964271,36.67292\",\"locatetime\":1686526581000,\"speed\":0},{\"location\":\"116.96427,36.672918\",\"locatetime\":1686526582000,\"speed\":1},{\"location\":\"116.964272,36.672918\",\"locatetime\":1686526583000,\"speed\":0},{\"location\":\"116.964273,36.672917\",\"locatetime\":1686526584000,\"speed\":0},{\"location\":\"116.964272,36.672915\",\"locatetime\":1686526585000,\"speed\":0},{\"location\":\"116.964273,36.672912\",\"locatetime\":1686526586000,\"speed\":1},{\"location\":\"116.964274,36.67291\",\"locatetime\":1686526587000,\"speed\":1},{\"location\":\"116.964275,36.67291\",\"locatetime\":1686526588000,\"speed\":0},{\"location\":\"116.964273,36.672909\",\"locatetime\":1686526589000,\"speed\":1},{\"location\":\"116.964274,36.672907\",\"locatetime\":1686526590000,\"speed\":0},{\"location\":\"116.964275,36.672905\",\"locatetime\":1686526591000,\"speed\":0},{\"location\":\"116.964274,36.672905\",\"locatetime\":1686526592000,\"speed\":0},{\"location\":\"116.964273,36.672904\",\"locatetime\":1686526593000,\"speed\":0},{\"location\":\"116.964271,36.672903\",\"locatetime\":1686526594000,\"speed\":0},{\"location\":\"116.964271,36.672902\",\"locatetime\":1686526595000,\"speed\":0},{\"location\":\"116.964273,36.672899\",\"locatetime\":1686526596000,\"speed\":1},{\"location\":\"116.964273,36.672897\",\"locatetime\":1686526597000,\"speed\":0},{\"location\":\"116.96427,36.672895\",\"locatetime\":1686526598000,\"speed\":0}]");
//            parMap.put("points", "[{\"location\":\"116.96427,36.672895\",\"locatetime\":1686526599000,\"speed\":0},{\"location\":\"116.96427,36.672898\",\"locatetime\":1686526600000,\"speed\":1},{\"location\":\"116.96427,36.672897\",\"locatetime\":1686526601000,\"speed\":0},{\"location\":\"116.964271,36.672896\",\"locatetime\":1686526602000,\"speed\":0},{\"location\":\"116.964271,36.672895\",\"locatetime\":1686526603000,\"speed\":0},{\"location\":\"116.96427,36.672894\",\"locatetime\":1686526604000,\"speed\":0},{\"location\":\"116.96427,36.672893\",\"locatetime\":1686526605000,\"speed\":0},{\"location\":\"116.96427,36.672892\",\"locatetime\":1686526606000,\"speed\":0},{\"location\":\"116.96427,36.672892\",\"locatetime\":1686526607000,\"speed\":0},{\"location\":\"116.964271,36.672891\",\"locatetime\":1686526608000,\"speed\":0},{\"location\":\"116.964272,36.672891\",\"locatetime\":1686526609000,\"speed\":0},{\"location\":\"116.964272,36.67289\",\"locatetime\":1686526610000,\"speed\":0},{\"location\":\"116.964273,36.67289\",\"locatetime\":1686526611000,\"speed\":0},{\"location\":\"116.964272,36.67289\",\"locatetime\":1686526612000,\"speed\":1},{\"location\":\"116.964272,36.672891\",\"locatetime\":1686526613000,\"speed\":0},{\"location\":\"116.964275,36.672892\",\"locatetime\":1686526614000,\"speed\":0},{\"location\":\"116.964276,36.672891\",\"locatetime\":1686526615000,\"speed\":0},{\"location\":\"116.964276,36.672891\",\"locatetime\":1686526616000,\"speed\":0},{\"location\":\"116.964276,36.672891\",\"locatetime\":1686526617000,\"speed\":0},{\"location\":\"116.964277,36.672891\",\"locatetime\":1686526618000,\"speed\":0},{\"location\":\"116.964277,36.672891\",\"locatetime\":1686526619000,\"speed\":0},{\"location\":\"116.964277,36.67289\",\"locatetime\":1686526620000,\"speed\":0},{\"location\":\"116.964277,36.672891\",\"locatetime\":1686526621000,\"speed\":0},{\"location\":\"116.964277,36.672891\",\"locatetime\":1686526622000,\"speed\":0},{\"location\":\"116.964276,36.672891\",\"locatetime\":1686526623000,\"speed\":0},{\"location\":\"116.964276,36.672891\",\"locatetime\":1686526624000,\"speed\":1},{\"location\":\"116.964275,36.672891\",\"locatetime\":1686526625000,\"speed\":0},{\"location\":\"116.964278,36.672889\",\"locatetime\":1686526626000,\"speed\":1},{\"location\":\"116.964282,36.672888\",\"locatetime\":1686526627000,\"speed\":1},{\"location\":\"116.964287,36.672885\",\"locatetime\":1686526628000,\"speed\":2},{\"location\":\"116.964286,36.672883\",\"locatetime\":1686526629000,\"speed\":1},{\"location\":\"116.964285,36.672883\",\"locatetime\":1686526630000,\"speed\":0},{\"location\":\"116.964284,36.672884\",\"locatetime\":1686526631000,\"speed\":0},{\"location\":\"116.964285,36.672882\",\"locatetime\":1686526632000,\"speed\":1},{\"location\":\"116.964286,36.672882\",\"locatetime\":1686526633000,\"speed\":0},{\"location\":\"116.964289,36.672882\",\"locatetime\":1686526634000,\"speed\":0},{\"location\":\"116.96429,36.672882\",\"locatetime\":1686526635000,\"speed\":0},{\"location\":\"116.964291,36.672881\",\"locatetime\":1686526636000,\"speed\":0},{\"location\":\"116.964292,36.672881\",\"locatetime\":1686526637000,\"speed\":0},{\"location\":\"116.964292,36.672881\",\"locatetime\":1686526638000,\"speed\":0},{\"location\":\"116.964284,36.672874\",\"locatetime\":1686526639000,\"speed\":3},{\"location\":\"116.964284,36.672877\",\"locatetime\":1686526640000,\"speed\":2},{\"location\":\"116.964286,36.672879\",\"locatetime\":1686526641000,\"speed\":1},{\"location\":\"116.964292,36.672881\",\"locatetime\":1686526642000,\"speed\":1},{\"location\":\"116.964297,36.67288\",\"locatetime\":1686526643000,\"speed\":1},{\"location\":\"116.964303,36.67288\",\"locatetime\":1686526644000,\"speed\":2},{\"location\":\"116.964311,36.672882\",\"locatetime\":1686526645000,\"speed\":2},{\"location\":\"116.964314,36.672882\",\"locatetime\":1686526646000,\"speed\":0},{\"location\":\"116.964314,36.672883\",\"locatetime\":1686526647000,\"speed\":0},{\"location\":\"116.964315,36.672882\",\"locatetime\":1686526648000,\"speed\":0},{\"location\":\"116.964317,36.672876\",\"locatetime\":1686526649000,\"speed\":3},{\"location\":\"116.964327,36.672857\",\"locatetime\":1686526650000,\"speed\":9},{\"location\":\"116.964353,36.672843\",\"locatetime\":1686526651000,\"speed\":10},{\"location\":\"116.9644,36.672812\",\"locatetime\":1686526653000,\"speed\":10},{\"location\":\"116.964426,36.672798\",\"locatetime\":1686526654000,\"speed\":10},{\"location\":\"116.964447,36.672794\",\"locatetime\":1686526655000,\"speed\":7},{\"location\":\"116.964474,36.672794\",\"locatetime\":1686526656000,\"speed\":8},{\"location\":\"116.964502,36.672798\",\"locatetime\":1686526657000,\"speed\":9},{\"location\":\"116.964541,36.672804\",\"locatetime\":1686526658000,\"speed\":12},{\"location\":\"116.964588,36.672809\",\"locatetime\":1686526659000,\"speed\":14},{\"location\":\"116.964635,36.672818\",\"locatetime\":1686526660000,\"speed\":15},{\"location\":\"116.96468,36.672835\",\"locatetime\":1686526661000,\"speed\":16},{\"location\":\"116.96474,36.672857\",\"locatetime\":1686526662000,\"speed\":19},{\"location\":\"116.964803,36.672871\",\"locatetime\":1686526663000,\"speed\":21},{\"location\":\"116.964872,36.67289\",\"locatetime\":1686526664000,\"speed\":25},{\"location\":\"116.964943,36.672925\",\"locatetime\":1686526665000,\"speed\":28},{\"location\":\"116.965021,36.672953\",\"locatetime\":1686526666000,\"speed\":28},{\"location\":\"116.965108,36.672987\",\"locatetime\":1686526667000,\"speed\":31},{\"location\":\"116.965201,36.673019\",\"locatetime\":1686526668000,\"speed\":33},{\"location\":\"116.965283,36.673051\",\"locatetime\":1686526669000,\"speed\":30},{\"location\":\"116.96536,36.673076\",\"locatetime\":1686526670000,\"speed\":26},{\"location\":\"116.965415,36.673085\",\"locatetime\":1686526671000,\"speed\":20},{\"location\":\"116.965465,36.673085\",\"locatetime\":1686526672000,\"speed\":16},{\"location\":\"116.965513,36.673075\",\"locatetime\":1686526673000,\"speed\":16},{\"location\":\"116.965548,36.673046\",\"locatetime\":1686526674000,\"speed\":15},{\"location\":\"116.965585,36.673\",\"locatetime\":1686526675000,\"speed\":21},{\"location\":\"116.965622,36.672944\",\"locatetime\":1686526676000,\"speed\":25},{\"location\":\"116.965646,36.672881\",\"locatetime\":1686526677000,\"speed\":26},{\"location\":\"116.965671,36.672822\",\"locatetime\":1686526678000,\"speed\":25},{\"location\":\"116.965697,36.672759\",\"locatetime\":1686526679000,\"speed\":26},{\"location\":\"116.965718,36.672683\",\"locatetime\":1686526680000,\"speed\":29},{\"location\":\"116.965747,36.672605\",\"locatetime\":1686526681000,\"speed\":31},{\"location\":\"116.965782,36.672521\",\"locatetime\":1686526682000,\"speed\":34},{\"location\":\"116.965821,36.672438\",\"locatetime\":1686526683000,\"speed\":35},{\"location\":\"116.965859,36.672355\",\"locatetime\":1686526684000,\"speed\":34},{\"location\":\"116.965887,36.672274\",\"locatetime\":1686526685000,\"speed\":33},{\"location\":\"116.965913,36.672193\",\"locatetime\":1686526686000,\"speed\":33},{\"location\":\"116.965941,36.67212\",\"locatetime\":1686526687000,\"speed\":30},{\"location\":\"116.965966,36.672058\",\"locatetime\":1686526688000,\"speed\":26},{\"location\":\"116.96598,36.672013\",\"locatetime\":1686526689000,\"speed\":18},{\"location\":\"116.965984,36.671993\",\"locatetime\":1686526690000,\"speed\":10},{\"location\":\"116.965992,36.671976\",\"locatetime\":1686526691000,\"speed\":7},{\"location\":\"116.965983,36.671961\",\"locatetime\":1686526692000,\"speed\":6},{\"location\":\"116.965962,36.67195\",\"locatetime\":1686526693000,\"speed\":7},{\"location\":\"116.965901,36.671931\",\"locatetime\":1686526694000,\"speed\":19},{\"location\":\"116.965831,36.671911\",\"locatetime\":1686526695000,\"speed\":24},{\"location\":\"116.965749,36.671881\",\"locatetime\":1686526696000,\"speed\":28},{\"location\":\"116.965652,36.671849\",\"locatetime\":1686526697000,\"speed\":33},{\"location\":\"116.965555,36.671822\",\"locatetime\":1686526698000,\"speed\":34},{\"location\":\"116.965458,36.671791\",\"locatetime\":1686526699000,\"speed\":34}]");
            parMap.put("points", "[{\"location\":\"116.965379,36.671757\",\"locatetime\":1686526700000,\"speed\":31},{\"location\":\"116.965271,36.671727\",\"locatetime\":1686526701000,\"speed\":35},{\"location\":\"116.965152,36.671693\",\"locatetime\":1686526702000,\"speed\":38},{\"location\":\"116.965033,36.671657\",\"locatetime\":1686526703000,\"speed\":39},{\"location\":\"116.964918,36.671627\",\"locatetime\":1686526704000,\"speed\":39},{\"location\":\"116.964809,36.671591\",\"locatetime\":1686526705000,\"speed\":38},{\"location\":\"116.964702,36.671575\",\"locatetime\":1686526706000,\"speed\":35},{\"location\":\"116.964599,36.67155\",\"locatetime\":1686526707000,\"speed\":34},{\"location\":\"116.964494,36.671519\",\"locatetime\":1686526708000,\"speed\":34},{\"location\":\"116.964376,36.67149\",\"locatetime\":1686526709000,\"speed\":35},{\"location\":\"116.964285,36.671464\",\"locatetime\":1686526710000,\"speed\":31},{\"location\":\"116.964202,36.671436\",\"locatetime\":1686526711000,\"speed\":27},{\"location\":\"116.964154,36.671419\",\"locatetime\":1686526712000,\"speed\":19},{\"location\":\"116.964131,36.671428\",\"locatetime\":1686526713000,\"speed\":10},{\"location\":\"116.964108,36.671413\",\"locatetime\":1686526714000,\"speed\":6},{\"location\":\"116.964096,36.671403\",\"locatetime\":1686526715000,\"speed\":2},{\"location\":\"116.964093,36.6714\",\"locatetime\":1686526716000,\"speed\":1},{\"location\":\"116.964088,36.671395\",\"locatetime\":1686526717000,\"speed\":1},{\"location\":\"116.964083,36.671389\",\"locatetime\":1686526718000,\"speed\":1},{\"location\":\"116.964077,36.671383\",\"locatetime\":1686526719000,\"speed\":1},{\"location\":\"116.964072,36.671375\",\"locatetime\":1686526720000,\"speed\":1},{\"location\":\"116.964063,36.671365\",\"locatetime\":1686526721000,\"speed\":1},{\"location\":\"116.964057,36.671356\",\"locatetime\":1686526722000,\"speed\":1},{\"location\":\"116.964053,36.671349\",\"locatetime\":1686526723000,\"speed\":1},{\"location\":\"116.964049,36.671341\",\"locatetime\":1686526724000,\"speed\":1},{\"location\":\"116.964048,36.671335\",\"locatetime\":1686526725000,\"speed\":1},{\"location\":\"116.964046,36.67133\",\"locatetime\":1686526726000,\"speed\":1},{\"location\":\"116.964046,36.671324\",\"locatetime\":1686526727000,\"speed\":1},{\"location\":\"116.964046,36.671318\",\"locatetime\":1686526728000,\"speed\":0},{\"location\":\"116.964047,36.671313\",\"locatetime\":1686526729000,\"speed\":1},{\"location\":\"116.964046,36.671306\",\"locatetime\":1686526730000,\"speed\":1},{\"location\":\"116.964043,36.671298\",\"locatetime\":1686526731000,\"speed\":1},{\"location\":\"116.964044,36.671292\",\"locatetime\":1686526732000,\"speed\":0},{\"location\":\"116.964043,36.671286\",\"locatetime\":1686526733000,\"speed\":0},{\"location\":\"116.964039,36.67128\",\"locatetime\":1686526734000,\"speed\":1},{\"location\":\"116.964038,36.671274\",\"locatetime\":1686526735000,\"speed\":1},{\"location\":\"116.964038,36.671268\",\"locatetime\":1686526736000,\"speed\":0},{\"location\":\"116.964033,36.671263\",\"locatetime\":1686526737000,\"speed\":1},{\"location\":\"116.96403,36.671259\",\"locatetime\":1686526738000,\"speed\":1},{\"location\":\"116.964029,36.671253\",\"locatetime\":1686526739000,\"speed\":1},{\"location\":\"116.964027,36.671248\",\"locatetime\":1686526740000,\"speed\":0},{\"location\":\"116.964022,36.671254\",\"locatetime\":1686526741000,\"speed\":0},{\"location\":\"116.964019,36.671258\",\"locatetime\":1686526742000,\"speed\":0},{\"location\":\"116.964016,36.671261\",\"locatetime\":1686526743000,\"speed\":0},{\"location\":\"116.964012,36.671262\",\"locatetime\":1686526744000,\"speed\":0},{\"location\":\"116.964009,36.671262\",\"locatetime\":1686526745000,\"speed\":0},{\"location\":\"116.964006,36.671262\",\"locatetime\":1686526746000,\"speed\":0},{\"location\":\"116.964002,36.67126\",\"locatetime\":1686526747000,\"speed\":0},{\"location\":\"116.963997,36.671258\",\"locatetime\":1686526748000,\"speed\":0},{\"location\":\"116.963994,36.671257\",\"locatetime\":1686526749000,\"speed\":0},{\"location\":\"116.963991,36.671256\",\"locatetime\":1686526750000,\"speed\":0},{\"location\":\"116.963991,36.671255\",\"locatetime\":1686526751000,\"speed\":0},{\"location\":\"116.96399,36.671252\",\"locatetime\":1686526752000,\"speed\":0},{\"location\":\"116.963985,36.671254\",\"locatetime\":1686526753000,\"speed\":0},{\"location\":\"116.963979,36.671253\",\"locatetime\":1686526754000,\"speed\":0},{\"location\":\"116.963974,36.671251\",\"locatetime\":1686526755000,\"speed\":0},{\"location\":\"116.963968,36.67125\",\"locatetime\":1686526756000,\"speed\":0},{\"location\":\"116.963964,36.671248\",\"locatetime\":1686526757000,\"speed\":0},{\"location\":\"116.963959,36.671247\",\"locatetime\":1686526758000,\"speed\":0},{\"location\":\"116.963955,36.671247\",\"locatetime\":1686526759000,\"speed\":0},{\"location\":\"116.96395,36.671245\",\"locatetime\":1686526760000,\"speed\":0},{\"location\":\"116.963945,36.671244\",\"locatetime\":1686526761000,\"speed\":0},{\"location\":\"116.963941,36.671242\",\"locatetime\":1686526762000,\"speed\":0},{\"location\":\"116.963936,36.671241\",\"locatetime\":1686526763000,\"speed\":0},{\"location\":\"116.963929,36.671242\",\"locatetime\":1686526764000,\"speed\":3},{\"location\":\"116.963903,36.67124\",\"locatetime\":1686526765000,\"speed\":8},{\"location\":\"116.963867,36.671253\",\"locatetime\":1686526766000,\"speed\":12},{\"location\":\"116.963812,36.671255\",\"locatetime\":1686526767000,\"speed\":17},{\"location\":\"116.96375,36.671248\",\"locatetime\":1686526768000,\"speed\":19},{\"location\":\"116.963669,36.671221\",\"locatetime\":1686526769000,\"speed\":25},{\"location\":\"116.963591,36.671201\",\"locatetime\":1686526770000,\"speed\":26},{\"location\":\"116.963513,36.671174\",\"locatetime\":1686526771000,\"speed\":27},{\"location\":\"116.963443,36.671147\",\"locatetime\":1686526772000,\"speed\":25},{\"location\":\"116.963375,36.671119\",\"locatetime\":1686526773000,\"speed\":25},{\"location\":\"116.963313,36.671086\",\"locatetime\":1686526774000,\"speed\":23},{\"location\":\"116.963258,36.671053\",\"locatetime\":1686526775000,\"speed\":21},{\"location\":\"116.963204,36.671019\",\"locatetime\":1686526776000,\"speed\":21},{\"location\":\"116.963142,36.670986\",\"locatetime\":1686526777000,\"speed\":23},{\"location\":\"116.963072,36.670949\",\"locatetime\":1686526778000,\"speed\":26},{\"location\":\"116.962996,36.670909\",\"locatetime\":1686526779000,\"speed\":29},{\"location\":\"116.962914,36.670864\",\"locatetime\":1686526780000,\"speed\":32},{\"location\":\"116.962826,36.670812\",\"locatetime\":1686526781000,\"speed\":34},{\"location\":\"116.962732,36.670759\",\"locatetime\":1686526782000,\"speed\":36},{\"location\":\"116.962634,36.670704\",\"locatetime\":1686526783000,\"speed\":37},{\"location\":\"116.962531,36.670647\",\"locatetime\":1686526784000,\"speed\":39},{\"location\":\"116.962424,36.670589\",\"locatetime\":1686526785000,\"speed\":41},{\"location\":\"116.962313,36.670528\",\"locatetime\":1686526786000,\"speed\":42},{\"location\":\"116.9622,36.670465\",\"locatetime\":1686526787000,\"speed\":44},{\"location\":\"116.96208,36.670402\",\"locatetime\":1686526788000,\"speed\":45},{\"location\":\"116.961956,36.67034\",\"locatetime\":1686526789000,\"speed\":46},{\"location\":\"116.961832,36.670279\",\"locatetime\":1686526790000,\"speed\":46},{\"location\":\"116.961715,36.670222\",\"locatetime\":1686526791000,\"speed\":42},{\"location\":\"116.961605,36.670167\",\"locatetime\":1686526792000,\"speed\":40},{\"location\":\"116.961497,36.670111\",\"locatetime\":1686526793000,\"speed\":41},{\"location\":\"116.961386,36.670052\",\"locatetime\":1686526794000,\"speed\":42},{\"location\":\"116.961272,36.66999\",\"locatetime\":1686526795000,\"speed\":44},{\"location\":\"116.961152,36.669927\",\"locatetime\":1686526796000,\"speed\":46},{\"location\":\"116.961028,36.669859\",\"locatetime\":1686526797000,\"speed\":47},{\"location\":\"116.960901,36.669789\",\"locatetime\":1686526798000,\"speed\":49},{\"location\":\"116.960772,36.669718\",\"locatetime\":1686526799000,\"speed\":50}]");
            String myUrl="https://tsapi.amap.com/v1/track/point/upload";
            String result=RetrofitDemoImpl.post1(myUrl,parMap);
            log.debug("{}",result);
            //{"data":{"errorpoints":[]},"errcode":10000,"errdetail":null,"errmsg":"OK"}
        }catch(Exception e){
            log.error("trace point upload error:",e);
        }
    }

    @Test
    public void traceDel(){
        try{
            Map<String, Object> parMap=new HashMap<>();
            parMap.put("key", key);
            parMap.put("sid", "956951");
            parMap.put("tid", "709305612");
            parMap.put("trid", "40");
            String myUrl="https://tsapi.amap.com/v1/track/trace/delete";
            String result=RetrofitDemoImpl.post1(myUrl,parMap);
            log.debug("{}",result);
            //{"data":null,"errcode":10000,"errdetail":null,"errmsg":"OK"}
        }catch(Exception e){
            log.error("trace delete error:",e);
        }
    }


    @Test
    public void traceSearch(){
        try{
            //有过滤
            String myUrl="https://tsapi.amap.com/v1/track/terminal/trsearch?key="+key+"&sid=956951&tid=709305612&trid=120&correction=denoise=1,mapmatch=1,mode=driving&recoup=1&gap=50&pagesize=999";
            //无过滤
//            String myUrl="https://tsapi.amap.com/v1/track/terminal/trsearch?key="+key+"&sid=956951&tid=709305612&trid=100&correction=denoise=0,mapmatch=1,mode=driving&pagesize=999";
            String result=RetrofitDemoImpl.get1(myUrl);
            log.debug("{}",result);
            //{"data":{"counts":1,"tracks":[{"counts":0,"degradedParams":{},"distance":0,"points":[],"time":0,"trid":40,"trname":"车辆2轨迹1"}]},"errcode":10000,"errdetail":null,"errmsg":"OK"}
            //{"data":{"counts":1,"tracks":[{"counts":2,"degradedParams":{},"distance":13,"endPoint":{"locatetime":1686823313000,"location":"116.397435,39.90935"},"points":[{"accuracy":20.0,"direction":120.0,"height":39.0,"locatetime":1686823295000,"location":"116.397428,39.90923","speed":40.0},{"accuracy":20.0,"direction":110.0,"height":39.0,"locatetime":1686823313000,"location":"116.397435,39.90935","speed":40.0}],"startPoint":{"locatetime":1686823295000,"location":"116.397428,39.90923"},"time":18000,"trid":40,"trname":"车辆2轨迹1"}]},"errcode":10000,"errdetail":null,"errmsg":"OK"}
            //{"data":{"counts":1,"tracks":[{"counts":96,"degradedParams":{},"distance":840,"endPoint":{"locatetime":1686526799000,"location":"116.960772,36.669718"},"points":[{"accuracy":550.0,"direction":511.0,"locatetime":1686526501000,"location":"116.964068,36.672903","speed":2.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526507000,"location":"116.964052,36.672905","speed":0.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526510000,"location":"116.964033,36.672913","speed":1.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526513000,"location":"116.964022,36.672907","speed":2.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526516000,"location":"116.964014,36.672914","speed":2.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526519000,"location":"116.964026,36.672917","speed":1.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526522000,"location":"116.964024,36.672928","speed":1.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526525000,"location":"116.964001,36.672924","speed":3.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526528000,"location":"116.964006,36.672906","speed":1.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526531000,"location":"116.964028,36.672902","speed":2.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526534000,"location":"116.964047,36.6729","speed":0.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526537000,"location":"116.964048,36.672915","speed":2.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526540000,"location":"116.96407,36.672923","speed":2.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526543000,"location":"116.964104,36.672915","speed":2.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526546000,"location":"116.964164,36.672914","speed":3.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526549000,"location":"116.964203,36.672918","speed":1.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526552000,"location":"116.964243,36.672925","speed":1.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526555000,"location":"116.964257,36.672916","speed":1.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526558000,"location":"116.964276,36.672916","speed":1.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526561000,"location":"116.964274,36.672921","speed":0.0}],"startPoint":{"locatetime":1686526501000,"location":"116.964068,36.672903"},"time":298000,"trid":80,"trname":"车辆2轨迹1"}]},"errcode":10000,"errdetail":null,"errmsg":"OK"}
        }catch(Exception e){
            log.error("trace search error:",e);
        }
    }

    @Test
    public void traceSearchByDate(){
        try{
            int trid=140; //trid与startTime,endTime二选1查询，使用startTime时必须填入endTime
            long startTime=1686537300000L;//开始时间，Unix时间戳（轨迹点的定位时间）,需要精准到毫秒
            long endTime=1686538800000L; //结束时间，Unix时间戳（轨迹点的定位时间）,需要精准到毫秒 结束时间不能大于当前时间，且距离开始时间不能超过24小时。 若轨迹较多，建议将时间段进行拆分。
            //有过滤
            String myUrl="https://tsapi.amap.com/v1/track/terminal/trsearch?key="+key+"&sid=956951&tid=709305612&correction=denoise=1,mapmatch=1,mode=driving&recoup=1&gap=50&pagesize=900&starttime="+startTime+"&endtime="+endTime;
//            String myUrl="https://tsapi.amap.com/v1/track/terminal/trsearch?key="+key+"&sid=956951&tid=709305612&trid="+trid+"&correction=denoise=1,mapmatch=1,mode=driving&recoup=1&gap=50&pagesize=900";
            String result=RetrofitDemoImpl.get1(myUrl);
            log.debug("{}",result);
            //{"data":{"counts":1,"tracks":[{"counts":0,"degradedParams":{},"distance":0,"points":[],"time":0,"trid":40,"trname":"车辆2轨迹1"}]},"errcode":10000,"errdetail":null,"errmsg":"OK"}
            //{"data":{"counts":1,"tracks":[{"counts":2,"degradedParams":{},"distance":13,"endPoint":{"locatetime":1686823313000,"location":"116.397435,39.90935"},"points":[{"accuracy":20.0,"direction":120.0,"height":39.0,"locatetime":1686823295000,"location":"116.397428,39.90923","speed":40.0},{"accuracy":20.0,"direction":110.0,"height":39.0,"locatetime":1686823313000,"location":"116.397435,39.90935","speed":40.0}],"startPoint":{"locatetime":1686823295000,"location":"116.397428,39.90923"},"time":18000,"trid":40,"trname":"车辆2轨迹1"}]},"errcode":10000,"errdetail":null,"errmsg":"OK"}
            //{"data":{"counts":1,"tracks":[{"counts":96,"degradedParams":{},"distance":840,"endPoint":{"locatetime":1686526799000,"location":"116.960772,36.669718"},"points":[{"accuracy":550.0,"direction":511.0,"locatetime":1686526501000,"location":"116.964068,36.672903","speed":2.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526507000,"location":"116.964052,36.672905","speed":0.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526510000,"location":"116.964033,36.672913","speed":1.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526513000,"location":"116.964022,36.672907","speed":2.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526516000,"location":"116.964014,36.672914","speed":2.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526519000,"location":"116.964026,36.672917","speed":1.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526522000,"location":"116.964024,36.672928","speed":1.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526525000,"location":"116.964001,36.672924","speed":3.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526528000,"location":"116.964006,36.672906","speed":1.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526531000,"location":"116.964028,36.672902","speed":2.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526534000,"location":"116.964047,36.6729","speed":0.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526537000,"location":"116.964048,36.672915","speed":2.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526540000,"location":"116.96407,36.672923","speed":2.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526543000,"location":"116.964104,36.672915","speed":2.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526546000,"location":"116.964164,36.672914","speed":3.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526549000,"location":"116.964203,36.672918","speed":1.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526552000,"location":"116.964243,36.672925","speed":1.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526555000,"location":"116.964257,36.672916","speed":1.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526558000,"location":"116.964276,36.672916","speed":1.0},{"accuracy":550.0,"direction":511.0,"locatetime":1686526561000,"location":"116.964274,36.672921","speed":0.0}],"startPoint":{"locatetime":1686526501000,"location":"116.964068,36.672903"},"time":298000,"trid":80,"trname":"车辆2轨迹1"}]},"errcode":10000,"errdetail":null,"errmsg":"OK"}
        }catch(Exception e){
            log.error("trace search error:",e);
        }
    }

}
