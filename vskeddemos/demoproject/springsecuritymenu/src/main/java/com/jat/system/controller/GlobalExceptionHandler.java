package com.jat.system.controller;

import com.jat.system.model.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	//全局异常捕捉
    @ExceptionHandler(value=Exception.class)
    public String globalException(Exception e){
        return new JsonResult("500",e.getMessage())+"";
    }
}
