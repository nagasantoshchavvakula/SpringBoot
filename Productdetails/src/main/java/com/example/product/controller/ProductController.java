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
	
	/*
	 * 
	 * Introduction about Rest Services ==> Cross Language Communication 
	 * JSON Object is the preferred mode for data communication
	 * JSON ==> Javascript Object Notation
	 * products={
	 * 		"productName":"TV",
	 * 		"price":10000
	 * 		"qty":100
	 * 
	 * }
	 * 
	 * JAVA Created JAX RS Framework for implementing REST SERVICES
	 * Spring Boot has taken same framework and customized some of the APIs
	 * If we did not speicify any verb ==> Default Get
	 * 
	 * As part of JAX RS ==> @GET  	==> @GET   	+ @REQUESTMAPPING ==> @GETMAPPING
	 * 					 ==> @POST 	==> @POST  	+ @REQUESTMAPPING ==> @POSTMAPPING
	 *   				 ==> @PUT  	==> @PUT   	+ @REQUESTMAPPING ==> @PUTMAPPING
	 *   				 ==> @DELETE==> @DELETE	+ @REQUESTMAPPING ==> @DELETEMAPPING 
	 * 
	 * 
	 * Controller ==> Entry Point from all FE to access any type of data  or else to submit data 
	 * RestController ===> Thru REST Protocol 
	 */
	
	
	//Retrieve All Tickets
	
	
	@Autowired
	private ProductService productService;
	
	
	/*
	 * 
	 * http://localhost:8080 ===> Bootstrap Class
	 * http://localhost:8080/tickets ==> TicketController Layer ==> obj will initialized
	 * //http://localhost:8080/tickets/all ==> All Ticket Method
	 * obj.getAllTickets();
	 */
	
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
	//http://localhost:8080/tickets/1  ==> 1st Ticket
	//http://localhost:8080/tickets/10 ==> 10th Ticket
	//http://localhost:8080/tickets/100  ==>100th Ticket
	//@PathVariableb ==> Going to scan the URL and reads the variable
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
