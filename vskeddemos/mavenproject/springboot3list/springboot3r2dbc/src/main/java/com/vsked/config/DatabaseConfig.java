//package com.vsked.config;
//
//import io.asyncer.r2dbc.mysql.MySqlConnectionConfiguration;
//import io.asyncer.r2dbc.mysql.MySqlConnectionFactory;
//import io.r2dbc.spi.ConnectionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DatabaseConfig {
//
//    private String url;
//    private String username;
//    private String password;
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        MySqlConnectionConfiguration config = MySqlConnectionConfiguration.builder()
//                .host("127.0.0.1")
//                .port(3306)
//                .database("springboot3r2dbc")
//                .username("springboot3r2dbc")
//                .password("springboot3r2dbc")
//                .build();
//        return MySqlConnectionFactory.from(config);
//    }
//}
