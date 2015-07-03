package com.vsked.test.userservice;

import org.aspectj.lang.ProceedingJoinPoint;  
import org.aspectj.lang.annotation.Around;  
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Pointcut;  
import org.springframework.stereotype.Component;  
   
   
 @Aspect  
 @Component  
 public class LogInterceptor {  
   
     @Pointcut("execution(public * com.vsked..*.addUser(..))")  
     public void aApplogic() {}  
   
     @Around(value = "aApplogic() && @annotation(annotation) &&args(object,..) ", argNames = "annotation,object")  
     public Object interceptorApplogic(ProceedingJoinPoint pj,BussAnnotation annotation, Object object) throws Throwable {  
         System.out.println("LogInterceptor_moduleName:"+annotation.moduleName());  
         System.out.println("LogInterceptor_option:"+annotation.option());  
         pj.proceed();  
         return object;  
     }  
 } 

