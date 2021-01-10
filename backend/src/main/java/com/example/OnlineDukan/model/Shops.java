
package com.example.OnlineDukan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Shops")
public class Shops {

	@Id
	@Column(name = "shopId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shopId;
	
	@Column(name = "shopname")
	private String shopname;

	
	@Column(name = "shopLoc")
	private String shopLoc;
	
	@Column(name = "picByte", length = 100000)
	private byte[] picByte;
	
	@OneToMany(mappedBy = "shop")
     private Set<ShopProducts> products = new HashSet<ShopProducts>(0);;
     
     
     public Set<ShopProducts> getProducts(){
    	 return products ;
    	 
     }
     
     public void setProducts(Set<ShopProducts> products) {
    	 
    	 this.products = products; 
     }
     
	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getShopLoc() {
		return shopLoc;
	}

	public void setShopLoc(String shopLoc) {
		this.shopLoc = shopLoc;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
	
	
}
