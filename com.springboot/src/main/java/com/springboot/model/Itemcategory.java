package com.springboot.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemcategory")
public class Itemcategory {
	
	
	
	@Id
	private int itemcategoryid;
	
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

	
	

}
