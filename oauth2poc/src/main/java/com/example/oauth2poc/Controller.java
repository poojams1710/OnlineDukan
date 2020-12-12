package com.example.oauth2poc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/")
	public String publicpage()
	{
		return "Anyone can see this";
	}
	
	@GetMapping("/user")
	public String privatepage()
	{
		return "You can see this because you logged in";
	}
	
}
