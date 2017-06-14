package com.example.rest;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class RestaurantList {
	
	private static final CopyOnWriteArrayList<Restaurant> rList = new CopyOnWriteArrayList<>();

	static {
		// create list of Restaurant
		
		//Productlist of McDonald
		ArrayList<Product> productListMc = new ArrayList<Product>();
		productListMc.add(new Product("Chickenburger", "Burger", 0.2, 1.5, "Chickenflesh"));
		productListMc.add(new Product("Cheeseburger", "Burger", 0.2, 1.29, "Pattie and Cheese"));
		productListMc.add(new Product("Big Mac", "Burger", 0.4, 3.29, "2 Patties, cheese, cucumber, salad and tomato"));
		productListMc.add(new Product("Caesar Salad", "Salad", 0.2, 1.99, "Caesar Salad"));
		
		//Productlist of Best Woscht in Town
		ArrayList<Product> productListWoscht = new ArrayList<Product>();
		productListWoscht.add(new Product("Currywurst", "Sausage", 0.1, 3.5, "Hot Currywurst"));
		productListWoscht.add(new Product("Wiener Wurst", "Sausage", 0.1, 3.5, "Hot Wiener Wurst"));
		productListWoscht.add(new Product("Currywurst Hotness F", "Sausage", 0.1, 3.5, "Very hot currywurst"));
		
		//Productlist of IKoy
		ArrayList<Product> productListIkoy = new ArrayList<Product>();
		productListIkoy.add(new Product("Tuna Maki", "Sushi", 0.1, 0.99, "Small Tuna Sushi"));
		productListIkoy.add(new Product("Maki Plate", "Sushi", 0.7, 4.99, "Different Makis on a Plate"));
		
		//Productist PizzaPronto
		ArrayList<Product> productListPronto = new ArrayList<Product>();
		productListPronto.add(new Product("Piiza Margarita", "Pizza", 0.4, 4.99, "Basic Margarita Pizza"));
		productListPronto.add(new Product("Pizza Hawaii", "Pizza", 0.4, 6.99, "Pizza with pineapple and ham"));
		productListPronto.add(new Product("Pizza Salami", "Pizza", 0.4, 5.99, "Pizza with salami"));
		productListPronto.add(new Product("Spaghetti", "Pasta", 0.4, 6.49, "Spaghetti with tomatosauce"));
		
		rList.add(
				new Restaurant.RestaurantBuilder().id()
				.companyName("McDonalds")
				.category("FastFood")
				.email("McDonadls@aol.de")
				.productList(productListMc)
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
				.productList(productListIkoy)
				.build()
				);
		
		rList.add(
				new Restaurant.RestaurantBuilder().id()
				.companyName("PizzaPronto")
				.category("Pizzaria")
				.email("Pizza@aol.de")
				.productList(productListPronto)
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
