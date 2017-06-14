package com.example.rest;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
public class DriverList {
	
	private static final CopyOnWriteArrayList<Driver> dList = new CopyOnWriteArrayList<>();
	
	static{
		
		dList.add(
				new Driver.DriverBuilder().driverId()
				.driverFirstName("Peter")
				.driverLastName("Baldauf")
				.driverEmail("dermiesepeter@aol.de")
				.driverAdress("Weg 5")
				.driverPhone("01745687456")
				.build()	
				);
		
		
		dList.add(
				new Driver.DriverBuilder().driverId()
				.driverFirstName("Firat")
				.driverLastName("Bostan")
				.driverEmail("FiratBostan@aol.de")
				.driverAdress("Weg 9")
				.driverPhone("01745683456")
				.build()	
				);
		
		dList.add(
				new Driver.DriverBuilder().driverId()
				.driverFirstName("Piran")
				.driverLastName("Chachi")
				.driverEmail("PiranC@aol.de")
				.driverAdress("Straße 1")
				.driverPhone("0174564556")
				.build()	
				);
		dList.add(
				new Driver.DriverBuilder().driverId()
				.driverFirstName("Japhet")
				.driverLastName("Fetewi")
				.driverEmail("Tachion@web.de")
				.driverAdress("Unter der Brücke 123")
				.driverPhone("0174349556")
				.build()	
				);		
	}
	
	private DriverList(){}

	public static CopyOnWriteArrayList<Driver> getInstance(){
		return dList;
	}
	public static void TestList(){
	    CopyOnWriteArrayList<Driver> list = DriverList.getInstance();
	    list.stream()
	        .forEach(i -> System.out.println(i));
	    String cString = 
	        list.stream()
	        .map( c -> c.toString())
	        .collect(Collectors.joining("\n"));
	    System.out.println(cString);
	  }
  
	public static void main(String[] args) {
	    RestaurantList.testList();
	  }	
}
