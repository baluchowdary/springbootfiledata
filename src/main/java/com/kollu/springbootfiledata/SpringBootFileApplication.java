package com.kollu.springbootfiledata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFileApplication.class, args);
	}

}
