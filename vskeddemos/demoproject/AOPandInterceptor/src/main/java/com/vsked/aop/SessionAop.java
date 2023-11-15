package com.vsked.aop;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class SessionAop {
	
	private static final Logger log = LoggerFactory.getLogger(SessionAop.class);

    @Pointcut("execution(public * com..*.web..*.*(..))")
    public void checkPermession(){}
    
    @Before("checkPermession()")
    public void before(JoinPoint joinPoint){
    	log.info(" enter before");
    	RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String token = request.getParameter("token");
        log.info(token);
        
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        
        String id=request.getParameter("id");
        if(id==null) {
        	try {
        	PrintWriter writer=response.getWriter();
        	writer.write("{\"code\":\"9999\",\"msg\":\"please give me id parameter\"}");
        	writer.flush();
        	}catch(Exception e) {
        		log.error(e.getMessage(),e);
        	}
        }
        
    }
    
    @AfterReturning(pointcut = "checkPermession()", returning = "ret")
    public void afterReturning(Object ret){
    	log.info(" after return");
    }
}
