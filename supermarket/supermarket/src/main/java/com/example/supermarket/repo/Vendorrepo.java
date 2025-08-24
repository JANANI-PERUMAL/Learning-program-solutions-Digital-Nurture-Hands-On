package com.example.supermarket.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.supermarket.model.Vendor;

public interface Vendorrepo extends JpaRepository<Vendor, String> {

}
