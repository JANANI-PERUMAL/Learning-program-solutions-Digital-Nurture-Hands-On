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

import com.example.supermarket.model.Customer;
import com.example.supermarket.repo.Customerrepo;


@RestController
@CrossOrigin
@RequestMapping("/customer")
public class Customercontrol {
	@Autowired
	Customerrepo crepo;
	@GetMapping("/")
	List<Customer> getall()
	{
		return crepo.findAll();
	}
	@PostMapping("/")
	void add(@RequestBody Customer c)
	{
		if(crepo.findAll().size()==0)
		{
			c.setCid("cus1");
		}
		else
		{
			int r= crepo.findAll().size()-1;
			String s= crepo.findAll().get(r).getCid().substring(3);
			int n= Integer.parseInt(s)+1;
			c.setCid("cus"+n);
		}
	    crepo.save(c);
	}
	@DeleteMapping("/{i}")
	String deletebyid (@PathVariable String i)
	{
		String s="deleted";
		try
		{
			crepo.deleteById(i);
		}
		catch(Exception e)
		{
			s=e+"";
		}
		return s;
	}
	@PutMapping("/{i}")
	void edit(@RequestBody Customer c , @PathVariable String i)
	{
		c.setCid(i);
		crepo.save(c);
	}
	@GetMapping("/{i}")
	Optional<Customer> getone(@PathVariable String i)
	{
		return crepo.findById(i);
	}
}
