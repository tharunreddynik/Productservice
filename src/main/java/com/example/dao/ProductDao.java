package com.example.dao;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

@Repository
public class ProductDao {

	@Autowired
	JdbcTemplate jdbctemplate;

	public List<Product> getAll() {

		String str = "SELECT * FROM productmgmt.products";

		return jdbctemplate.query(str, new BeanPropertyRowMapper(Product.class));

	}
	
	public Product getById(int id) {
		String str = "select * FROM products where productid =?";
		
		 return (Product) jdbctemplate.queryForObject(str, new Object[]{id}, new BeanPropertyRowMapper(Product.class));
		
	}

	public int createbody(Product product) {
		
		String str="insert into products(description,productname,discount,price) Values(?,?,?,?)  ";
		return	jdbctemplate.update(str, new Object[] {product.getDescription(),product.getProductname(),product.getDiscount(),product.getPrice()});
			
	}
}
