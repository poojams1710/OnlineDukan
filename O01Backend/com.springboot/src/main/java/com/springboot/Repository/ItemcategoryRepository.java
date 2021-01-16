package com.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.springboot.model.Itemcategory;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "itemCategory", path="item-category")
public interface ItemcategoryRepository extends JpaRepository<Itemcategory, Integer> {

}
