package com.project.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.productservice.dao.StoreDao;
import com.project.productservice.entity.ProductEntity;
import com.project.productservice.entity.StoreEntity;
import com.project.productservice.pojo.ProductPojo;
import com.project.productservice.pojo.StorePojo;

@Service
public class StoreServiceImpl implements StoreService
{

	@Autowired
	StoreDao storeDao;
	@Override
	public StorePojo getStores(Integer storeId) 
	{
		StorePojo storePojo =  null;
		Optional result = storeDao.findById(storeId);
		if(result.isPresent())
		{
			StoreEntity storeEntity = (StoreEntity)result.get();
			List<ProductEntity> productEntity = storeEntity.getAllProducts();
			
			storePojo = new StorePojo(storeEntity.getId(),storeEntity.getName(),storeEntity.getLocation(),storeEntity.getDate());
			
			
		}

		
		return storePojo;
	}

}
