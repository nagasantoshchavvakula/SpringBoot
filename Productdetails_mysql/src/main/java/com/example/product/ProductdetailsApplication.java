package com.example.product;

//import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.product.service.ProductService;
import com.example.product.entity.Product;



@SpringBootApplication
public class ProductdetailsApplication implements CommandLineRunner{
	
	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(ProductdetailsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		Product inputObj=new Product();
		inputObj.setProductId(1);
		inputObj.setProductName("Iphone 14 pro");
		inputObj.setProductCategory("Electronic");
		inputObj.setProductCode("IPOSM");
		inputObj.setProductPrice(125000);
		
		productService.createProduct(inputObj);
		
		
	}

}
