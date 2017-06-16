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
		return "ID: " + id + "\n"
		  + "\nName: " + name + "\n";
	}
	
	public String toStringwithRef() {
		String id = String.valueOf(this.id);
		String link = "http://localhost:8080/ray/webapi/restaurant/" + id;
		String a = "<a href=\"" + link + "\"" + ">" + this.name + "</a>";
		return id + "\n" + a;
	}
	
	public boolean getOpen(){
		return this.open;
	}
}
