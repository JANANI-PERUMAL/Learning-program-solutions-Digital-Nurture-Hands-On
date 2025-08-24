package com.example.supermarket.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.supermarket.model.Product;

public interface Productrepo extends JpaRepository<Product, Integer>{

}
