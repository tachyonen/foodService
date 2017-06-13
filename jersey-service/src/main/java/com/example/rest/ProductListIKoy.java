package com.example.rest;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ProductListIKoy {
	
	private static final CopyOnWriteArrayList<ProductIkoy> pIkList = new CopyOnWriteArrayList<>();

	static{
		
		pIkList.add(
			new ProductIkoy.ProductIkoyBuilder().id()
			.name("California Maki")
			.info("California Roll")
			.prize(9)
			.volume(1)
			.build()
				
				);
		pIkList.add(
			new ProductIkoy.ProductIkoyBuilder().id()
			.name("Sake")
			.info("Nigiri Lachs")
			.prize(8)
			.volume(1)
			.build()
				);
		pIkList.add(
			new ProductIkoy.ProductIkoyBuilder().id()
			 .name("Maguro")
			 .info("Nigiri Tuhnfisch")
			 .prize(5)
			 .volume(1)
			 .build()
			
				);
		
	}
	
	private ProductListIKoy(){}
	
	 public static CopyOnWriteArrayList<ProductIkoy> getInstance(){
		    return pIkList;
		  }
	 
	 
	  public static void testList(){
		    CopyOnWriteArrayList<ProductIkoy> list = ProductListIKoy.getInstance();
		    list.stream()
		        .forEach(i -> System.out.println(i));
		    String cString = 
		        list.stream()
		        .map( c -> c.toString())
		        .collect(Collectors.joining("\n"));
		    System.out.println(cString);
		  }
		    
		  public static void main(String[] args) {
		    ProductListIKoy.testList();
		  }
}
