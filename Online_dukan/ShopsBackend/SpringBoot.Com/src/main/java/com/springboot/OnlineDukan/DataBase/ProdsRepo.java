package com.springboot.OnlineDukan.DataBase;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.OnlineDukan.model.ShopProducts;

@Repository
public interface ProdsRepo extends JpaRepository<ShopProducts ,Long>{
	
	@Query(" from ShopProducts where shop.shopId = :id")
	List<ShopProducts> selectRecordByShopId(@Param("id") Long id);
	
	

}
