package model;

import java.util.*;

public class ShoppingBasket {
	
     private List<Product> prod;
     public ShoppingBasket() {
		prod = new ArrayList<>();
	}
     
     // GetMethode
	public List<Product> getList() {
		return prod;
	}

	public void addProductToBasket(Product prod) {
		this.prod.add(prod);
	}
	
	public void removeProductFromBasket(Product prod) {
		this.prod.remove(prod);
	}
	
	@Override
	public String toString() {
		String products = "";
		products += "---- ShoppingBasket ----\n";
		
		for(int i = 0; i < prod.size(); i++){
			products += prod.get(i).toString() + "\n";
		}
		
		
		products +=  "---- Bon Appeti ----\n" ;
		return products;
	}

	public void changeProductsinBasket(Product product1, Product product2) {
		this.prod.remove(product1);
		this.prod.add(product2);
	}
     
     
     
     
    
}
