package com.project.productservice.pojo;

public class ProductPojo
{
	private int id;
	private String name;
	private String image;
	private int price;
	private int quantity;
	private String description;
	private StorePojo storeId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public StorePojo getStoreId() {
		return storeId;
	}
	public void setStoreId(StorePojo storeId) {
		this.storeId = storeId;
	}
	public ProductPojo(int id, String name, String image, int price, int quantity, String description,
			StorePojo storeId) {
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
		return "ProductPojo [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", quantity="
				+ quantity + ", description=" + description + ", storeId=" + storeId + "]";
	}
	
	
}
