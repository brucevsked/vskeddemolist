package com.appserveruser.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer{
	
	@Bean
	public AuthorizationInterceptor getAuthorizationInterceptor(){
		return new AuthorizationInterceptor();
	}
	
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(getAuthorizationInterceptor()).addPathPatterns("/**").excludePathPatterns("/appuser/login");
	}

}
