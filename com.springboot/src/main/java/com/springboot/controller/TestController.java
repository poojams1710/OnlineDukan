package com.springboot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


	
	@CrossOrigin(origins = "*")
	@RestController
	@RequestMapping("/api/shopping")
	public class TestController {
		
			
		@GetMapping("/all")
		@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
		public String allAccess() {
			return "Home Page..viewed by all logged in.";
		}
		
		@GetMapping("/user")	
		@PreAuthorize("hasRole('USER')")
		public String userAccess() {
			return "User Cart Page.";
		}

		@GetMapping("/admin")
		@PreAuthorize("hasRole('ADMIN')")
		public String adminAccess() {
			return "Admin Dash Board.";
		}
	}



