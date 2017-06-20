package model;

import java.util.*;

public class ShoppingBasket {
	
     private static List<Product> prod;
     public ShoppingBasket() {
		prod = new ArrayList<>();
	}
     
     // GetMethode
	public static List<Product> getProd() {
		return prod;
	}

	@Override
	public String toString() {
		
		System.out.println("---- ShoppingBasket ----");
		
		for(int i = 0; i < prod.size(); i++){
			System.out.println(prod.get(i).toString());
		}
		
		
		return "---- Bon Appeti ----\n" ;
	}
     
     
     
     
    
}
