package com.example.OnlineDukan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan(basePackages={"com.example.OnlineDukan"})
public class OnlineDukanApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineDukanApplication.class, args);
	}

}
