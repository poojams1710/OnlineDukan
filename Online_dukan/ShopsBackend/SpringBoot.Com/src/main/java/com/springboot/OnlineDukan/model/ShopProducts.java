package com.springboot.OnlineDukan.model;

import javax.persistence.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ShopProducts")
public class ShopProducts implements Serializable {


	@Id
	@Column(name = "productId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "shopId" , referencedColumnName = "shopId" , insertable = false, updatable = false)
	public Shops shop;
	
	@Column(name = "shopId")
	private Long shopId;
	
    

	public Long getshopId() {
		return this.shopId;
	}
	
	public void setshopId(Long shopId) {
		this.shopId = shopId ;
	}
	
	@Column(name = "productname")
	private String productname;

	
	@Column(name = "productprice")
	private Long productprice;
	
	
	@Column(name = "productQuantity")
	private Long productQuantity;
	
	@Column(name = "picByte", length = 100000)
	private byte[] picByte;


	
	
	public Long getproductId() {
		return productId;
	}

	public void setproductId(Long productId) {
		this.productId = productId;
	}

	public String getproductname() {
		return productname;
	}

	public void setproductname(String productname) {
		this.productname = productname;
	}

	public Long getproductprice() {
		return productprice;
	}

	public void setproductprice(Long productprice) {
		this.productprice = productprice;
	}

	public Long getproductQuantity() {
		return productQuantity;
	}

	public void setproductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
	

	public ShopProducts() {
		super();
	}

	public ShopProducts(Long productId,String productname, Long productprice, Long productQuantity,
			byte[] picByte , Long shopId) {
		super();
		this.productId = productId;
		
		this.productname = productname;
		this.productprice = productprice;
		this.productQuantity = productQuantity;
		this.picByte = picByte;
		this.shopId = shopId ;
	}
	
	
	
}

