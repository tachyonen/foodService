package com.example.rest;

import java.util.concurrent.atomic.AtomicLong;

public class Restaurant {

	private final long id;
	private String companyName;
	private String category;
	private String email;
	private static final AtomicLong counter = new AtomicLong(100);
	
	
	public Restaurant(RestaurantBuilder builder){
		this.id = builder.id;
		this.companyName = builder.companyName;
		this.category = builder.category;
		this.email = builder.email;
		
	}
	public Restaurant(){
		Restaurant res = new Restaurant.RestaurantBuilder().id().build();
		this.id = res.getID();
		this.companyName = res.getCompanyName();
		this.category = res.getCategory();
		this.email = res.getEmail();
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
		return "ID: " + id + "\n"
				+ "Company Name: " + companyName + "\n"
				+ "Category: " + category + "\n"
				+ "Email: " + email +"\n";
				
	}
	
	public static class RestaurantBuilder{
		private long id;
		private String companyName = "";
		private String category = "";
		private String email = "";
	
		
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
		public Restaurant build(){
			return new Restaurant(this);
		}
	}
}
