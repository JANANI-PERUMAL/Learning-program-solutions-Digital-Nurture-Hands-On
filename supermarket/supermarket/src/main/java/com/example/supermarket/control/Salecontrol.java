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

import com.example.supermarket.dto.Salerequest;
import com.example.supermarket.model.Product;

import com.example.supermarket.model.Sale;
import com.example.supermarket.model.Saledetaile;
import com.example.supermarket.repo.Productrepo;

import com.example.supermarket.repo.Saledetailrepo;
import com.example.supermarket.repo.Salerepo;

@RestController
@CrossOrigin
@RequestMapping("/sale")
public class Salecontrol {
	@Autowired
	Salerepo srepo;
	@Autowired
	Saledetailrepo saledrepo; 
	@Autowired
	Productrepo prorepo; 
	@GetMapping("/") 
	List<Sale> getall()
	{
		return srepo.findAll();
	}
	@PostMapping("/")
	void add(@RequestBody Sale s)
	{
		srepo.save(s);
		
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
	@PostMapping("/addsalebill")
	String saleadd(@RequestBody Salerequest sr)
	{
		Sale s= srepo.save(sr.getSale());
		int gt=0; 
		for(Saledetaile sd: sr.getSaledetail())
		{
			sd.setBillno(s.getBillno());
			Product x= getstockprice(sd.getProductid());
			 if ( x.getQuantity() >= sd.getQuanity() )
			 {
				 int r =x.getSp()*sd.getQuanity();
			
				 sd.setTotal(r);
					gt+=r;
					x.setQuantity(x.getQuantity()-sd.getQuanity());
					saledrepo.save(sd);
					prorepo.save(x);	           
		     }
			 else
			 {
				 return "out of stock";
			 }
		}
		s.setGtotal(gt);
		srepo.save(s);
		return null ;
	}
	@DeleteMapping("/{i}")
	String deletebyid (@PathVariable int i)
	{
		String s = "Deleted success";
		try
		{
			srepo.deleteById(i);
		}
		catch(Exception e)
		{
			s=e+"";
		}
		return s;
	}
	@PutMapping("/{i}")
	void edit (@RequestBody Sale s,@PathVariable int i)
	{
		s.setBillno(i);
		srepo.save(s);
	}
	@GetMapping("/{i}")
	Optional<Sale> getone(@PathVariable int i)
	{
		return srepo.findById(i);
	}

}
