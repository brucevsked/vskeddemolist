package com.vsked.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class BaseService {
	
    public void rollBack(Exception e,Logger logx){
		//手工回滚事务防止出现不跳页
    	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		logx.error(e.getMessage(),e);
		e.printStackTrace();
    }
}
