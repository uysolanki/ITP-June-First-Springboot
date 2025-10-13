package com.itp.ITPJuneFirstSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itp.ITPJuneFirstSpringboot.model.Product;
import com.itp.ITPJuneFirstSpringboot.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/addProduct")  //end point / api
	public String addProduct()
	{
		Product p=Product.builder()
				.productTitle("Mobile")
				.productDesc("16 GB Ram 1TB SSD One Plus")
				.productCategory("Electronics")
				.price(100.0)
				.build();
		
		productService.addProduct(p);
		return "Product added Successfully";
	}
	
	@PostMapping("/addProduct1")  //end point / api
	public Product addProduct1()
	{
		Product p=Product.builder()
				.productTitle("Marker")
				.productDesc("Black color white board marker")
				.productCategory("Stationery")
				.price(30.0)
				.build();
		
		Product p1=productService.addProduct1(p);
		return p1;
	}
	
	
	
	
	@PostMapping("/addProductByPathVariable/{pTitle}/{pDesc}/{pCat}/{pPrice}")  //end point / api
	public Product addProductByPathVariable(
			@PathVariable("pTitle") String prodTitle,
			@PathVariable("pDesc") String prodDesc,
			@PathVariable("pCat") String prodCategory,
			@PathVariable("pPrice") double prodPrice
			)
	{
		Product p=Product.builder()
				.productTitle(prodTitle)
				.productDesc(prodDesc)
				.productCategory(prodCategory)
				.price(prodPrice)
				.build();
		
		Product p1=productService.addProduct1(p);
		return p1;
	}
	
	
	@PostMapping("/addProductByPathVariable1/{prodTitle}/{prodDesc}/{prodCategory}/{prodPrice}")  //end point / api
	public Product addProductByPathVariable1(
			@PathVariable String prodTitle,
			@PathVariable String prodDesc,
			@PathVariable String prodCategory,
			@PathVariable double prodPrice
			)
	{
		Product p=Product.builder()
				.productTitle(prodTitle)
				.productDesc(prodDesc)
				.productCategory(prodCategory)
				.price(prodPrice)
				.build();
		
		Product p1=productService.addProduct1(p);
		return p1;
	}
	
	@PostMapping("/addProductByRequestBody")  //end point / api
	public Product addProductByRequestBody(@RequestBody Product p)
	{		
		return productService.addProduct1(p);
	}
}

/*
 {
    "productTitle": "TV",
    "productDesc": "56 inch color LED TV",
    "productCategory": "Electronics",
    "price": 20000.0
 }
*/