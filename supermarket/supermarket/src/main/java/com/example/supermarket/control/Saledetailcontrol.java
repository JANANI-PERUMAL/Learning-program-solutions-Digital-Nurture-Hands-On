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


import com.example.supermarket.model.Saledetaile;

import com.example.supermarket.repo.Saledetailrepo;

@RestController
@CrossOrigin
@RequestMapping("/saledetail")
public class Saledetailcontrol {
	@Autowired
	Saledetailrepo salerepo;
	@GetMapping("/") 
	List<Saledetaile> getall()
	{
		return salerepo.findAll();
	}
	@PostMapping("/")
	void add(@RequestBody Saledetaile sale)
	{
		salerepo.save(sale);
		
	}
	@DeleteMapping("/{i}")
	String deletebyid (@PathVariable int i)
	{
		String s = "Deleted success";
		try
		{
			salerepo.deleteById(i);
		}
		catch(Exception e)
		{
			s=e+"";
		}
		return s;
	}
	@PutMapping("/{i}")
	void edit (@RequestBody Saledetaile sale,@PathVariable int i)
	{
		sale.setSaldid(i);
		salerepo.save(sale);
	}
	@GetMapping("/{i}")
	Optional<Saledetaile> getone(@PathVariable int i)
	{
		return salerepo.findById(i);
	}

}
