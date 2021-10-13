package com.example.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ProductDao;
import com.example.model.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	public List<Product> findAll(){
		
		 return productDao.getAll();
	}
	
	public  Product getbyId(int id){
		
		 return productDao.getById(id);
		 
		 
	}
	public int Create(Product product) {
		
		return productDao.createbody(product);
	}

}
