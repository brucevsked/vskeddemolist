package com.vsked.file;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

public class AmountTest {

    private static final Logger log = LoggerFactory.getLogger(AmountTest.class);

    public static void main(String[] args) {
        try {
            String fileName = "d:/readme1.txt";
            List<String> dataList = FileUtils.readLines(new File(fileName), "utf-8");
            for(String lineData:dataList){
                //log.info(lineData);
                String[] tmpArray=lineData.split(",");
                String tp=tmpArray[1];
                if("0".equals(tp)){//-
                    BigDecimal b1=new BigDecimal(new String(tmpArray[2]));
                    BigDecimal b2=new BigDecimal(new String(tmpArray[3]));
                    BigDecimal b3=b1.subtract(b2);
                    BigDecimal b4=new BigDecimal(new String(tmpArray[4]));
                    log.info("{}|{}",b3,b4);
                    if(b3.compareTo(b4)!=0){
                        log.info(tmpArray[0]);
                    }
                }else if("1".equals(tp)){//+
                    BigDecimal b1=new BigDecimal(new String(tmpArray[2]));
                    BigDecimal b2=new BigDecimal(new String(tmpArray[3]));
                    BigDecimal b3=b1.add(b2);
                    BigDecimal b4=new BigDecimal(new String(tmpArray[4]));
                    log.info("{}|{}",b3,b4);
                    if(b3.compareTo(b4)!=0){
                        log.info(tmpArray[0]);
                    }
                }else{
                    log.info("----------谁也不知道");
                }
            }
        }catch (Exception e){
            log.error("异常了",e);
        }
    }
}
