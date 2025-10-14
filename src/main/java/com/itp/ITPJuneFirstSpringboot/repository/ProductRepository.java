package com.itp.ITPJuneFirstSpringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itp.ITPJuneFirstSpringboot.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

		@Query(value = "select * from product where price >=100",nativeQuery = true)
		public List<Product> getAllProductAboveRs100();
		
		@Query(value = "select * from product where price >=?1",nativeQuery = true)
		public List<Product> getAllProductAboveRsX(double x);
		
		public  List<Product> findByPriceGreaterThan(double value);
		
		public  List<Product> findByPriceBetween(double startPrice,double endPrice);
}
