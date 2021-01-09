package com.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.springboot.model.Itemcategory;

@CrossOrigin(origins = "*")
public interface ItemcategoryRepository extends JpaRepository<Itemcategory, Integer> {

}
