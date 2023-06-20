package com.vsked.text;

import com.vsked.http.GaoDeTest;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class GaoDeGenerate {
    private static final Logger log = LoggerFactory.getLogger(GaoDeGenerate.class);

    @Test
    public void getData() {
        log.trace(" start read file");
        try {
            String fileName = "j:/alog.txt";
            List<String> dataList = FileUtils.readLines(new File(fileName), "utf-8");
            int count=0;
            String curData="";
            int curPos=0;

            DateTimeFormatter dtf=DateTimeFormatter.ofPattern("ddMMyyHHmmss.SS").withZone(ZoneId.of("UTC+00:00"));
            ZonedDateTime zdt;

            List<String> locationList=new LinkedList<>();

            for(String data:dataList){
                curPos=data.indexOf("GCJ02:");
                if(curPos>0){
                    count=count+1;
//                    if(count%3==0){
                        curData=data.substring(curPos+6);
                        //System.out.println(curData);
                        String[] dataArray=curData.split(",");

                        double latitude=new BigDecimal(dataArray[6]).setScale(6, RoundingMode.HALF_UP ).doubleValue();//纬度
                        double longitude=new BigDecimal(dataArray[8]).setScale(6, RoundingMode.HALF_UP ).doubleValue();//经度

                        if(latitude==0 || longitude==0){
                            continue;
                        }

                        String location="\"location\":\""+longitude+","+latitude+"\""+",";
//                        System.out.println(location);
                        zdt=ZonedDateTime.parse(dataArray[1]+dataArray[2],dtf);
//                        System.out.println(zdt);

                    ZoneId shangHaiZid=ZoneId.of("Asia/Shanghai");
                    ZonedDateTime shangHaiZDT=zdt.withZoneSameInstant(shangHaiZid); //时区转换
//                    System.out.println(shangHaiZDT);
                        Timestamp timestamp = Timestamp.from(shangHaiZDT.toInstant());
                        String locatetime="\"locatetime\":"+timestamp.getTime()+",";
                        System.out.println(locatetime);
                        String speed="\"speed\":"+new BigDecimal(dataArray[11]).setScale(0, RoundingMode.HALF_UP ).intValue()+"";
//                        System.out.println(speed);
                        String result="{"+location+locatetime+speed+"}";
                        locationList.add(result);
//                    }//end c3
                }

            }

            String sendData="";

            for(int i=0;i<locationList.size();i++){
                sendData=sendData+locationList.get(i)+",";
                if(i%100==0 || i==locationList.size()-1){
                    sendData=sendData.substring(0,sendData.length()-1);//去最后的逗号
                    sendData="["+sendData+"]";
                    GaoDeTest.tracePointUpload(sendData);
                    Thread.sleep(1200);
                    sendData="";
                }
            }


//            log.debug("data count:{}",count);
        } catch (Exception e) {
            log.error("generate error:", e);
        }

    }

}
