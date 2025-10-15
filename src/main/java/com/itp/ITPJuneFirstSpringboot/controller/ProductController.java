package com.itp.ITPJuneFirstSpringboot.controller;

import java.awt.color.ProfileDataException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itp.ITPJuneFirstSpringboot.exception.ProductNotFoundException;
import com.itp.ITPJuneFirstSpringboot.model.Product;
import com.itp.ITPJuneFirstSpringboot.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/addProduct")  //end point / api
	public ResponseEntity<String>  addProduct()
	{
		Product p=Product.builder()
				.productTitle("Mobile")
				.productDesc("16 GB Ram 1TB SSD One Plus")
				.productCategory("Electronics")
				.price(100.0)
				.build();
		
		productService.addProduct(p);
		return new ResponseEntity<String>("Product added Successfully",HttpStatus.OK); //200
	}
	
	@PostMapping("/addProduct1")  //end point / api
	public ResponseEntity<Product> addProduct1()
	{
		Product p=Product.builder()
				.productTitle("Marker")
				.productDesc("Black color white board marker")
				.productCategory("Stationery")
				.price(30.0)
				.build();
		
		Product p1=productService.addProduct1(p);
		return new ResponseEntity<Product>(p1,HttpStatus.CREATED);  //201
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
	
	@PostMapping("/addMultipleProducts")  //end point / api
	public List<Product> addMultipleProducts(@RequestBody List<Product> products)
	{		
		return productService.addMultipleProducts(products); 
	}
	
	
	@GetMapping("/getAllProducts") 
	public List<Product> getAllProducts()
	{
	List<Product> products=	productService.getAllProducts();
	return products;
	}
	
	@GetMapping("/getAllProductById/{pid}") 
	public ResponseEntity<?> getAllProductById(@PathVariable int pid)
	{
	try
	{
	Product product=productService.getAllProductById(pid);
	return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	catch(RuntimeException ex1)
	{
	return new ResponseEntity<String>(ex1.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	}
	
	
	@GetMapping("/getProductByCategory/{cat}") 
	public ResponseEntity<?> getProductByCategory(@PathVariable String cat)
	{
	try
	{
	List<Product> products=productService.getProductByCategory(cat);
	return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	catch(RuntimeException ex1)
	{
	return new ResponseEntity<String>(ex1.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	}
	
	

	@GetMapping("/getAllProductById1/{pid}") 
	public ResponseEntity<?> getAllProductById1(@PathVariable int pid)
	{
	Product product=null;
	try
	{
	product=productService.getAllProductById1(pid);
	return new ResponseEntity<Product>(product,HttpStatus.OK) ;
	}
	catch(ProductNotFoundException ex)
	{
	return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	}
	
	@GetMapping("/getAllProductsAbove100") 
	public List<Product> getAllProductsAbove100()
	{
	List<Product> products=	productService.getAllProductsAbove100();
	return products;
	}
	
	@GetMapping("/getAllProductsAboveXUsingNativeQuery/{amount}") 
	public List<Product> getAllProductsAboveXUsingNativeQuery(@PathVariable double amount)
	{
	List<Product> products=	productService.getAllProductsAboveXAmount(amount);
	return products;
	}
	
	@GetMapping("/getAllProductsByPriceRange/{start}/{end}") 
	public List<Product> getAllProductsByPriceRange(@PathVariable double start,@PathVariable double end)
	{
	List<Product> products=	productService.getAllProductsByPriceRange(start,end);
	return products;
	}
	
	
	@GetMapping("/getSortedProducts/{field}/{direction}") 
	public List<Product> getSortedProducts(@PathVariable String field,@PathVariable String direction)
	{
	List<Product> products=	productService.getSortedProducts(field,direction);
	return products;
	}
	
	
	@GetMapping("/searchProducts/{keyword}") 
	public List<Product> searchProducts(@PathVariable String keyword)
	{
	List<Product> products=	productService.searchProducts(keyword);
	return products;
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