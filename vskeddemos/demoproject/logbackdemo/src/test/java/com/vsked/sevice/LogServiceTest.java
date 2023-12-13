package com.vsked.sevice;


import com.vsked.service.LogService;
import com.vsked.service.MDCTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LogServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(LogServiceTest.class);

    @Test
    public void test1(){
        MDCTool.beginTrace();
        logger.trace("start test1");
        LogService logService=new LogService();
        logService.testLog();
        MDCTool.endTrace();
    }
}
