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

import com.example.supermarket.model.Purchasedetaile;
import com.example.supermarket.repo.Purchasedetailrepo;

@RestController
@CrossOrigin
@RequestMapping("/purchasedetail")
public class Puchasedetailcontrol {
	@Autowired
	Purchasedetailrepo pdrepo;
	@GetMapping("/") 
	List<Purchasedetaile> getall()
	{
		return pdrepo.findAll();
	}
	@PostMapping("/")
	void add(@RequestBody Purchasedetaile pd)
	{
		pdrepo.save(pd);
		
	}
	@DeleteMapping("/{i}")
	String deletebyid (@PathVariable int i)
	{
		String s = "Deleted success";
		try
		{
			pdrepo.deleteById(i);
		}
		catch(Exception e)
		{
			s=e+"";
		}
		return s;
	}
	@PutMapping("/{i}")
	void edit (@RequestBody Purchasedetaile pd,@PathVariable int i)
	{
		pd.setPdid(i);
		pdrepo.save(pd);
	}
	@GetMapping("/{i}")
	Optional<Purchasedetaile> getone(@PathVariable int i)
	{
		return pdrepo.findById(i);
	}

}
