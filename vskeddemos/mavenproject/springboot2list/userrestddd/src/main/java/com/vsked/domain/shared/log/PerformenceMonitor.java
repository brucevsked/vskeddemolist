package com.vsked.domain.shared.log;

import java.util.concurrent.TimeUnit;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *切面类统计每个方法执行了多长时间 
 * @author brucevsked
 *
 */
@Aspect
@Component
public class PerformenceMonitor {

    private static final Logger log = LoggerFactory.getLogger(PerformenceMonitor.class);
	
    @Pointcut("execution(* com.vsked..*.*(..))")    
    private void pointCutMethod() {    
    }
    
    //声明环绕通知    
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
