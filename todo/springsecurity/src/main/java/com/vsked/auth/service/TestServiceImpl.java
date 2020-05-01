package com.vsked.auth.service;

import com.vsked.auth.model.RespModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    private static final Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

    public String test1(){
        RespModel test1Model=new RespModel("0","测试成功","这里没有数据");
        log.debug("|"+test1Model.toString()+"|");
        return test1Model.toString();
    }
}
