package com.jat.test1;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class ByteBuddyTest1 {

    private static final Logger log = LoggerFactory.getLogger(ByteBuddyTest1.class);

    @Test
    public void test1(){
        DynamicType.Unloaded<?> dynamicType = new ByteBuddy()
                // 生成 Object的子类
                .subclass(Object.class)
                // 生成类的名称为"com.vsked.Type"
                .name("com.vsked.Type")
                .make();
        log.info("------------create success test1");
    }

    @Test
    public void test2(){
        Class<?> dynamicClazz = new ByteBuddy()
                // 生成 Object的子类
                .subclass(Object.class)
                // 生成类的名称为"com.vsked.Type1"
                .name("com.vsked.Type1")
                .make()
                .load(ByteBuddy.class.getClassLoader(),
                        //使用WRAPPER 策略加载生成的动态类型
                        ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();
        log.info("------------create success test2");
    }

    @Test
    public void test3() throws Exception {
        // 创建ByteBuddy对象
        String str = new ByteBuddy()
                // subclass增强方式
                .subclass(Object.class)
                // 新类型的类名
                .name("com.vsked.Type3")
                // 拦截其中的toString()方法
                .method(ElementMatchers.named("toString"))
                // 让toString()方法返回固定值
                .intercept(FixedValue.value("Hello World!"))
                .make()
                // 加载新类型，默认WRAPPER策略
                .load(ByteBuddy.class.getClassLoader())
                .getLoaded()
                // 通过 Java反射创建 com.xxx.Type实例
                .newInstance()
                // 调用 toString()方法
                .toString();
        log.info("------------create success test3");

        // 指定方法名称
        //ElementMatchers.named("toString")
        // 指定方法的返回值
        //.and(ElementMatchers.returns(String.class))
        // 指定方法参数
        //.and(ElementMatchers.takesArguments(0));
    }
}
