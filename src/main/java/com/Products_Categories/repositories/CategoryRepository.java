package com.Products_Categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Products_Categories.models.Category;
import com.Products_Categories.models.Product;



@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
		//find all categories that don't have a relationship with a product in the DataBase
		List<Category> findByProductsNotContains(Product product);
}
