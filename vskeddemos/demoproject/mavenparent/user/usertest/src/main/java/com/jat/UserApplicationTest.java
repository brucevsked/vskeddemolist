package com.jat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.jat.persistance.springdatajpa"})
@EntityScan("com.jat.repository.entity")
@SpringBootApplication
public class UserApplicationTest {
    public static void main(String[] args) {
        SpringApplication.run(UserApplicationTest.class,args);
    }
}
