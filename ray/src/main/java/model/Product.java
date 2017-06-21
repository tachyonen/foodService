package model;

public class Product {
	private static long counter = 0;
	private final long id;
	private String name;
	private String productInfomation;
	private double volume;
	private double price;

	public Product() {
		this.id = counter++;
		this.name = "default name";
		this.productInfomation = "default information";
		this.volume = 0.0;
		this.price = 0.0;
	}

	public static long getCounter() {
		return counter;
	}

	public static void setCounter(long counter) {
		Product.counter = counter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductInfomation() {
		return productInfomation;
	}

	public void setProductInfomation(String productInfomation) {
		this.productInfomation = productInfomation;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public Product(String name, String info, double vol, double price) {
		this.id = counter++;
		this.name = name;
		this.productInfomation = info;
		this.volume = vol;
		this.price = price;
	}

	@Override
	public String toString() {

		return "---- Product -----" + "\n" 
		        + "ID:" + this.id + "\n" 
				+ "Name: " + this.name + "\n" + 
		        "Info: " + this.productInfomation + "\n" 
				+ "Volume: " + this.volume + "\n" 
				+ "Price: " + this.price + "\n";
	}
}
