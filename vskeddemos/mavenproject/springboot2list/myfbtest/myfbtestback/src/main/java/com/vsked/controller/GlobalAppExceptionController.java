package com.vsked.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalAppExceptionController {
	
	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public String globalException(Exception e){
		String result=e.getMessage();
		log.error(result+"|"+e.getMessage(),e);
		return result;
	}

}
