package com.project.productservice.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="store_add")
public class StoreEntity 
{

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="store_id")
	Integer id;
	@Column(name="store_name")
	String name;
	@Column(name="store_location")
	String location;
	@Column(name="store_date")
	Date date;
	
	@OneToMany(mappedBy = "storeId")
	List<ProductEntity> allProducts;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<ProductEntity> getAllProducts() {
		return allProducts;
	}

	public void setAllProducts(List<ProductEntity> allProducts) {
		this.allProducts = allProducts;
	}

	public StoreEntity(Integer id, String name, String location, Date date, List<ProductEntity> allProducts) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.date = date;
		this.allProducts = allProducts;
	}

	@Override
	public String toString() {
		return "StoreEntity [id=" + id + ", name=" + name + ", location=" + location + ", date=" + date
				+ ", allProducts=" + allProducts + "]";
	}

	public StoreEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
