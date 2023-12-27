package com.jat.interceptor;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.Super;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.implementation.bind.annotation.This;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class LogInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LogInterceptor.class);

    @RuntimeType //将返回值转换成具体的方法返回值类型,加了这个注解 intercept 方法才会被执行
    public  Object intercept(
            // 被拦截的目标对象 （动态生成的目标对象）
            @This Object target,
            // 正在执行的方法Method 对象（目标对象父类的Method）
            @Origin Method method,
            // 正在执行的方法的全部参数
            @AllArguments Object[] argumengts,
            // 目标对象的一个代理
            @Super Object delegate,
            // 方法的调用者对象 对原始方法的调用依靠它
            @SuperCall Callable<?> callable) throws Exception {

        //目标方法执行前执行日志记录
        log.debug("准备执行Method="+method.getName());

        // 调用目标方法
        Object result = callable.call();

        //目标方法执行后执行日志记录
        log.debug("方法执行完成Method="+method.getName());

        return result;
    }
}
