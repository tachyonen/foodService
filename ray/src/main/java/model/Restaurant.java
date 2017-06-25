package model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class Restaurant {

	private static long counter = 0;
	private final long id;
	private String companyName;
	private String adress;
	private String phoneNumber;
	private String eMail;
	private String passwort;
	private boolean isOpen;
	private Hashtable<Long, Product> productList;

	public Restaurant(Restaurant rest) {
		this.id = rest.id;
		this.companyName = rest.companyName;
		this.adress = rest.adress;
		this.phoneNumber = rest.phoneNumber;
		this.eMail = rest.eMail;
		this.passwort = rest.passwort;
		this.productList = rest.productList;
	}

	public Restaurant(String companyName, String adress, String phoneNumber, String eMail, String passwort,
			boolean isOpen) {
		this.id = Restaurant.counter++;
		this.companyName = companyName;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
		this.passwort = passwort;
		this.isOpen = isOpen;
		this.productList = new Hashtable<>();
	}

	public Restaurant(String companyName, String adress, String phoneNumber, String eMail, String passwort,
			boolean isOpen, Hashtable<Long, Product> productList) {
		this.id = Restaurant.counter++;
		this.companyName = companyName;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
		this.passwort = passwort;
		this.isOpen = isOpen;
		this.productList = productList;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public long getId() {
		return id;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	@Override
	public String toString() {
		return "" + "\n" + "ID:" + this.id + "\n" + "Name: " + this.companyName + "\n" + "E-Mail: " + this.eMail + "\n"
				+ "Adresse: " + this.adress + "\n" + "Phone Number: " + this.phoneNumber + "\n";

	}

	public Hashtable<Long, Product> getProductList() {
		return productList;
	}

	public List<Product> getProductListasArrayList() {
		Set<Long> keys = this.productList.keySet();
		List<Product> productList = new ArrayList<>();
		for (Long key : keys) {
			productList.add(this.productList.get(key));
		}
		return productList;
	}
	
	public void addProduct(Product e) {
		this.productList.put(e.getId(), e);
	}
	
	public Product getProduct(long key) {
		return this.productList.get(key);
	}
	
	

}
