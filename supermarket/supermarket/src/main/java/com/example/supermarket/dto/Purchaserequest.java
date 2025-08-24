package com.example.supermarket.dto;

import java.util.ArrayList;

import com.example.supermarket.model.Purchase;
import com.example.supermarket.model.Purchasedetaile;

public class Purchaserequest {
	private Purchase purchase;
	private ArrayList<Purchasedetaile> purchasedetail;
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	public ArrayList<Purchasedetaile> getPurchasedetail() {
		return purchasedetail;
	}
	public void setPurchasedetail(ArrayList<Purchasedetaile> purchasedetail) {
		this.purchasedetail = purchasedetail;
	}
	
	

}
