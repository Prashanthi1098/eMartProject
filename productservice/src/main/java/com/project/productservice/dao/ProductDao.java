package com.project.productservice.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.productservice.entity.ProductEntity;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity,Integer>
{


}
