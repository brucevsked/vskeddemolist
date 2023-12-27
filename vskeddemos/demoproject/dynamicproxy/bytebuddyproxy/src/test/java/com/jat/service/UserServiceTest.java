package com.jat.service;

import com.jat.interceptor.LogInterceptor;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class UserServiceTest {

    private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<? extends UserService> aClass = new ByteBuddy()
                // 创建一个UserService 的子类
                .subclass(UserService.class)
                //指定类的名称
                .name("com.jat.service.UserServiceImpl")
                // 指定要拦截的方法
                .method(ElementMatchers.isDeclaredBy(UserService.class))
                //.method(ElementMatchers.named("address").and(ElementMatchers.returns(String.class).and(ElementMatchers.takesArguments(1))))
                // 为方法添加拦截器 如果拦截器方法是静态的 这里可以传 LogInterceptor.class
                .intercept(MethodDelegation.to(new LogInterceptor()))
                // 动态创建对象，但还未加载
                .make()
                // 设置类加载器 并指定加载策略(默认WRAPPER)
                .load(ByteBuddy.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                // 开始加载得到 Class
                .getLoaded();
        UserService userService = aClass.newInstance();

        log.debug(userService.username());
        log.debug(userService.address("老衲测试1"));
        log.debug(userService.address("老衲不测试","济南天热了"));
    }

    @Test
    public void login(){

    }
}
