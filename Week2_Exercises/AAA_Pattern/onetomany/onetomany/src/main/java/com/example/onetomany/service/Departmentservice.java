package com.example.onetomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onetomany.model.Department;
import com.example.onetomany.repo.Departmentrepo;
@Service
public class Departmentservice {
	@Autowired
    private Departmentrepo departmentrepo;

    public List<Department> getAllDepartments() {
        return departmentrepo.findAll();
    }

    public Department getDepartmentById(Integer id) {
        return departmentrepo.findById(id).orElse(null);
    }

    public Department saveDepartment(Department department) {
        return departmentrepo.save(department);
    }

    public void deleteDepartment(Integer id) {
        departmentrepo.deleteById(id);
    }
}


