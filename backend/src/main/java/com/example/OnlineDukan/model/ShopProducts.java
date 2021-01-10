package com.example.OnlineDukan.model;

import javax.persistence.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ShopProducts")
public class ShopProducts {

	@Id
	@Column(name = "ProductId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ProductId;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Shops shop ;
	

	@Column(name = "Productname")
	private String Productname;

	
	@Column(name = "Productprice")
	private Long Productprice;
	
	
	@Column(name = "ProductQuantity")
	private Long ProductQuantity;
	
	@Column(name = "picByte", length = 100000)
	private byte[] picByte;


	
	
	public Long getProductId() {
		return ProductId;
	}

	public void setProductId(Long ProductId) {
		this.ProductId = ProductId;
	}

	public String getProductname() {
		return Productname;
	}

	public void setProductname(String Productname) {
		this.Productname = Productname;
	}

	public Long getProductprice() {
		return Productprice;
	}

	public void setProductprice(Long Productprice) {
		this.Productprice = Productprice;
	}

	public Long getProductQuantity() {
		return ProductQuantity;
	}

	public void setProductQuantity(Long ProductQuantity) {
		this.ProductQuantity = ProductQuantity;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	
	
	
}

