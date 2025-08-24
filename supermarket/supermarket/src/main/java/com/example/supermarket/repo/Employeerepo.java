package com.example.supermarket.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.supermarket.model.Employee;

public interface Employeerepo extends JpaRepository<Employee, String> {

}
