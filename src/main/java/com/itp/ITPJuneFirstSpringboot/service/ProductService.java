package com.itp.ITPJuneFirstSpringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.ITPJuneFirstSpringboot.exception.ProductNotFoundException;
import com.itp.ITPJuneFirstSpringboot.model.Product;
import com.itp.ITPJuneFirstSpringboot.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public void addProduct(Product p) {
		productRepository.save(p);
		
	}

	public Product addProduct1(Product p) {
		return productRepository.save(p);
		
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getAllProductById(int pid) {
	Optional<Product> productBox=productRepository.findById(pid);
	Product product=null;
	if(productBox.isPresent())
	{
		product=productBox.get();
	}
	else throw new ProductNotFoundException("Product Not Found");
	return product;
	}
	
	
	public Product getAllProductById1(int pid) {
		return productRepository.findById(pid).orElseThrow(()->new ProductNotFoundException("Product Not Found"));
		}

	public List<Product> getAllProductsAbove100() {
		return productRepository.getAllProductAboveRs100();
	}

	public List<Product> getAllProductsAboveXAmount(double amount) {
		//return productRepository.getAllProductAboveRsX(amount);
		return productRepository.findByPriceGreaterThan(amount);
	}

	public List<Product> getAllProductsByPriceRange(double start, double end) {
		return productRepository.findByPriceBetween(start, end);
	}

}

//cliche