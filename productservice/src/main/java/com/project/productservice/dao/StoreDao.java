package com.project.productservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.productservice.entity.StoreEntity;

@Repository
public interface StoreDao extends JpaRepository<StoreEntity,Integer> {

}
