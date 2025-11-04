package com.itp.ITPJuneFirstSpringboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itp.ITPJuneFirstSpringboot.model.Product;
import com.itp.ITPJuneFirstSpringboot.service.ProductService;

@Controller
public class ProductControllerUI {

	@Autowired
	ProductService productService;
	
	@RequestMapping("/addProductForm")
	public String addProduct(Model model)
	{

	Product p=new Product();
	model.addAttribute("product",p);
	return "add-product";
	}
	
	@PostMapping("/saveProduct") 
	public String addProductByRequestBody(@ModelAttribute @Valid Product p)
	{	
		productService.addProduct1(p); 
		return "redirect:/getAllProducts";
	}
	
	@GetMapping("/getAllProducts") 
	public String getAllProducts(Model model)
	{
	List<Product> products=	productService.getAllProducts();
	model.addAttribute("products", products);
	return "all-products";
	}
	
	@RequestMapping("/deleteProduct/{pid}") 
	public String deleteProduct(@PathVariable int pid)
	{
	productService.deleteProduct(pid);
	return "redirect:/getAllProducts";
	}
}
