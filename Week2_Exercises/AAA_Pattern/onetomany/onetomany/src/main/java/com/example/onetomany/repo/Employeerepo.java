package com.example.onetomany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onetomany.model.Employee;

public interface Employeerepo extends JpaRepository<Employee,Integer>{

}
