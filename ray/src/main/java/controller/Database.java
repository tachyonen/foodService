 package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import model.*;


public class Database {
	
	static public Hashtable<Long, Customer> cust = new Hashtable<>();
	static public Map<Long, Order> ord = new HashMap<>();
	static public Map<Long, Product> prod = new HashMap<>();
	static public Hashtable<Long, Restaurant> rest = new Hashtable<>();
	static public Map<Long, ShoppingBasket> bak = new HashMap<>();
	
	static {
		rest.put((long) 0, new Restaurant(0, "China Sushi", true));
		rest.put((long) 1, new Restaurant(1, "Japan Sushi", true));
		rest.put((long) 2, new Restaurant(2, "Nuclear Sushi", false));
	}
	
	public Customer getCustomer(long id) {
		return cust.get(id);
	}
	
	public Restaurant getRestaurant(long id) {
		return rest.get(id);
	}
	
	public Order getOrder(long id) {
		return ord.get(id);
	}
	
	public ShoppingBasket getShoppingBasket(long id) {
		return bak.get(id);
	}
	
	public Product getProduct(long id) {
		return prod.get(id);
	}
	
	public boolean checkCustomer(long id) {
		Customer customer = cust.get(id);
		if(customer == null) {
			return false;
		}
		else return true;
	}
}
