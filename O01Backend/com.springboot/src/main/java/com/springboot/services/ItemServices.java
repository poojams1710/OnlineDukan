package com.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.springboot.Repository.ItemRepository;
import com.springboot.model.Item;

@CrossOrigin(origins = "*")
@Service
public class ItemServices {
	
	@Autowired
	ItemRepository itemRepository;
	
	public List<Item>getAllItems(){
		return itemRepository.findAll();
	}
}
