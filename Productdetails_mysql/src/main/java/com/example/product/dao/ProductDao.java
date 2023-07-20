package com.example.product.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.product.entity.Product;


@Repository
public interface ProductDao extends CrudRepository<Product, Integer>{

}
