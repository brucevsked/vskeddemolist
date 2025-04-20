package com.vsked.tool;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class MDCAop {
	
    @Pointcut("execution(public * com..*.web..*.*(..))")
    public void webLog(){}
    
    @Before("webLog()")
    public void before(JoinPoint joinPoint){
    	RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String token = request.getParameter("token");
        if(StringUtils.isBlank(token)){
        	MDCTool.beginTrace("_"+MDCTool.getTraceId());//规则为_唯一标识
        }else{
            //String phone=(String) redisTemplate.opsForValue().get(token);
            String phone="1888888888";
            MDCTool.beginTrace(phone+"_"+MDCTool.getTraceId());//规则为用户名_唯一标识
        }

    }
    
    @AfterReturning(pointcut = "webLog()", returning = "ret")
    public void afterReturning(Object ret){
        MDC.remove(MDCTool.TRACE_KEY);
    }



    @Pointcut("execution(public * com..*.task..*.*(..))")
    public void taskLog(){}

    @Before("taskLog()")
    public void beforeTaskLog(JoinPoint joinPoint){
            MDCTool.beginTrace("_"+MDCTool.getTraceId());//规则为_唯一标识


    }

    @AfterReturning(pointcut = "taskLog()", returning = "ret")
    public void afterReturningTaskLog(Object ret){
        MDC.remove(MDCTool.TRACE_KEY);
    }

}
