package com.Products_Categories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Products_Categories.models.CategoryProduct;


@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {

}
