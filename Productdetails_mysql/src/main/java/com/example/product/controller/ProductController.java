package com.example.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.entity.Product;
import com.example.product.service.ProductService;

//import com.product.product.entity.Product;
//import com.product.product.service.ProductService;

@RestController
@RequestMapping(value="/products") //http://localhost:8080/products
////http://localhost:8080/products ==> ProductController obj=ioc.getProductController();
public class ProductController {
	
	//Retrieve All Tickets
	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/all") //http://localhost:8080/products/all
	public Iterable<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	
	//Creating the Product
	@PostMapping(value="/create") //http://localhost:8080/products/create
	public Product createProduct(@RequestBody Product productObj) {
		return productService.createProduct(productObj);
	}
	
	
	//Retrieving the Ticket
	//http://localhost:8080/products/1  ==> 1st Ticket
	//Dynamic Variable in the Path ==> { }
	@GetMapping(value="/{productId}")
	public Product getproduct(@PathVariable("productId") Integer productId) {
		return productService.retrieveProduct(productId);
	}
	
	
	
	//Update Ticket
	//http:localhost:8080/products/1/100000
	@PutMapping(value="/{productId}/{newProductPrice}")
	public Product updateProduct(@PathVariable("productId") Integer productId,
			@PathVariable("newProductPrice") Integer newProductPrice) {
		return productService.updateProduct(productId,newProductPrice);
	}
	
	
	//http://localhost:8080/products/1
	@DeleteMapping(value="/{productId}")
	public void deleteProduct(@PathVariable("productId") Integer productId) {
		productService.deleteProduct(productId);
	}

}
