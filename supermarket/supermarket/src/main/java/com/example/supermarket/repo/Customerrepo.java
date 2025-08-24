package com.example.supermarket.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.supermarket.model.Customer;

public interface Customerrepo extends JpaRepository<Customer, String>{

}
