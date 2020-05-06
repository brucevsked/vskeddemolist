package com.vsked.domain.shared.web;

import com.vsked.domain.shared.model.RespModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@ControllerAdvice
public class GlobalExceptionController {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionController.class);
	
	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public String globalException(Exception e){

		StringBuffer sb=new StringBuffer();
		sb.append("{");
		sb.append("\"code\":\""+-1+"\",");
		sb.append("\"msg\":\"服务端发生异常"+e.getMessage()+",请联系管理员\",");
		sb.append("\"data\":\""+""+"\"");
		sb.append("");
		sb.append("}");
		String result=sb.toString();
		log.error(result+"|"+e.getMessage(),e);
		return result;
	}

}
