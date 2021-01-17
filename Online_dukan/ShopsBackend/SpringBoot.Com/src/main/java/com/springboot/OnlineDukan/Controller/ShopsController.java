package com.springboot.OnlineDukan.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.OnlineDukan.DataBase.ShopsRep;
import com.springboot.OnlineDukan.model.Shops;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "shops")

public class ShopsController {
	
	private byte[] bytes ;
	
	@Autowired
	private   ShopsRep ShopsRepository ;
	
	@GetMapping("/get")
	public List<Shops> getShops(){
		return this.ShopsRepository.findAll();
			
	}
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}
	
	@PostMapping("/add")
	public void addshop(@RequestBody Shops shop) throws IOException {
		shop.setPicByte(this.bytes);
		ShopsRepository.save(shop);
		this.bytes = null;
	}
	
}
