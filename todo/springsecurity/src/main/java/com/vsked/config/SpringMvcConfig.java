package com.vsked.config;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

	//---------------------------------------------响应json返回乱码解决方案第一种 推荐这一种-----开始
	@Bean
	public HttpMessageConverter<String> responseBodyStringConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
		return converter;
	}

	/**
	 * 修改StringHttpMessageConverter默认配置
	 * 
	 * @param converters
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(responseBodyStringConverter());
	}
	//---------------------------------------------响应json返回乱码解决方案第一种 推荐这一种-----结束

}
