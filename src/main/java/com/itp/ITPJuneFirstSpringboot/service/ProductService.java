package com.itp.ITPJuneFirstSpringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.ITPJuneFirstSpringboot.model.Product;
import com.itp.ITPJuneFirstSpringboot.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public void addProduct(Product p) {
		productRepository.save(p);
		
	}

}
