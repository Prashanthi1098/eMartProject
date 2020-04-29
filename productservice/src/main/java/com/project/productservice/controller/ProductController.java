package com.project.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.productservice.pojo.ProductPojo;
import com.project.productservice.pojo.StorePojo;
import com.project.productservice.service.ProductService;

@CrossOrigin

@RestController
@RequestMapping("product")

public class ProductController 
{
	@Autowired
	ProductService productService;

	@GetMapping("/prod/{prodId}")
	ProductPojo getProduct(@PathVariable("prodId") Integer prodId) 
	{
		return productService.getproduct(prodId);
		
	}

	@GetMapping("/prod/all")
	List<ProductPojo>getAllProducts()
	{
		return productService.getAllProducts();
		
	}
	
	
	
	@DeleteMapping("/deleteProd/{prodId}")
	void deleteProduct(@PathVariable("prodId") Integer prodId)
	{
		return;
		
	}
	
	@PostMapping("/addProd")
	ProductPojo addProduct(@RequestBody ProductPojo prodPojo)
	{
		return prodPojo;

	}

	@PostMapping("/addStore")
	ProductPojo addStore(@RequestBody ProductPojo prodPojo)
	{
		return prodPojo;

	}

	@PutMapping("/prod/{prodId}")
	ProductPojo updateProduct(@RequestBody ProductPojo prodPojo)
	{
		return prodPojo;
		
	}
}
