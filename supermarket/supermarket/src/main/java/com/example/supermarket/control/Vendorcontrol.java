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

import com.example.supermarket.model.Vendor;
import com.example.supermarket.repo.Vendorrepo;

@RestController
@CrossOrigin
@RequestMapping("/vendor")
public class Vendorcontrol {
	@Autowired
	Vendorrepo vrepo;
	@GetMapping("/")
	List<Vendor> getall()
	{
		return vrepo.findAll();
	}
	@PostMapping("/")
	void add(@RequestBody Vendor v)
	{
		if(vrepo.findAll().size()==0)
		{
			v.setVid("ven1");
		}
		else
		{
			int r= vrepo.findAll().size()-1;
			String s= vrepo.findAll().get(r).getVid().substring(3);
			int n= Integer.parseInt(s)+1;
			v.setVid("ven"+n);
		}
	    vrepo.save(v);
	}
	@DeleteMapping("/{i}")
	String deletebyid (@PathVariable String i)
	{
		String s="deleted";
		try
		{
			vrepo.deleteById(i);
		}
		catch(Exception e)
		{
			s=e+"";
		}
		return s;
	}
	@PutMapping("/{i}")
	void edit(@RequestBody Vendor v,@PathVariable String i)
	{
		v.setVid(i);
		vrepo.save(v);
	}
	@GetMapping("/{i}")
	Optional<Vendor> getone(@PathVariable String i)
	{
		return vrepo.findById(i);
	}

}
