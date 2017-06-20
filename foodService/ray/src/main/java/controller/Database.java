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
	static public Hashtable<Long, Product> prodChinaShushi = new Hashtable<>();
	static public Hashtable<Long, Product> prodJapanSushi = new Hashtable<>();
	static public Hashtable<Long, Product> prodNuclearSushi = new Hashtable<>();
	static public Hashtable<Long, Restaurant> rest = new Hashtable<>();
	static public Hashtable<Long, ShoppingBasket> bak = new Hashtable<>();
	
	static {
		cust.put((long) 0, new Customer("Michael", "Kohl", "x", "09", "alpha", "beta"));
	}
	
	static {
		rest.put((long) 0, new Restaurant("China Sushi", "Regenbogenstraße 11", "06968", "cSushi", "s", true));
		rest.put((long) 1, new Restaurant("Japan Sushi", "Regenbogenstraße 11", "06968", "cSushi", "s", true));
		rest.put((long) 2, new Restaurant("Nuclear Sushi", "Regenbogenstraße 11", "06968", "cSushi", "s", true));
		
		
		prodChinaShushi.put((long) 0, new Product( "Lachs Nigiri","Nigiri mit Lachs", 0.3, 5.99 ));
		prodChinaShushi.put((long) 1, new Product( "Gurken Maki","Maki mit Gurke", 0.3, 2.99 ));
		prodChinaShushi.put((long) 2, new Product( "Lachs Maki","Maki mit Lachs", 0.3, 3.99 ));
		prodChinaShushi.put((long) 3, new Product( "Thunfisch Maki","Maki mit Thunfisch", 0.3, 3.99 ));
		
		
		prodJapanSushi.put((long) 0, new Product( "Lachs Nigiri","Nigiri mit Lachs aus Japan", 0.3, 5.99 ));
		prodJapanSushi.put((long) 1, new Product( "Gurken Maki","Maki mit Gurke aus Japan", 0.3, 2.99 ));
		prodJapanSushi.put((long) 2, new Product( "Lachs Maki","Maki mit Lachs aus Japan", 0.3, 3.99 ));
		prodJapanSushi.put((long) 3, new Product( "Thunfisch Maki","Maki mit Thunfisch aus Japan", 0.3, 3.99 ));
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
	
	// Getter für jedes einzelne Restaurant
	public static Product getProductChinaShushi(long id) {
		return prodChinaShushi.get(id);
	}
	
	public static Product getProductJapanSushi(long id){
		return prodJapanSushi.get(id);
	}
	
	public boolean checkCustomer(long id) {
		Customer customer = cust.get(id);
		if(customer == null) {
			return false;
		}
		else return true;
	}
	
	public static boolean checkCustomer(String email, String passwort) {
	
        Set<Long> keys = cust.keySet();
        for(Long key: keys){
           Customer local = cust.get(key);
           if(local.geteMail().equals(email) && local.getPasswort().equals(passwort))return true;
           else continue;
        //Iterating through the HashTable//
        }
        return false;
	}
	
	public boolean checkRestaurant( long id){
		Restaurant restaurant = rest.get(id);
		if( restaurant == null){
			return false;
		}
		return true;
	}
}
