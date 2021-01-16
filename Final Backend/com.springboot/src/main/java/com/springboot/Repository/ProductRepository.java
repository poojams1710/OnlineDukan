package com.springboot.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.model.Product;

@CrossOrigin(origins = "*")
public interface ProductRepository  extends JpaRepository<Product, Integer> {

Page<Product> findByCategoryId(@RequestParam("id") Long  id, Pageable pageable);

Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
