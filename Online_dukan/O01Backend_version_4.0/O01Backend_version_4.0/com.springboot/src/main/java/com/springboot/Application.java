package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.spring.config.WebConfig;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		//System.out.println("Test");
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebConfig();
 }

}
