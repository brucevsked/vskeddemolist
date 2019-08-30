package com.vsked.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = {"com.vsked.dao.postgre"},sqlSessionFactoryRef = "sqlSessionFactoryPostgredb1")
public class Postgredb1Config {
	
    /**
     * 定义postgresql数据源
     * @return 主数据源
     */
	@Primary
    @Bean(name = "dataSourcePostgredb1")
	@ConfigurationProperties(prefix = "spring.datasource.postgredb1")
    public DataSource dataSourcePostgredb1() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
	
    /**
     * 定义事务管理器
     * @param dataSource 数据源
     * @return 事务管理器
     */
	@Primary
    @Bean(name = "transactionManagerPostgredb1")
    public DataSourceTransactionManager transactionManagerPostgredb1() {
        return new DataSourceTransactionManager(dataSourcePostgredb1());
    }


    /**
     * 定义事务模板
     * @param transactionManager 事务管理器
     * @return 事务模板
     * @throws Exception 异常
     */
    @Bean(name = "transactionTemplatePostgredb1")
    @Primary
    public TransactionTemplate transactionTemplatePostgredb1() throws Exception {
        DefaultTransactionDefinition defaultTransactionDefinition =
                new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
        defaultTransactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
        defaultTransactionDefinition.setTimeout(60); // 秒钟
        return new TransactionTemplate(transactionManagerPostgredb1(), defaultTransactionDefinition);
    }

    /**
     * +自定义数据源配置
     * @param dataSource dataSource
     * @param properties properties
     * @return configurationCustomizersProvider
     * @throws Exception Exception
     */
    @Bean(name = "sqlSessionFactoryPostgredb1")
    @Primary
    public SqlSessionFactory sqlSessionFactoryPostgredb1() throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSourcePostgredb1());
        return factory.getObject();
    }
    
    

}
