package com.jat.java;

import com.jat.web.admin.DTO.AccountDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.time.Instant;

public class BaseTest {
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @Test
    public void recordTest(){
        AccountDTO accountDTO=new AccountDTO("admin","123456");
        log.debug("{}",accountDTO);
        log.debug("{}",accountDTO.name());
        log.debug("{}",accountDTO.password());
    }

    @Test
    public void forTest(){
        for(int i=0;i<10;i++){
            if(i%2==0){
                continue;
            }
            log.debug("{}",i);
        }
    }

    @Test
    public void unixTimeStampSeconds(){
        long unixTime= Instant.now().getEpochSecond();//10
        log.debug("{}",unixTime);//1687224795
    }

    @Test
    public void unixTimeStampMillis(){
        long unixTime= System.currentTimeMillis();//13
        log.debug("{}",unixTime);//1687224880966
    }
}
