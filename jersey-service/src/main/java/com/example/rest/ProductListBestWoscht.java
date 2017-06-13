package com.example.rest;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ProductListBestWoscht {
	
	private static final CopyOnWriteArrayList<ProductBestWoscht> pBeList = new CopyOnWriteArrayList<>();

	static{
	pBeList.add(
			new ProductBestWoscht.ProductBestWoschtBuilder().id()
			.name("Bratwurst")
			.info("Scharf")
			.prize(9)
			.volume(1)
			.build()
				
				);
		pBeList.add(
				new ProductBestWoscht.ProductBestWoschtBuilder().id()
			.name("Curry Wurst")
			.info("Mittel")
			.prize(8)
			.volume(1)
			.build()
				);
		pBeList.add(
				new ProductBestWoscht.ProductBestWoschtBuilder().id()
			 .name("Bratwurst")
			 .info("sehr scharf")
			 .prize(5)
			 .volume(1)
			 .build()
			
				);
		
		pBeList.add(
				new ProductBestWoscht.ProductBestWoschtBuilder().id()
				.name("Cola")
				.info("Getränk")
				.prize(7)
				.volume(1)
				.build()
				);
		
	}
	
	private ProductListBestWoscht(){}
	
	public static CopyOnWriteArrayList<ProductBestWoscht> getInstance(){
	    return pBeList;
	  }
	
	public static void testList(){
	    CopyOnWriteArrayList<ProductBestWoscht> list = ProductListBestWoscht.getInstance();
	    list.stream()
	        .forEach(i -> System.out.println(i));
	    String cString = 
	        list.stream()
	        .map( c -> c.toString())
	        .collect(Collectors.joining("\n"));
	    System.out.println(cString);
	  }
	    
	  public static void main(String[] args) {
	    ProductListBestWoscht.testList();
	  }
	
}
