package com.example.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.model.Product;
import com.example.serivce.ProductService;


@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(path="/products")
	public List<Product> getAllvalues(){
		
		return productService.findAll();
		
		
		}
	@GetMapping(path="/products/{id}")
	public Product getById(@PathVariable int id) {
		
		return productService.getbyId(id);
		
	}
	@PostMapping(path="/products")
	public int addData(@RequestBody Product product) {
		
		System.out.println("check the meassage");
		
		 return productService.Create(product);
		
	}

	
}
