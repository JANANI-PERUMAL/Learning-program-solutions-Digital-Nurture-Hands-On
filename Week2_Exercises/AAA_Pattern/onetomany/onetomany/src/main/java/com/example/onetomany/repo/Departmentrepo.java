package com.example.onetomany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onetomany.model.Department;

public interface Departmentrepo extends JpaRepository<Department,Integer> {

}
