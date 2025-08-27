package com.vsked.domain.shared.log;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class MDCAop {
	
    // @Autowired
    //RedisTemplate<String, Object> redisTemplate;
	
    @Pointcut("execution(public * com..vsked.web..*.*(..))")
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

}
