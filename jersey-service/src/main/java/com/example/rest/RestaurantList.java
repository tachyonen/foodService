package com.example.rest;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class RestaurantList {
	
	private static final CopyOnWriteArrayList<Restaurant> rList = new CopyOnWriteArrayList<>();

	static {
		// create list of Restaurant
		
		ArrayList<Product> productList1 = new ArrayList<Product>();
		productList1.add(new Product("Chickenburger", "Burger", 0.1, 1.5, "Chickenflesh"));
		
		ArrayList<Product> productListWoscht = new ArrayList<Product>();
		productListWoscht.add(new Product("Currywurst", "Wurst", 0.1, 3.5, "Hot Currywurst"));
		
		rList.add(
				new Restaurant.RestaurantBuilder().id()
				.companyName("McDonalds")
				.category("FastFood")
				.email("McDonadls@aol.de")
				.productList(productList1)
				.build()
				);
		
		rList.add(
				new Restaurant.RestaurantBuilder().id()
				.companyName("BestWoschtinTown")
				.category("FastFood")
				.email("BestWoscht@aol.de")
				.productList(productListWoscht)
				.build()
				);
		
		rList.add(
				new Restaurant.RestaurantBuilder().id()
				.companyName("IKoy")
				.category("Sushi")
				.email("IKoy@aol.de")
				.productList(productList1)
				.build()
				);
		
		rList.add(
				new Restaurant.RestaurantBuilder().id()
				.companyName("PizzaPronto")
				.category("Pizzaria")
				.email("Pizza@aol.de")
				.productList(productList1)
				.build()
				);
	}
	
	private RestaurantList(){}
	
	  public static CopyOnWriteArrayList<Restaurant> getInstance(){
		    return rList;
		  }
	  public static void testList(){
		    CopyOnWriteArrayList<Restaurant> list = RestaurantList.getInstance();
		    list.stream()
		        .forEach(i -> System.out.println(i));
		    String cString = 
		        list.stream()
		        .map( c -> c.toString())
		        .collect(Collectors.joining("\n"));
		    System.out.println(cString);
		  }
	  
	  public static void main(String[] args) {
		    RestaurantList.testList();
		  }
}
