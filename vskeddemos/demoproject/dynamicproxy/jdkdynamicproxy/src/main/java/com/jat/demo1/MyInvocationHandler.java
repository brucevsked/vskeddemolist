package com.jat.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private static final Logger log = LoggerFactory.getLogger(MyInvocationHandler.class);

    private Object target=null;//目标对象

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("{}方法调用前",method.getName());
        Object result=method.invoke(target,args);
        log.info("{}方法调用后",method.getName());
        return result;
    }
}
