package com.itp.ITPJuneFirstSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.ITPJuneFirstSpringboot.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
