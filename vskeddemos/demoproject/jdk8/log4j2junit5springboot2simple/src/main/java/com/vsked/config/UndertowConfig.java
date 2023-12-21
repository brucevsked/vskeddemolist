//package com.vsked.config;
//
//import io.undertow.Undertow;
//import io.undertow.UndertowOptions;
//import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
//import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 必须要 开启这个配置
// * 才能在 访问日志里 打印响应时间
// * TODO 至于 undertow 为什么 不默认开启这个配置
// * TODO 是因为 开启后 会对性能造成影响
// * 在 spring boot(2.0) 要开启这个配置 需要通过代码 进行配置
// *
// * @Date : 2021/5/14 10:08
// * @Created by developer3
// */
//@Configuration
//public class UndertowConfig {
//
//    /**
//     * 开启 undertow 计时
//     *
//     * @return
//     */
//    @Bean
//    public UndertowServletWebServerFactory undertowServletWebServerFactory() {
//        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
//        factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
//            @Override
//            public void customize(Undertow.Builder builder) {
//                // 记录 请求开始时间
//                builder.setServerOption(UndertowOptions.RECORD_REQUEST_START_TIME, true);
//            }
//        });
//        return factory;
//    }
//}
