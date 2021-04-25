package com.Products_Categories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Products_Categories.models.Category;
import com.Products_Categories.models.CategoryProduct;
import com.Products_Categories.models.Product;
import com.Products_Categories.services.AppService;

@Controller
public class HomeController {
	private final AppService appService;
	
	public HomeController(AppService appService) {
		this.appService=appService;
	}

	@GetMapping("/")
	public String index(@ModelAttribute("product") Product product, Model model) {
		model.addAttribute("allProducts", this.appService.getAllProduct());
		return "index.jsp";
	}
	@PostMapping("/product/create")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		this.appService.createProduct(product);
		return "redirect:/";
	}
	@GetMapping("/product/{id}")
	public String showProductPage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("showProduct", this.appService.getProduct(id));
		model.addAttribute("allCategories", this.appService.FindRemainingCategories(this.appService.getProduct(id)));
		return "productinfo.jsp";
	}
	@PostMapping("/addCategory")
	public String addToProduct(@RequestParam(value="hiddenProdId") Long prodId, @RequestParam(value="selectedCat") Long catId) {
		
		//get a product with selected id
		Product prodGet = this.appService.getProduct(prodId);
		
		//get a category with selected id
		Category catGet = this.appService.getCategory(catId);
		
		CategoryProduct association = new CategoryProduct(prodGet, catGet);
		
		//if the product's category doesn't exist then add this category to the product
		if(!prodGet.getCategories().contains(catGet)){
			//tell categoryProduct service to create a new entry in the middle table
			this.appService.createAssociation(association);	
		}
		return "redirect:/product/"+ prodId;
	}
	
}
