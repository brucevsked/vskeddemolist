package com.vsked.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionController.class);
	
	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public String globalException(Exception e){
        String result= "{" +
                "\"code\":\"" + -1 + "\"," +
                "\"msg\":\"服务端发生异常" + e.getMessage() + ",请联系管理员\"," +
                "\"data\":\"" + "\"" +
                "}";
		log.error(result,e);
		return result;
	}

}
