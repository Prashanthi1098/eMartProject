package com.project.productservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.productservice.dao.ProductDao;
import com.project.productservice.entity.ProductEntity;
import com.project.productservice.entity.StoreEntity;
import com.project.productservice.pojo.ProductPojo;
import com.project.productservice.pojo.StorePojo;

@Service
public class ProductServiceImpl implements ProductService 
{
	@Autowired
	ProductDao productDao;
	@Override
	public ProductPojo getproduct(Integer prodId) 
	{
		ProductPojo productPojo =  null;
		Optional result = productDao.findById(prodId);
		if(result.isPresent())
		{
			ProductEntity productEntity = (ProductEntity)result.get();
			StoreEntity storeEntity = productEntity.getStoreId();
			StorePojo storePojo = new StorePojo(storeEntity.getId(),storeEntity.getName(),storeEntity.getLocation(),storeEntity.getDate());
			productPojo = new ProductPojo(productEntity.getId(),productEntity.getName(),productEntity.getImage(),productEntity.getPrice(),productEntity.getQuantity(),productEntity.getDescription(),storePojo);
			
			}
		return productPojo;
	}
	@Override
	public List<ProductPojo> getAllProducts() 
	{
		List<ProductPojo> allProductPojo =new ArrayList();
		Iterable<ProductEntity> allProductEntity = productDao.findAll();
		Iterator itr = allProductEntity.iterator();

		while(itr.hasNext()) 
		{
			ProductEntity productEntity  = (ProductEntity)itr.next();
			StoreEntity storeEntity = productEntity.getStoreId();
			StorePojo storePojo = new StorePojo(storeEntity.getId(),storeEntity.getName(),storeEntity.getLocation(),storeEntity.getDate());
			ProductPojo productPojo = new ProductPojo(productEntity.getId(),productEntity.getName(),productEntity.getImage(),productEntity.getPrice(),productEntity.getQuantity(),productEntity.getDescription(),storePojo);
			allProductPojo.add(productPojo);

		}
		return allProductPojo;
	}

}
