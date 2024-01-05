package com.jat.auth.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	private static final Logger log = LoggerFactory.getLogger(AccountService.class);
	
    public String getAccountId(){
        if(log.isTraceEnabled()){
            log.trace("start");
        }

        String accountId="jinan37001";
        if(log.isInfoEnabled()){
            log.info("account id is:{}",accountId);
        }

        if(log.isTraceEnabled()){
            log.trace("end");
        }
        return accountId;
    }
    
    @Cacheable(cacheNames = "accountList", key = "'accountT901'")
    public List<String> getAccountList(){
        return getStrings();
    }

    private List<String> getStrings() {
        List<String> dataList = new LinkedList<String>();
        Random ran = new Random();
        dataList.add("test"+ran.nextInt(100));
        dataList.add("bad"+ran.nextInt(100));
        dataList.add("good"+ran.nextInt(100));
        return dataList;
    }

    @Cacheable(cacheNames = "accountList1", key = "#ac1")
    public List<String> getAccountList1(String ac1){
        return getStrings();
    }
    
}
