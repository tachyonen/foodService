package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import model.*;

public class Database {

	static public Hashtable<Long, Customer> cust = new Hashtable<>();
	static public Hashtable<Long, Order> ord = new Hashtable<>();
	static public Hashtable<Long, Restaurant> rest = new Hashtable<>();

	static {
		cust.put((long) 0, new Customer("Michael", "Kohl", "x", "09", "alpha", "beta"));
	}

	static {

		Product product0 = new Product("Lachs Nigiri", "Nigiri mit Lachs", 0.3, 5.99);
		Product product1 = new Product("Gurken Maki", "Maki mit Gurke", 0.3, 2.99);
		Product product2 = new Product("Lachs Maki", "Maki mit Lachs", 0.3, 3.99);
		Product product3 = new Product("Thunfisch Maki", "Maki mit Thunfisch", 0.3, 3.99);

		Restaurant restaurant = new Restaurant("China Sushi", "Regenbogenstrasse 11", "06968", "cSushi", "s", true);
		restaurant.addProduct(product0);
		restaurant.addProduct(product1);
		restaurant.addProduct(product2);
		restaurant.addProduct(product3);

		Restaurant restaurant2 = new Restaurant("Japan Sushi", "Regenbogenstrasse 11", "06968", "cSushi", "s", true);
		restaurant2.addProduct(product0);
		restaurant2.addProduct(product1);
		restaurant2.addProduct(product2);
		restaurant2.addProduct(product3);

		Restaurant restaurant3 = new Restaurant("Nuclear Sushi", "Regenbogenstrasse 11", "06968", "cSushi", "s", false);
		restaurant3.addProduct(product0);
		restaurant3.addProduct(product1);
		restaurant3.addProduct(product2);
		restaurant3.addProduct(product3);

		rest.put(restaurant.getId(), restaurant);
		rest.put(restaurant2.getId(), restaurant2);
		rest.put(restaurant3.getId(), restaurant3);
	}

	
	public static Customer getCustomer(long id) {
		return cust.get(id);
	}

	public static Restaurant getRestaurant(long id) {
		return rest.get(id);
	}

	public static Order getOrder(long id) {
		return ord.get(id);
	}

	public boolean checkCustomer(long id) {
		Customer customer = cust.get(id);
		if (customer == null) {
			return false;
		} else
			return true;
	}

	public static boolean doesCustomerExist(String email, String passwort) {

		Set<Long> keys = cust.keySet();
		for (Long key : keys) {
			Customer local = cust.get(key);
			if (local.geteMail().equals(email) && local.getPasswort().equals(passwort))
				return true;
			else
				continue;
			// Iterating through the HashTable//
		}
		return false;
	}

	public static Customer getCustomer(String email, String passwort) {

		Set<Long> keys = cust.keySet();
		for (Long key : keys) {
			Customer local = cust.get(key);
			if (local.geteMail().equals(email) && local.getPasswort().equals(passwort))
				return local;
			else
				continue;
			// Iterating through the HashTable//
		}
		return null;
	}

	public boolean checkRestaurant(long id) {
		Restaurant restaurant = rest.get(id);
		if (restaurant == null) {
			return false;
		}
		return true;
	}
}
