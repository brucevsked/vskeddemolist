package com.vsked.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.vsked.bean.HelloWorld;

@Configuration
@ComponentScan(basePackages = "com.vsked.service")
public class AppConfig {
	
	@Bean(name="helloWorld")
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }
	
}
