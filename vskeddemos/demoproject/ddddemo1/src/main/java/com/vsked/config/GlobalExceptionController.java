package com.vsked.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局异常拦截器
 */
@ControllerAdvice
public class GlobalExceptionController {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionController.class);
	
	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public String globalException(Exception e){
		String result="{\"code\":\"9999\",\"msg\":\"服务器异常，请联系管理员。异常信息："+e.getMessage()+"\"}";
		log.error(result,e);
		return result;
	}

}
