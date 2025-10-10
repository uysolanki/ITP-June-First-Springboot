package com.itp.ITPJuneFirstSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itp.ITPJuneFirstSpringboot.model.Product;
import com.itp.ITPJuneFirstSpringboot.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/addProduct")
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
}
