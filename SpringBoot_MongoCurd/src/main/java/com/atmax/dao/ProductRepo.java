package com.atmax.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.atmax.entity.Product;

public interface ProductRepo extends MongoRepository<Product, String> {

}
