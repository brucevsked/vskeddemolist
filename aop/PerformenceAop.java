package com.vsked.config;

import java.util.concurrent.TimeUnit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformenceAop {

    private static final Logger log = LoggerFactory.getLogger(PerformenceAop.class);

    @Pointcut("execution(* com.vsked.web..*.*(..)) || execution(* com.vsked.service..*.*(..))")
    private void pointCutMethod() {
    }

   @Around("pointCutMethod()")
   public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
       long begin = System.nanoTime();
       Object o = pjp.proceed();
       long end = System.nanoTime();
       if(log.isDebugEnabled()){
    	   log.debug("{"+pjp.getTarget().getClass()+"."+pjp.getSignature().getName()
    			   +"}:{"+TimeUnit.NANOSECONDS.toSeconds(end-begin)+"s"+"}");
       }
       return o;
   }
}
