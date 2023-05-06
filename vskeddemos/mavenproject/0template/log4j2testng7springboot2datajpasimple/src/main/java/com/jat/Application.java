package com.jat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@ComponentScan({"com.jat"})
@SpringBootApplication
@EnableEncryptableProperties
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
