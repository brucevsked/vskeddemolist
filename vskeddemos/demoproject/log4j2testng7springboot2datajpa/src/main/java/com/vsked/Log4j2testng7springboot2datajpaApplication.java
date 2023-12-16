package com.vsked;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@ComponentScan({"com.vsked"})
@SpringBootApplication
@EnableEncryptableProperties
public class Log4j2testng7springboot2datajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Log4j2testng7springboot2datajpaApplication.class, args);
	}

}
