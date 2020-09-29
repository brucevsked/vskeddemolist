package com.*.*.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.*.*.interceptor.AdminInterceptor;

/**
 * 
 * 
 * @Package: com.*.*.config 
 * @ClassName: LoginConfig 
 * @Description:拦截器配置
 * @author: zk
 * @date: 2019年9月19日 下午2:18:35
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new AdminInterceptor());
        registration.addPathPatterns("/**");                      //所有路径都被拦截
        registration.excludePathPatterns(                         //添加不拦截路径
                                         "你的登陆路径",            //登录
                                         "/**/*.html",            //html静态资源
                                         "/**/*.js",              //js静态资源
                                         "/**/*.css",             //css静态资源
                                         "/**/*.woff",
                                         "/**/*.ttf"
                                         );    
    }
}