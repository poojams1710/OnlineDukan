package com.springboot.model;




import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product  {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name= "category_id", nullable=false)
	private ProductCategory category;
	
	@Column(name ="name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name="unit_price")
	private BigDecimal unitPrice;
	
	@Column(name="units_in_stock")
	private int unitsInStock;
	
	@Column(name="image_url")
	private String imageUrl;
	//private int itemcategoryid;
	

	
	
	public Long getId() {
		return id;
	}
	public void setid(Long  id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal  unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public String getImageurl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/*public int getItemcategoryid() {
		return itemcategoryid;
	}
	public void setItemcategoryid(int itemcategoryid) {
		this.itemcategoryid = itemcategoryid;
	}*/

	
	public ProductCategory  getCategory() {
		return category;
	}
	public void setCategory(ProductCategory  category) {
		this.category = category;
	}
	
	
	

}
