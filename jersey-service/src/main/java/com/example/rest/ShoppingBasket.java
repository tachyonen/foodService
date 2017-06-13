package com.example.rest;

import java.util.ArrayList;

public class ShoppingBasket {

	private static long id = 0;
	private double totalPrice;
	private int quantity;
	private double weight;
	private ArrayList<Product> productList;
	private ArrayList<Integer> testList;
	
	public ShoppingBasket(){
		id++;
	}
	
	public void addProduct(Product Product){
		sumPrice();
		quantity = productList.size();
	}
	
	public void sumPrice(){
		int j = productList.size();
		for(int i=0; i < j; i++){
			totalPrice += productList.get(i).getPrice();
		}
	}
	
	public void sumWeight(){
		int j = productList.size();
		for(int i=0; i < j; i++){
			weight += productList.get(i).getWeight();
		}
	}
}