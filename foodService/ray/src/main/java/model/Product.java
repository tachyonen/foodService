package model;



public class Product {
      long id;
      String name;
      String productInfomation;
      double volume;
      double price;
      static int counter = 1;
      
      public Product() {
    	  this.id = counter;
    	  this.name = "default name";
    	  this.productInfomation = "default information";
    	  this.volume = 0.0;
    	  this.price = 0.0;	
    	  counter++;
	}
     public Product( String name, String info, double vol, double price){
    	 this.id = counter;
    	 this.name = name;
    	 this.productInfomation = info;
    	 this.volume = vol;
    	 this.price = price;
    	 counter++;
     }
     
     
     @Override
    public String toString() {
    
    	return "---- Product -----"+ "\n"
    			+ "ID:" + id + "\n"
    			+ "Name: " + name + "\n"
    			+ "Info: " + productInfomation + "\n"
    			+ "Volume: " + volume + "\n"
    			+ "Price: " + price + "\n";
    }
}
