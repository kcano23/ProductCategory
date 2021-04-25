package com.Products_Categories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Products_Categories.models.Category;
import com.Products_Categories.models.CategoryProduct;
import com.Products_Categories.models.Product;
import com.Products_Categories.repositories.CategoryProductRepository;
import com.Products_Categories.repositories.CategoryRepository;
import com.Products_Categories.repositories.ProductRepository;

@Service
public class AppService {
	private final ProductRepository prodRepo;
	private final CategoryRepository catRepo;
	private final CategoryProductRepository catprodRepo;
	
	public AppService(ProductRepository prodRepo, CategoryRepository catRepo, CategoryProductRepository catprodRepo) {
		this.prodRepo=prodRepo;
		this.catRepo=catRepo;
		this.catprodRepo=catprodRepo;
	}
	
	public Product createProduct(Product product) {
		return this.prodRepo.save(product);
	}
	public List<Product> getAllProduct(){
		return (List<Product>)this.prodRepo.findAll();
	}
	public Product getProduct(Long id) {
		return this.prodRepo.findById(id).orElse(null);
	}
	public List<Category> getAllCategories(){
		return (List<Category>)this.catRepo.findAll();
	}
	public Category getCategory(Long id) {
		return this.catRepo.findById(id).orElse(null);
	}
	public CategoryProduct createAssociation(CategoryProduct cp) {
		return this.catprodRepo.save(cp);
	}
	public List<Category>FindRemainingCategories(Product product){
		return this.catRepo.findByProductsNotContains(product);
	}
}
