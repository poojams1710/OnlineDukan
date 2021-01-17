package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Item;
import com.springboot.services.ItemServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/item")
public class ProductController {
	
	@Autowired
	ItemServices ItemServices;
	
	@RequestMapping("getall")
	public List<Item>getAllItems(){
		return ItemServices.getAllItems();
		
	}
	
	

}
