package com.vsked.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = {"com.vsked.service","com.vsked.dao"})
@EnableAspectJAutoProxy(proxyTargetClass=true) //启用自动代理
public class AppConfig {
	
	@Autowired
	DataSource datasource;
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate getJdbcTemplate(){
		return new JdbcTemplate(datasource);
	}
}
