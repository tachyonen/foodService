package model;


import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
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
	
	public Product(String name, String info, double vol, double price) {
		this.id = counter++;
		this.name = name;
		this.productInfomation = info;
		this.volume = vol;
		this.price = price;
	}

	@XmlElement
	public long getId() {
		return id;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getProductInfomation() {
		return productInfomation;
	}

	public void setProductInfomation(String productInfomation) {
		this.productInfomation = productInfomation;
	}

	@XmlElement
	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@XmlElement
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {

		return "---- Product -----" + "\n" + "ID:" + this.id + "\n" + "Name: " + this.name + "\n" + "Info: "
				+ this.productInfomation + "\n" + "Volume: " + this.volume + "\n" + "Price: " + this.price + "\n";
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (object instanceof Product) {
			Product product = (Product) object;
			if (product.getId() == this.getId())
				return true;
		}
		return false;

	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}
}
