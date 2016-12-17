package com.vsked.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class AppDataSourceConfig {
	
	@Value("${jdbc.driverClassName}")  
	String driverClass;  
	
	@Value("${jdbc.url}")  
	String url;  
	
	@Value("${jdbc.username}")  
	String userName;  
	
	@Value("${jdbc.password}")  
	String passWord; 
	
	@Bean(name = "dataSource")  
	public DataSource dataSource() {  
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();  
	    dataSource.setDriverClassName(driverClass);  
	    dataSource.setUrl(url);  
	    dataSource.setUsername(userName);  
	    dataSource.setPassword(passWord);  
	    return dataSource;  
	}
}
