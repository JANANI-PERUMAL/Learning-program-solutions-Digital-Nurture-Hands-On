package com.example.supermarket.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supermarket.model.Users;
import com.example.supermarket.repo.Usersrepo;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class Userscontrol {
	@Autowired
	Usersrepo userepo;
	@GetMapping("/")
	List<Users> getall()
	{
		return userepo.findAll();
	}
	@PostMapping("/")
	void add(@RequestBody Users u)
	{
		if(userepo.findAll().size()==0)
		{
			u.setUserid("user1");
		}
		else
		{
			int r= userepo.findAll().size()-1;
			String s= userepo.findAll().get(r).getUserid().substring(4);
			int n= Integer.parseInt(s)+1;
			u.setUserid("user"+n);
		}
		userepo.save(u);
	}
	
	@PostMapping("/login")
	Users login(@RequestBody Users loginuser)
	{
		for (Users u : userepo.findAll()) 
		{
			if(u.getPassword()==loginuser.getPassword() && u.getUserid().equals(loginuser.getUserid())) 
			{
				return u;
			}
		}
		return null;
	}
}
