package com.vsked.aop;

import com.vsked.tool.MDCTool;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MDCAop {

    @Pointcut("execution(public * com..vsked..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void before(JoinPoint joinPoint){
        MDCTool.beginTrace("_"+MDCTool.getTraceId());//规则为_唯一标识
    }

    @AfterReturning(pointcut = "webLog()", returning = "ret")
    public void afterReturning(Object ret){
        MDC.remove(MDCTool.TRACE_KEY);
    }

}
