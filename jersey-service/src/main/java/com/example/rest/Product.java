package com.example.rest;

public class Product {
	
	private static long id= 0;
	private String name;
	private String category;
	private double weight;
	private double price;
	private String productInfo;
	
	
	public Product(){
		id++;
	}
	
	public Product(String name, String category, double weight, double price, String productInfo){
		this.name = name;
		this.category = category;
		this.weight = weight;
		this.price = price;
		this.productInfo = productInfo;
		id++;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public double getWeight(){
		return this.weight;
	}
	
	@Override
	public String toString(){
		return "ID:\t\t" + id +
				"\nName:\t\t" + name + 
				"\nCategory:\t" + category + 
				"\nWeight:\t\t" + weight + 
				"\nPrice:\t\t" +  price + 
				"\nProductInfo:\t" + productInfo;
	}
}
