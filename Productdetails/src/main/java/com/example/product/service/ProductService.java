package com.example.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.dao.ProductDao;
import com.example.product.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public Product createProduct(Product inputObj) {
		return productDao.save(inputObj);
	}
	
	public Iterable<Product>getAllProducts(){
		return productDao.findAll();
	}
	
	public Product retrieveProduct(Integer productId) {
		return productDao.findById(productId).
				                            orElse(new Product());
		
	}
	
	public Product updateProduct(Integer productId,Integer newProductPrice) {
		Product dbProductObj=retrieveProduct(productId);
		dbProductObj.setProductPrice(newProductPrice);
		return productDao.save(dbProductObj);
	}
	public void deleteProduct(Integer productId) {
		productDao.deleteById(productId);
	}
	
}
