package com.example.rest;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class RestaurantList {
	
	private static final CopyOnWriteArrayList<Restaurant> rList = new CopyOnWriteArrayList<>();

	static {
		// create list of Restaurant
		
		rList.add(
				new Restaurant.RestaurantBuilder().id()
				.companyName("McDonalds")
				.category("FastFood")
				.email("McDonadls@aol.de")
				.build()
				
				);
		
		rList.add(
				new Restaurant.RestaurantBuilder().id()
				.companyName("BestWoschtinTown")
				.category("FastFood")
				.email("BestWoscht@aol.de")
				.build()
				);
		
		rList.add(
				new Restaurant.RestaurantBuilder().id()
				.companyName("IKoy")
				.category("Sushi")
				.email("IKoy@aol.de")
				.build()
				);
		
		rList.add(
				new Restaurant.RestaurantBuilder().id()
				.companyName("PizzaPronto")
				.category("Pizzaria")
				.email("Pizza@aol.de")
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
