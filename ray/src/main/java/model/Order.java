package model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Order {
	private static String banane;

	public Order() {
      this.banane = new String();
	}

	public Order(String banane) {
          this.banane = banane;
	}

	public String getBanane() {
		return banane;
	}
	
	public void setBanane(String x) {
		this.banane = x;
	}

}
