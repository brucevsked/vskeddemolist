package com.vsked.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = {"com.vsked.dao.phoenix"},sqlSessionFactoryRef = "sqlSessionFactoryPhoenixdb1")
public class Phoenixdb1Config {
	/**
     * 定义phoenix数据源
     * @return 主数据源
     */
    @Bean(name = "dataSourcePhoenixdb1")
    @ConfigurationProperties(prefix = "spring.datasource.phoenixdb1")
    public DataSource dataSourcePhoenixdb1() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
	
    /**
     * 定义事务管理器
     * @param dataSource 数据源
     * @return 事务管理器
     */
    @Bean(name = "transactionManagerPhoenixdb1")
    public DataSourceTransactionManager transactionManagerPhoenixdb1() {
        return new DataSourceTransactionManager(dataSourcePhoenixdb1());
    }


    /**
     * 定义事务模板
     * @param transactionManager 事务管理器
     * @return 事务模板
     * @throws Exception 异常
     */
    @Bean(name = "transactionTemplatePhoenixdb1")
    public TransactionTemplate transactionTemplatePhoenixdb1() throws Exception {
        DefaultTransactionDefinition defaultTransactionDefinition =
                new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
        defaultTransactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
        defaultTransactionDefinition.setTimeout(60); // 秒钟
        return new TransactionTemplate(transactionManagerPhoenixdb1(), defaultTransactionDefinition);
    }

    /**
     * +自定义数据源配置
     * @param dataSource dataSource
     * @param properties properties
     * @return configurationCustomizersProvider
     * @throws Exception Exception
     */
    @Bean(name = "sqlSessionFactoryPhoenixdb1")
    public SqlSessionFactory sqlSessionFactoryPhoenixdb1() throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSourcePhoenixdb1());
        return factory.getObject();
    }

}
