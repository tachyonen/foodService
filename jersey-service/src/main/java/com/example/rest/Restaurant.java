package com.example.rest;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Restaurant {

	private final long id;
	private static long id2;
	private String companyName;
	private String category;
	private String email;
	private static final AtomicLong counter = new AtomicLong(100);
	private ArrayList<Product> productList;
	
	
	public Restaurant(RestaurantBuilder builder){
		this.id = builder.id;
		this.companyName = builder.companyName;
		this.category = builder.category;
		this.email = builder.email;
		this.productList = builder.productList;
		
	}
	public Restaurant(){
		Restaurant res = new Restaurant.RestaurantBuilder().id().build();
		this.id = res.getID();
		this.companyName = res.getCompanyName();
		this.category = res.getCategory();
		this.email = res.getEmail();
		this.productList = res.getProductList();
	}
	
	public Restaurant(long id, String companyName, String category, String email){
		Restaurant res = new Restaurant.RestaurantBuilder().id()
				.companyName(companyName)
				.category(category)
				.email(email)
				.build();
		this.id = res.getID();
		this.companyName = res.getCompanyName();
		this.category = res.getCategory();
		this.email = res.getEmail();
	}
	
	//test Konstruktor
	public Restaurant(String companyName, String category, String email, Product product){
		this.companyName = companyName;
		this.category = category;
		this.email = email;
		productList.add(product);
		id2++;
		id=id2;
	}
	
	public Restaurant(String companyName, String category, String email){
		this.companyName = companyName;
		this.category = category;
		this.email = email;
		id2++;
		id=id2;
	}
	
	public void addProduct(String name, String category, double weight, double price, String productInfo){
		productList.add(new Product(name, category, weight, price, productInfo));
	}
	
	public void addProduct(Product product){
		productList.add(product);
	}
	
	public ArrayList<Product> getProductList(){
		return this.productList;
	}
	
	//Getter
	public long getID(){
		return this.id;
	}
	
	public String getCompanyName(){
		return this.companyName;
	}
	
	public String getCategory(){
		return this.category;
	}
	
	public String getEmail(){
		return this.email;
	}
	@Override
	public String toString(){
		return "ID:\t\t" + id + "\n"
				+ "Company Name:\t" + companyName + "\n"
				+ "Category:\t" + category + "\n"
				+ "Email:\t\t" + email +"\n";
	}
	
	public String productListToString(){
		int j = productList.size();
		int z = 0;
		String tempListString = "";
		for(int i = 0; i < j; i++){
			z++;
			tempListString += "\n" + z + ". Product:\n";
			tempListString += productList.get(i).toString();
		}
		return "\n\n---List of Products---\n" + tempListString;
	}
	
	public static class RestaurantBuilder{
		private long id;
		private String companyName = "";
		private String category = "";
		private String email = "";
		private ArrayList<Product> productList;
	
		
		public RestaurantBuilder id(){
			this.id = Restaurant.counter.getAndIncrement();
			return this;
		}
		
		public RestaurantBuilder id(long id){
			this.id = id;
			return this;
		}
		
		public RestaurantBuilder companyName(String companyName){
			this.companyName = companyName;
			return this;
		}
		public RestaurantBuilder category(String cate ){
			this.category = cate;
			return this;
		}
		public RestaurantBuilder email(String email){
			this.email = email;
			return this;
		}
		
		
		public RestaurantBuilder productList(ArrayList<Product> productList){
			this.productList = productList;
			return this;
		}
		public Restaurant build(){
			return new Restaurant(this);
		}
	}
}
