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

import com.example.supermarket.dto.Purchaserequest;
import com.example.supermarket.model.Product;
import com.example.supermarket.model.Purchase;
import com.example.supermarket.model.Purchasedetaile;
import com.example.supermarket.repo.Purchaserepo;
import com.example.supermarket.repo.Productrepo;
import com.example.supermarket.repo.Purchasedetailrepo;

@RestController
@CrossOrigin
@RequestMapping("/purchase")
public class Puchasecontrol {
	@Autowired
	Purchaserepo prepo;
	@Autowired
	Purchasedetailrepo pdrepo;
	@Autowired
	Productrepo prorepo;
	@GetMapping("/") 
	List<Purchase> getall()
	{
		return prepo.findAll();
	}
	@PostMapping("/")
	void add(@RequestBody Purchase p)
	{
		prepo.save(p);
		
	}
	Product getstockprice(int stockid)
	{
		for(Product p:prorepo.findAll())
		{
			if(p.getProductid()==stockid)
			{
				return p;
			}
		}
		return null;
	}
	
	@PostMapping("/addbill")
	void addorignal(@RequestBody Purchaserequest pq)
	{
		Purchase pr= prepo.save(pq.getPurchase());
		int gt=0;
		for(Purchasedetaile d:pq.getPurchasedetail())
		{
			d.setBillno(pr.getBillno());
			Product x= getstockprice(d.getProductid());
			int r=x.getCp()*d.getQuantity();
			d.setTotal(r);
			gt+=r;
			x.setQuantity(x.getQuantity()+d.getQuantity());
			pdrepo.save(d);
			prorepo.save(x);
		}
		pr.setGtotal(gt);
		prepo.save(pr);
	}
	@DeleteMapping("/{i}")
	String deletebyid (@PathVariable int i)
	{
		String s = "Deleted success";
		try
		{
			prepo.deleteById(i);
		}
		catch(Exception e)
		{
			s=e+"";
		}
		return s;
	}
	@PutMapping("/{i}")
	void edit (@RequestBody Purchase p,@PathVariable int i)
	{
		p.setBillno(i);
		prepo.save(p);
	}
	@GetMapping("/{i}")
	Optional<Purchase> getone(@PathVariable int i)
	{
		return prepo.findById(i);
	}

}
