package com.example.OnlineDukan.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineDukan.DataBase.UserRepo;
 import com.example.OnlineDukan.model.Users;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "users")

public class shopkeeperController {
	
	@Autowired
	private UserRepo userRepository;
	
	@GetMapping("/get")
	public List<Users> getUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/add")
	public void  postUser(@RequestBody Users  user) {
		userRepository.save(user) ;
	}

}
