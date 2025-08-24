package com.example.supermarket.dto;

import java.util.ArrayList;

import com.example.supermarket.model.Sale;
import com.example.supermarket.model.Saledetaile;

public class Salerequest {
	private Sale sale;
	private ArrayList<Saledetaile> saledetail;
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public ArrayList<Saledetaile> getSaledetail() {
		return saledetail;
	}
	public void setSaledetail(ArrayList<Saledetaile> saledetail) {
		this.saledetail = saledetail;
	}

}
