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

import com.example.supermarket.model.Product;
import com.example.supermarket.repo.Productrepo;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class Productcontrol {
	@Autowired
	Productrepo prorepo;
	
	@GetMapping("/")
	List<Product> getall()
	{
		return prorepo.findAll();
	}
	@PostMapping("/")
	void add(@RequestBody Product pr)
	{
		prorepo.save(pr);
	}
	@DeleteMapping("/{i}")
	String deletebyid (@PathVariable int i)
	{
		String s= "delete";
		try
		{
			prorepo.deleteById(i);
		}
		catch(Exception e)
		{
			s=e+"";
		}
		return s;
	}
	@PutMapping("/{i}")
	void edit (@RequestBody Product pr,@PathVariable int i) 
	{
		pr.setProductid(i);
		prorepo.save(pr);
	}
	@GetMapping("/{i}")
	Optional<Product> getone(@PathVariable int i)
	{
		return prorepo.findById(i);
	}

}
