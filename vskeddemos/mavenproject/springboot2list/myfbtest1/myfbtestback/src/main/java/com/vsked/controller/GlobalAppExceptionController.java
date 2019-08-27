package com.vsked.controller;

import com.vsked.common.DateTimeTool;
import com.vsked.common.RespCode;
import com.vsked.common.RespMsg;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常拦截器
 */
@Slf4j
@ControllerAdvice
public class GlobalAppExceptionController {
	
	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public String globalException(Exception e){
		StringBuffer sb=new StringBuffer();
		sb.append("{");
		sb.append("\"code\":\""+ RespCode.serverException+"\",");
		sb.append("\"msg\":\""+ RespMsg.serverException+"\",");
		sb.append("\"servertime\":\""+ DateTimeTool.getCurDateTime()+"\"");
		sb.append("");
		sb.append("}");
		String result=sb.toString();
		log.error(result+"|"+e.getMessage(),e);
		return result;
	}

}
