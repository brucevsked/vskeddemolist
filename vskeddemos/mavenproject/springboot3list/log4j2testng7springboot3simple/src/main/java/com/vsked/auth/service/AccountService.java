package com.vsked.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
}
