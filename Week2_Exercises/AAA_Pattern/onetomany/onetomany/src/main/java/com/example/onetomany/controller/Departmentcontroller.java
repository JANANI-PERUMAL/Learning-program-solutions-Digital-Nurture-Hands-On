package com.example.onetomany.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetomany.model.Department;

import com.example.onetomany.service.Departmentservice;
@RestController
@CrossOrigin
public class Departmentcontroller
{
	@Autowired
    private Departmentservice departmentService;

    @PostMapping("/")
    public Department addDept(@RequestBody Department dept) {
        return departmentService.saveDepartment(dept);
    }

    @GetMapping("/")
    public List<Department> getAllDept() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDeptById(@PathVariable Integer id) {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteDept(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
        return "Department with ID " + id + " deleted.";
    }
}
/*@RestController
@CrossOrigin
public class Departmentcontroller 
{
	@Autowired
	Departmentrepo deptrepo;
	 @PostMapping("/")
	    public Department addDept(@RequestBody Department dept) 
	 	{
	        return deptrepo.save(dept);
	    }

	    @GetMapping("/")
	    public List<Department> getAllDept() 
	    {
	        return deptrepo.findAll();
	    }
}

/*{
	  "name": "IT Department",
	  "employees": [
	    { "name": "Alice", "role": "Developer" },
	    { "name": "Bob", "role": "Tester" }
	  ]		
	}
*/
