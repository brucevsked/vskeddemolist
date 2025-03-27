package com.jat.controller;

import com.jat.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	//全局异常捕捉
    @ExceptionHandler(value=Exception.class)
    public String globalException(Exception e){
        String msg=e.getMessage();
        log.error("{}",msg);
        msg=msg.replace("\"","\\\"");
        log.error("{}",msg);
        String responseStr=new Response(9999,msg)+"";
        log.error("{}",responseStr);
        return responseStr;
    }
}
