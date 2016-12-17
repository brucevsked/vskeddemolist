package com.vsked.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.vsked.dao","com.vsked.service"})
@EnableAspectJAutoProxy(proxyTargetClass=true) //启用自动代理
public class AppConfig {
	
	

}
