package com.vsked.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class AppDataSourceConfig {
	
	@Autowired
	Environment env;
	
	@Bean(name = "dataSource")  
	public DataSource dataSource() {  
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();  
	    dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));  
	    dataSource.setUrl(env.getRequiredProperty("jdbc.url"));  
	    dataSource.setUsername(env.getRequiredProperty("jdbc.username"));  
	    dataSource.setPassword(env.getRequiredProperty("jdbc.password")); 
	    System.out.println("||"+env.getRequiredProperty("jdbc.password"));
	    return dataSource;  
	}
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate getJdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}
}
