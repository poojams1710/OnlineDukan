package com.springboot.OnlineDukan.Controller;

import java.io.IOException;


import java.util.List;
import java.util.Optional;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.OnlineDukan.DataBase.ProdsRepo;
import com.springboot.OnlineDukan.model.ShopProducts;
import com.springboot.OnlineDukan.model.Shops;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "products")
public class ProductsController {
	
	private byte[] bytes ;
	
	
	@Autowired
	private   ProdsRepo  ProductRepository;
	

	
//	@GetMapping(path = "/get")
//	public Optional<ShopProducts> getProducts(@RequestParam(name ="id") Long Id){
//		return this.ProductRepository.findById(Id);
//		
//	}
	
//	@GetMapping("/get/{id}")
//	public Optional<ShopProducts> getShopId(@PathVariable(value = "id") Integer ProductId)
//			throws RelationNotFoundException {
//		return this. ProductRepository.findById(ProductId);
//	}
//	
	@RequestMapping(value = "/take/{id}", method = RequestMethod.GET)
	public ResponseEntity<ShopProducts> getEmployeeById(@PathVariable Long id) {
		ShopProducts shopps = ProductRepository.findById(id).get();
		return ResponseEntity.ok().body(shopps);
	}

	
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}
	
	@PostMapping("/add")
	public void addshop(@RequestBody ShopProducts product) throws IOException {
		
		product.setPicByte(this.bytes);
		ProductRepository.save(product);
		this.bytes = null;
	}

	
	@GetMapping("/get/{id}")
	public List<ShopProducts> getshopProduct(@PathVariable(value = "id") Long id ){
		return this.ProductRepository.selectRecordByShopId(id);

}
	
}
