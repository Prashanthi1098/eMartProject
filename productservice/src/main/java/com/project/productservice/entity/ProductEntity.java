package com.project.productservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_list")
public class ProductEntity 
{

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prod_id")
	Integer id;
	@Column(name="prod_name")
	String name;
	@Column(name="prod_image")
	String image;
	@Column(name="prod_price")
	Integer price;
	@Column(name="prod_quantity")
	Integer quantity;
	@Column(name="prod_desc")
	String description;
	@ManyToOne
	@JoinColumn(name="store_id")
	StoreEntity storeId;
	
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public StoreEntity getStoreId() {
		return storeId;
	}
	public void setStoreId(StoreEntity storeId) {
		this.storeId = storeId;
	}
	public ProductEntity(Integer id, String name, String image, Integer price, Integer quantity, String description,
			StoreEntity storeId) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.storeId = storeId;
	}
	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", quantity="
				+ quantity + ", description=" + description + ", storeId=" + storeId + "]";
	}
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
