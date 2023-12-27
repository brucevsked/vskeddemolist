package com.jat.demo1;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class MyInterceptor implements MethodInterceptor {

    private static final Logger log = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public Object intercept(Object obj, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        log.info("方法{}调用前",method.getName());
        Object result=methodProxy.invokeSuper(obj,params);
        log.info("方法{}调用后",method.getName());
        return result;
    }
}
