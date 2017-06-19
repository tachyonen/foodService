package model;

public class Restaurant {
	long id;
	String name;
	boolean open = false;

	
	public Restaurant(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Restaurant(long id, String name, boolean open) {
		this.id = id;
		this.name = name;
		this.open = open;
	}
	@Override 
	public String toString() {
		return "ID: " + id
				+ "\nName: " + name;
	}
	
}
