package com.example.supermarket.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supermarket.model.Employee;
import com.example.supermarket.repo.Employeerepo;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class Employeecontrol {
	@Autowired
	Employeerepo erepo;
	@GetMapping("/")
	List<Employee> getall()
	{
		return erepo.findAll();
	}
	@PostMapping("/")
	void add(@RequestBody Employee e)
	{
	    if(erepo.findAll().size()==0)
	    {
	    	e.setEid("empo1");
	    }
	    else
	    {
	    	int x= erepo.findAll().size()-1;
	    	String s= erepo.findAll().get(x).getEid().substring(4);
	    	int n= Integer.parseInt(s)+1;
	    	e.setEid("empo"+n);
	    }
	    erepo.save(e);
	}
	@DeleteMapping("/{i}")
	String deletebyid (@PathVariable String i )
	{
		String s="Delete success";
		try
		{
			erepo.deleteById(i);
		}
		catch(Exception e)
		{
			s=e+"";
		}
		return s;
	}
	@PutMapping("/{i}")
	void edit(@RequestBody Employee e,@PathVariable String i)
	{
		e.setEid(i);
		erepo.save(e);
	}
	@GetMapping("/{i}")
	Optional<Employee> getone(@PathVariable String i)
	{
		return erepo.findById(i);
	}

}
