package com.example.supermarket.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.supermarket.model.Sale;

public interface Salerepo extends JpaRepository<Sale, Integer>{

}
