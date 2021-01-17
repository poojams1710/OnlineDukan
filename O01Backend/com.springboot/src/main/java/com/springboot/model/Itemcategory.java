package com.springboot.model;



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
@Table(name="itemcategory")
public class Itemcategory {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="itemcategoryid")
	private int itemcategoryid;
	
	@Column(name="itemname")
	private String itemname;

	public int getItemcategoryid() {
		return itemcategoryid;
	}

	public void setItemcategoryid(int itemcategoryid) {
		this.itemcategoryid = itemcategoryid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	@OneToMany(cascade= CascadeType.ALL, mappedBy = "category")
	private Set<Item> items;
	

}
