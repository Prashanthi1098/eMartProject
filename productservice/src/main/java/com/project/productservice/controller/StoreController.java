package com.project.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.productservice.pojo.StorePojo;
import com.project.productservice.service.StoreService;

@CrossOrigin

@RestController
@RequestMapping("product")

public class StoreController 
{

	@Autowired
	StoreService storeService;
	
	@GetMapping("/store/{storeId}")
	StorePojo getStores(@PathVariable("storeId") Integer storeId )
	{
		return storeService.getStores(storeId);
	}
}
