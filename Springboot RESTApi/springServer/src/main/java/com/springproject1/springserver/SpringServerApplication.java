package com.springproject1.springserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.springproject1.springserver")
@EnableAutoConfiguration
@ComponentScan(basePackages = "controller")
@ComponentScan(basePackages = "com.springproject1.springserver.model")
public class SpringServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServerApplication.class, args);
		
		
	}

}
