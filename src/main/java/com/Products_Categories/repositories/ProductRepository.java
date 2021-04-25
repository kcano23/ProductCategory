package com.Products_Categories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Products_Categories.models.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
