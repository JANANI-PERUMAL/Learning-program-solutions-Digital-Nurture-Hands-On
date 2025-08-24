package com.example.supermarket.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Users {
	@Id 
	String userid;
	String name,roll;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	int phoneno,password;
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}

}
