package com.springboot.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.model.Item;

@CrossOrigin(origins = "*")
public interface ItemRepository extends JpaRepository<Item, Integer> {

Page<Item> findByCategoryItemcategoryid(@RequestParam("id") Integer id, Pageable pageable);

Page<Item> findByItemnameContaining(@RequestParam("name") String name, Pageable pageable);
}